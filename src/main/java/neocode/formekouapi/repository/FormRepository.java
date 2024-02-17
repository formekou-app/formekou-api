package neocode.formekouapi.repository;

import neocode.formekouapi.model.Form;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, String> {
    List<Form> findAllByUserId(String userId, Sort sort);
}
