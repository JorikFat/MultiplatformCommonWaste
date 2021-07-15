package dev.jorik.apps.commonwaste.result.presentation;

import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.waste.domain.Waste;

import java.util.List;

public interface ResultView {
    void showResults(List<Person> persons, List<Waste> wastes);
}
