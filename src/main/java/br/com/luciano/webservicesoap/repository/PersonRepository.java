package br.com.luciano.webservicesoap.repository;

import br.com.luciano.webservicesoap.xml.Person;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class PersonRepository {

    private static final Map<String, Person> persons = new HashMap<>();

    @PostConstruct
    public void init() {
        Person person1 = new Person();
        person1.setName("Antonio Luciano Lima");
        person1.setAge(29);
        person1.setAddress("Rua das bichinas, 201");
        persons.put(person1.getName(), person1);

        Person person2 = new Person();
        person2.setName("Gabriel Chaves");
        person2.setAge(30);
        person2.setAddress("Rua das virgens, 101");
        persons.put(person2.getName(), person2);

        Person person3 = new Person();
        person3.setName("Guilherme Lopes");
        person3.setAge(24);
        person3.setAddress("Rua das bichas, 301");
        persons.put(person3.getName(), person3);
    }

    public Person findByName(String name) {
        return persons.get(name);
    }
}
