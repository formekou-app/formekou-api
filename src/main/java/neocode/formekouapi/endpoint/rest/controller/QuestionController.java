package neocode.formekouapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import neocode.formekouapi.endpoint.rest.mapper.QuestionMapper;
import neocode.formekouapi.endpoint.rest.model.Question;
import neocode.formekouapi.service.QuestionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuestionController {
    private QuestionService questionService;
    private QuestionMapper questionMapper;

    @PutMapping("/forms/{formId}/questions")
    public List<Question> setFormsQuestions(
            @RequestBody List<Question> questions,
            @PathVariable String formId
    ){
        return questionService.setFormQuestions(
                formId,
                questions.stream().map(questionMapper::toDomain).toList()
        ).stream().map(questionMapper::toRest).toList();
    }
}
