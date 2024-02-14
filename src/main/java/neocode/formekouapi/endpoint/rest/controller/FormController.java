package neocode.formekouapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import neocode.formekouapi.model.Form;
import neocode.formekouapi.security.FirebaseAuthentication;
import neocode.formekouapi.service.FormService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
public class FormController {
    private final FormService formService;

    @GetMapping("/forms")
    public List<Form> getAllForms(){
        return formService.getAll();
    }

    @GetMapping("/users/{userId}/forms")
    public List<Form> getAllForms(@PathVariable String userId){
        return formService.getAllByUserId(userId);
    }

    @PutMapping("/forms")
    public Form crupdateForms(
            FirebaseAuthentication authentication,
            @RequestBody Form formToSave
    ){
        formToSave.setUser(authentication.getUser());
        return formService.crupdateForm(formToSave);
    }
}