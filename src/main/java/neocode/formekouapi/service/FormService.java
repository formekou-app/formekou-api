package neocode.formekouapi.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import neocode.formekouapi.exception.BadRequestException;
import neocode.formekouapi.exception.NotFoundException;
import neocode.formekouapi.model.Form;
import neocode.formekouapi.repository.FormRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class FormService {
    private final FormRepository formRepository;

    public List<Form> getAllByUserId(String userId, Sort sort){
        return formRepository.findAllByUserId(userId, sort);
    }

    public Form deleteById(String formId){
        Form toDelete = formRepository.findById(formId).orElseThrow(NotFoundException::new);
        formRepository.delete(toDelete);
        return toDelete;
    }

    public List<Form> getOwnForms(String sort){
        if(!sort.equals("createdAt") && !sort.equals("updatedAt"))
            throw new BadRequestException("The sort type are [ createdAt or updatedAt ]");
        return getAllByUserId(
                AuthService.getAuthentication().getUser().getId(),
               Sort.by(sort).descending()
        );
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
