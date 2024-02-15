package neocode.formekouapi.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import neocode.formekouapi.exception.NotFoundException;
import neocode.formekouapi.model.Form;
import neocode.formekouapi.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class FormService {
    private final FormRepository formRepository;

    public List<Form> getAll(){
        return formRepository.findAll();
    }

    public List<Form> getAllByUserId(String userId){
        return formRepository.findAllByUserId(userId);
    }

    public List<Form> getOwnForms(){
        return getAllByUserId(AuthService.getAuthentication().getUser().getId());
    }

    //TODO: manage access
    public Form getFormById(String formId){
        return formRepository.findById(formId).orElseThrow(NotFoundException::new);
    }

    public Form crupdateForm(Form formToSave){
        formToSave.setUser(AuthService.getAuthentication().getUser());
        return formRepository.save(formToSave);
    }
}
