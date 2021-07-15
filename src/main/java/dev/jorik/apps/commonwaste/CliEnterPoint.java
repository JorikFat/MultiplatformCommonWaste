package dev.jorik.apps.commonwaste;

import dev.jorik.apps.commonwaste.person.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CliEnterPoint {
    private static List<Person> persons;
    private static WastesGroup group;

    public static void main(String[] args) {
        initPersons();
        group = new WastesGroup(persons);
        System.out.println("END");
        fillWastes();
    }

    private static void initPersons(){
        persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имена пользователей:");
        String personName;
        do {
            personName = scanner.nextLine();
            if(!personName.isEmpty()) persons.add(new Person(persons.size() + 1, personName));
        } while (!personName.isEmpty());
    }

    private static void fillWastes(){
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        do {
            inputLine = scanner.nextLine();
//            if(!inputLine.isEmpty()) persons.add(new Person(persons.size() + 1, personName));
        } while (!inputLine.isEmpty());
    }
}
