package main.java.se.callista.microservises.core.person.service;

import main.java.se.callista.microservises.core.person.model.Person;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by magnus on 04/03/15.
 */
@RestController
public class PersonService {

    /**
     * Sample usage: curl $HOST:$PORT/threat/1
     *
     * @param threatId
     * @return
     */
    @RequestMapping("/person/{personId}")
    public Person getPerson(@PathVariable int personId) {

        return new Person(personId, "name", 123);
    }
}
