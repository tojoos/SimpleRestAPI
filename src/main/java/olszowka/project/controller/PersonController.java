package olszowka.project.controller;

import olszowka.project.model.Person;
import olszowka.project.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody Person person) {
        return personService.insertNewPerson(person);
    }

    @GetMapping("/person/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Person getPerson(@PathVariable UUID id) {
        return personService.getPerson(id);
    }

    @DeleteMapping("/person/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonById(@PathVariable UUID id) {
        personService.deletePersonById(id);
    }

    @PutMapping("/person/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable UUID id, @RequestBody Person person) {
        personService.updatePerson(id, person);
    }

    @GetMapping("/person/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
}
