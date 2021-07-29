package br.dev.robsonbs.personapi.repository;

import br.dev.robsonbs.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
