package dev.jorik.apps.commonwaste.waste.presentation;

import dev.jorik.apps.commonwaste.person.domain.Person;

import java.util.List;

public interface WastesView {
    void obtainPersons(List<Person> persons);
    void inputName();
    void inputAmount();
    void inputPayerId(List<Person> variants);
    void inputConsumersId(List<Person> variantConsumers);
}
