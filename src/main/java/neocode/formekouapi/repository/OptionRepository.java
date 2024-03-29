package neocode.formekouapi.repository;

import neocode.formekouapi.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, String> {
}
