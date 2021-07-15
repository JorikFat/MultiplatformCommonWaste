package dev.jorik.apps.commonwaste.waste.domain;

import dev.jorik.apps.commonwaste.person.domain.Person;

import java.util.List;

public interface WastesBus {
    Person getPerson(long id);
    List<Person> getPersons(long[] ids);
}
