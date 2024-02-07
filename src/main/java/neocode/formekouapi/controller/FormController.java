package neocode.formekouapi.controller;

import neocode.formekouapi.model.Form;
import neocode.formekouapi.service.FormService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/forms")
public class FormController {
    private final FormService formService = new FormService();

    @GetMapping
    public List<Form> getallForms() {
        return formService.getAllForms();
    }

    @GetMapping
    public Optional<Form> getFormsById(String id) {
        return formService.getFormsById();
    }

    @PutMapping
    public Form createOrUpdateForm(@RequestBody Form formData) {
        return formService.createOrUpdate(formData);
    }

    @DeleteMapping
    public void deleteFormById(String id) {
        formService.deleteFormById(id);
    }
}
