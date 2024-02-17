package neocode.formekouapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import neocode.formekouapi.endpoint.rest.mapper.CreateFormMapper;
import neocode.formekouapi.endpoint.rest.mapper.FormMapper;
import neocode.formekouapi.endpoint.rest.model.CreateForm;
import neocode.formekouapi.endpoint.rest.model.Form;
import neocode.formekouapi.service.FormService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
public class FormController {
    private final FormService formService;
    private final CreateFormMapper createFormMapper;
    private final FormMapper formMapper;

    @GetMapping("/forms")
    public List<Form> getOwnForms(
            @RequestParam(name = "sort", defaultValue = "updatedAt") String sort
    ){
        return formService.getOwnForms(sort).stream().map(formMapper::toRest).toList();
    }

    @GetMapping("/forms/{formId}")
    public Form getFormById(@PathVariable String formId){
        return formMapper.toRest(formService.getFormById(formId));
    }

    @DeleteMapping("/forms/{formId}")
    public Form deleteFormById(@PathVariable String formId) {
        return formMapper.toRest(formService.deleteById(formId));
    }

    @PutMapping("/forms")
    public Form crupdateForm(@RequestBody CreateForm formToSave){
        return formMapper.toRest(formService.crupdateForm(createFormMapper.toDomain(formToSave)));
    }
}