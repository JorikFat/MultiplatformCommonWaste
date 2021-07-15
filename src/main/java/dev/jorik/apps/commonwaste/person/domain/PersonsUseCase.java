package dev.jorik.apps.commonwaste.person.domain;

import java.util.ArrayList;
import java.util.List;

public class PersonsUseCase {
    private List<Person> persons = new ArrayList<>();

    public void createPerson(String name){
        long id = persons.isEmpty() ? 1 : persons.get(persons.size()-1).getId()+1;
        persons.add(new Person(id, name));
    }

    public List<Person> getPersons(){
        return persons;
    }
}
