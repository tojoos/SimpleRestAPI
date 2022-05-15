package olszowka.project.dao;

import olszowka.project.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDAO {

    private List<Person> DB = new ArrayList<>();

    @Override
    public Person insertPerson(UUID id, Person person) {
        Person personToAdd = new Person(id, person.getName());
        DB.add(personToAdd);
        return personToAdd;
    }

    @Override
    public Person getPersonById(UUID id) {
        return DB.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public void deletePersonById(UUID id) {
        Person foundPerson = getPersonById(id);
        if(foundPerson != null)
            DB.remove(foundPerson);
        else
            throw new NoSuchElementException("Person with id: " + id + " was not found in DB");
    }

    @Override
    public void updatePerson(UUID id, Person person) {
        Person foundPerson = getPersonById(id);
        if(foundPerson != null)
            DB.set(DB.indexOf(foundPerson), new Person(id, person.getName()));
        else
            throw new NoSuchElementException("Person with id: " + id + " was not found in DB");
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }
}
