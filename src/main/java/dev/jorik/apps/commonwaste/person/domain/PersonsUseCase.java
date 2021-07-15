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

    public List<Person> getPersons(long[] ids){
        //todo add check allNegative|allPositive
        if(ids.length == 1 && ids[0] == 0) return persons;
        List<Person> rList = new ArrayList<>();
        for(long id : ids) rList.add(find(id));
        return rList;
    }

    private Person find(long id){
        for (Person person : persons) if(person.getId() == id) return person;
        return null;
    }
}
