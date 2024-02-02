package neocode.formekouapi.repository;

import neocode.formekouapi.model.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DummyRepository extends JpaRepository<Dummy, String>{
}
