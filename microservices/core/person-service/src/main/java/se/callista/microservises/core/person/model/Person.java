package main.java.se.callista.microservises.core.person.model;

/**
 * Created by magnus on 04/03/15.
 */
public class Person {
    private int personId;
    private String name;
    private int weight;

    public Person() {

    }

    public Person(int personId, String name, int weight) {
        this.personId = personId;
        this.name = name;
        this.weight = weight;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
