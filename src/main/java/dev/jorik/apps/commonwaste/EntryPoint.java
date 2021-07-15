package dev.jorik.apps.commonwaste;

import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.waste.domain.Waste;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EntryPoint {
    private static List<Person> persons;


    public static void main(String[] args) {
        initPersons();
        WastesGroup groups = new WastesGroup(persons);
        groups.addWaste(new Waste(1, "Хлеб x2", 58f, person("Настя"), persons));
        groups.addWaste(new Waste(2, "Хлеб", 29f, person("Настя"), persons));
        groups.addWaste(new Waste(3, "Помидоры", 70.11f, person("Настя"), persons));
        groups.addWaste(new Waste(4, "Продукты", 1356.91f, person("Настя"), persons));
        groups.addWaste(new Waste(5, "Продукты", 1810.93f, person("Настя"), persons));
        groups.printWastes();
    }

    private static void initPersons(){
        Person Егор = new Person(1, "Егор");
        Person Даша = new Person(2, "Даша");
        Person Настя = new Person(3, "Настя");
        Person Катя = new Person(4, "Катя");
        persons = new ArrayList<>();
        persons.add(Егор);
        persons.add(Даша);
        persons.add(Настя);
        persons.add(Катя);
    }

    private static Person person(String name){
        return find(persons, p -> p.getName().equals(name));
    }

    private static <I> I find(List<I> items, Predicate<I> predicate){
        for(I item : items) if (predicate.test(item)) return item;
        return null;
    }
}
