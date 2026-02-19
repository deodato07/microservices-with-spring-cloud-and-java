package br.com.deodato07.repository;

import br.com.deodato07.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person cr();
}
