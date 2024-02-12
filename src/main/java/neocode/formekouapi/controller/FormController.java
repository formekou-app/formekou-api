package neocode.formekouapi.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import neocode.formekouapi.model.Form;
import neocode.formekouapi.service.FormService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
public class FormController {
    private final FormService formService;

    @GetMapping("/forms")
    public List<Form> getAllForms(){
        return formService.getAllForms();
    }
}
