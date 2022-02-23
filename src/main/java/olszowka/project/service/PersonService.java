package olszowka.project.service;

import olszowka.project.dao.PersonDAO;
import olszowka.project.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDAO personDAO;

    public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Person insertNewPerson(Person person) {
        return personDAO.insertPerson(person);
    }

    public Person getPerson(UUID id) {
        return personDAO.getPerson(id);
    }

    public List<Person> getAllPeople() {
        return personDAO.getAllPeople();
    }

}
