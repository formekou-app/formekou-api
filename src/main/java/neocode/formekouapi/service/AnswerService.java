package neocode.formekouapi.service;

import lombok.AllArgsConstructor;
import neocode.formekouapi.exception.AccessDeniedException;
import neocode.formekouapi.exception.BadRequestException;
import neocode.formekouapi.model.*;
import neocode.formekouapi.repository.AnswerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final FormService formService;
    private static final String SEPARATOR_CHECKBOX = "---";

    public boolean canIRespond(String formId){
        Form form = formService.getFormById(formId);
        String userId = AuthService.getAuthentication().getUser().getId();
        boolean alreadyReply = answerRepository.findAllByUserIdAndQuestionFormId(userId, form.getId()).isEmpty();
        return !(form.isAllowMultipleChoice() && alreadyReply);
    }

    private static boolean isValidOption(Option option, String type, String value){
        if (Objects.requireNonNull(type).equals(QuestionType.CHECKBOX.toString())){
            return (
                    option.isCorrect() &&
                    Arrays.stream(value.split(SEPARATOR_CHECKBOX)).toList().contains(option.getValue())
            );
        }
        return option.isCorrect() && option.getValue().equals(value);
    }


    //TODO: not allow responses for multiple forms
    public List<Answer> saveAnswers(List<Answer> answers){
        if(answers.isEmpty())
            return null;

        if(!canIRespond(answers.get(0).getQuestion().getForm().getId())){
            throw new BadRequestException("Multiple response is not allowed for this forms !!");
        }

        return answerRepository.saveAll(answers);
    }

   public Answer calcAnswerPointAndStatus(Answer answer){
        Question question = answer.getQuestion();
        if(
                question.getType().equals(QuestionType.RADIO.toString()) ||
                question.getType().equals(QuestionType.CHECKBOX.toString())
        ){
            List<Option> optionValues = question.getOptions().stream().filter(option -> {
                return isValidOption(option, question.getType(), answer.getValue());
            }).toList();
            boolean isCorrect = !optionValues.isEmpty();
            answer.setStatus(isCorrect ? AnswerStatus.CORRECT.toString() : AnswerStatus.WRONG.toString());
            answer.setPoints(!isCorrect ? 0 :
                    optionValues.stream().map(Option::getPoints).reduce(0, Integer::sum)
            );
        }
        return answer;
    }

    public List<Answer> getByFormId(String formId, String sort){
        Form form = formService.getFormById(formId);
        User user = AuthService.getAuthentication().getUser();

        if(!sort.equals("updatedAt") && !sort.equals("createdAt")){
            throw new BadRequestException("Sort type error");
        }

        if(form.isPrivate() && !form.getUser().getId().equals(user.getId()))
            throw new AccessDeniedException("This results for that form is only visible for the owner");

        List<Answer> answers =  answerRepository.findAllByQuestionFormId(
                formId,
                Sort.by(sort).descending()
        );

        return answers.stream().map(this::calcAnswerPointAndStatus).toList();
    }
}
