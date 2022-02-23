package olszowka.project.dao;

import olszowka.project.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDAO {

    Person insertPerson(UUID id, Person person);

    Person getPerson(UUID id);

    void deletePersonById(UUID id);

    void updatePerson(UUID id, Person person);

    List<Person> getAllPeople();

    default Person insertPerson(Person person) {
        return insertPerson(UUID.randomUUID(), person);
    }
}
