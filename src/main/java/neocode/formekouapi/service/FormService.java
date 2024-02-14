package neocode.formekouapi.service;

import lombok.AllArgsConstructor;
import lombok.Data;
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

    public Form crupdateForm(Form formToSave){
        return formRepository.save(formToSave);
    }
}
