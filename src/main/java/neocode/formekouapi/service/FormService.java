package neocode.formekouapi.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import neocode.formekouapi.model.Form;
import neocode.formekouapi.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class FormService {
    private final FormRepository formRepository;

    public List<Form> getAllForms(){
        return formRepository.findAll();
    }
}
