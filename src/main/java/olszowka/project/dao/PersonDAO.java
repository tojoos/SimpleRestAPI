package olszowka.project.dao;

import olszowka.project.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDAO {

    Person insertPerson(UUID id, Person person);

    Person getPerson(UUID id);

    List<Person> getAllPeople();

    default Person insertPerson(Person person) {
        return insertPerson(UUID.randomUUID(), person);
    }
}
