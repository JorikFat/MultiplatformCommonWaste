package dev.jorik.apps.commonwaste.domain;

import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.person.domain.PersonsUseCase;
import dev.jorik.apps.commonwaste.waste.domain.WastesBus;
import dev.jorik.apps.commonwaste.waste.domain.WastesUseCase;

import java.util.List;

public class CommonWasteInteractor implements WastesBus {
    private final PersonsUseCase persons;
    private final WastesUseCase wastes;

    public CommonWasteInteractor(PersonsUseCase persons, WastesUseCase wastes) {
        this.persons = persons;
        this.wastes = wastes;
        wastes.setInteractor(this);
    }

    @Override
    public Person getPerson(long id) {
        return persons.getPersons(new long[]{id}).get(0);
    }

    @Override
    public List<Person> getPersons(long[] ids) {
        return persons.getPersons(ids);
    }
}
