package neocode.formekouapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import neocode.formekouapi.endpoint.rest.mapper.AnswerMapper;
import neocode.formekouapi.endpoint.rest.mapper.CreateAnswerMapper;
import neocode.formekouapi.endpoint.rest.model.Answer;
import neocode.formekouapi.endpoint.rest.model.CreateAnswer;
import neocode.formekouapi.service.AnswerService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@AllArgsConstructor
public class AnswerController {
    private final AnswerMapper answerMapper;
    private final CreateAnswerMapper createAnswerMapper;
    private final AnswerService answerService;

    @PutMapping("/forms/reply")
    public List<Answer> saveAnswers(@RequestBody List<CreateAnswer> createAnswers){
        return answerService.saveAnswers(
                createAnswers.stream().map(createAnswerMapper::toDomain).toList()
        ).stream().map(answerMapper::toRest).toList();
    }

    @GetMapping("/forms/{formId}/answers")
    public List<Answer> getFormAnswers(
            @PathVariable String formId,
            @RequestParam(name = "sort", defaultValue = "updatedAt") String sort
    ){
        return answerService.getByFormId(formId, sort).stream().map(answerMapper::toRest).toList();
    }

    @GetMapping("/forms/{formId}/can/reply")
    public boolean canInReply(
            @PathVariable String formId
    ){
        return answerService.canIRespond(formId);
    }
}
