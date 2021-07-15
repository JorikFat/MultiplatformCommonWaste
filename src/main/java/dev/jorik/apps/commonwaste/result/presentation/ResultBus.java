package dev.jorik.apps.commonwaste.result.presentation;

import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.waste.domain.Waste;

import java.util.List;

public interface ResultBus {
    List<Person> getPersons();
    List<Waste> getWastes();
}
