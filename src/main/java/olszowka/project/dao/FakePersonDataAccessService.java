package olszowka.project.dao;

import olszowka.project.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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
    public Person getPerson(UUID id) {
        DB.forEach(p -> System.out.println(p.getId()));
        return DB.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }
}
