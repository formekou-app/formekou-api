package neocode.formekouapi.service;

import lombok.AllArgsConstructor;
import neocode.formekouapi.model.Form;
import neocode.formekouapi.model.Question;
import neocode.formekouapi.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {
    private QuestionRepository questionRepository;
    private FormService formService;

    public List<Question> deleteAllByFormId(String formId){
        return questionRepository.deleteAllByFormId(formId);
    }

    public List<Question> setFormQuestions(String formId, List<Question> questions){
        Form form = formService.getFormById(formId);
        deleteAllByFormId(formId);
        questions = questions.stream().peek(question -> question.setForm(form)).toList();
        return questionRepository.saveAll(questions);
    }
}
