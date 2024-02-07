package neocode.formekouapi.service;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.Form;
import neocode.formekouapi.model.User;
import neocode.formekouapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormService {
    private final FormRepository formRepository;

    public List<Form> getAllForms(){
        return formRepository.findAll();
    }

    public Optional<Form> getFormById(String id){
        return formRepository.findById(id);
    }

    public Form createOrUpdate(Form toSave){
        return formRepository.save(toSave);
    }

    public void deleteFormById(String id) {
        formRepository.deleteById(id);
    }

}
