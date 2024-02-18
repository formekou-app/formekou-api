package neocode.formekouapi.repository;

import neocode.formekouapi.model.Answer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {
    List<Answer> findAllByQuestionFormId(String formId, Sort sort);
    List<Answer> findAllByUserIdAndQuestionFormId(String userId, String formId);
}
