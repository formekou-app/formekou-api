package neocode.formekouapi.repository;

import neocode.formekouapi.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findAllByFormId(String formId);
    Optional<Question> findById(String questionId);
}
