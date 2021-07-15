package dev.jorik.apps.commonwaste.domain;

import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.person.domain.PersonsUseCase;
import dev.jorik.apps.commonwaste.result.presentation.ResultBus;
import dev.jorik.apps.commonwaste.waste.domain.Waste;
import dev.jorik.apps.commonwaste.waste.domain.WastesBus;
import dev.jorik.apps.commonwaste.waste.domain.WastesUseCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonWasteInteractor implements WastesBus, ResultBus {
    private final PersonsUseCase persons;
    private final WastesUseCase wastes;

    public CommonWasteInteractor(PersonsUseCase persons, WastesUseCase wastes) {
        this.persons = persons;
        this.wastes = wastes;
        wastes.setInteractor(this);
    }

    @Override
    public Person getPerson(long id) {
        return find(persons.getPersons(), item -> item.getId() == id);
    }

    @Override
    public List<Person> getPersons(long[] ids) {
//        todo add check allNegative|allPositive
        List<Long> idsList = convertIds(ids);
        return filter(persons.getPersons(), item -> idsList.contains(item.getId()));
    }

    @Override
    public List<Person> getPersons() {
        return persons.getPersons();
    }

    @Override
    public List<Waste> getWastes() {
        return wastes.getWastes();
    }

    private List<Long> convertIds(long[] ids){
        List<Long> rList = new ArrayList<>(ids.length);
        for(long id :ids) rList.add(id);
        return rList;
    }

    private <T> List<T> filter(List<T> srcList, Condition<T> condition){
        ArrayList<T> rList = new ArrayList<>();
        for(T item :srcList) if(condition.check(item)) rList.add(item);
        return rList;
    }

    private <T> T find(List<T> srcList, Condition<T> condition){
        for (T item :srcList) if (condition.check(item)) return item;
        return null;
    }

    private interface Condition<T>{
        boolean check(T item);
    }
}
