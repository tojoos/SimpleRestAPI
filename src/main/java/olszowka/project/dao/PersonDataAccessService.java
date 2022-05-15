package olszowka.project.dao;

import olszowka.project.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Person insertPerson(UUID id, Person person) {
        return null;
    }

    @Override
    public Person getPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet, i) ->
                new Person(UUID.fromString(resultSet.getString("id")), resultSet.getString("name")));
    }

    @Override
    public void deletePersonById(UUID id) {

    }

    @Override
    public void updatePerson(UUID id, Person person) {

    }

    @Override
    public List<Person> getAllPeople() {
        final String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(sql,(resultSet, i) ->
               new Person(UUID.fromString(resultSet.getString("id")),
               resultSet.getString("name")));
    }
}
