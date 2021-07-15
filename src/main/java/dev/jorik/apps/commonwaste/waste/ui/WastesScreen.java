package dev.jorik.apps.commonwaste.waste.ui;

import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.waste.domain.Waste;
import dev.jorik.apps.commonwaste.waste.presentation.WastesPresenter;
import dev.jorik.apps.commonwaste.waste.presentation.WastesView;

import java.util.List;
import java.util.Scanner;

public class WastesScreen implements WastesView {
    private Scanner scanner;
//    private BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private final WastesPresenter presenter;
    private List<Person> persons;

    public WastesScreen(Scanner scanner, WastesPresenter presenter) {
        this.scanner = scanner;
        this.presenter = presenter;
    }

    public void start(){
//        scanner = new Scanner(System.in);

        presenter.attachView(this);
    }

    @Override
    public void obtainPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void inputName() {
        System.out.println("Введите имя платежа: ");
        presenter.onInputName(scanner.nextLine());
        System.out.println();
    }

    @Override
    public void inputAmount() {
        System.out.println("Введите сумму платежа: ");
        presenter.onInputAmoun(Float.parseFloat(scanner.nextLine()));
        System.out.println();
    }

    @Override
    public void inputPayerId(List<Person> variants) {
        printPersons(persons);
        System.out.println("Введите id того, кто оплатил: ");
        presenter.onInputPayerId(Long.parseLong(scanner.nextLine()));
    }

    @Override
    public void inputConsumersId(List<Person> variantConsumers) {
        printPersons(persons);
        System.out.println("Введите id тех, между кем делить: ");
        presenter.onInputConsumersId(scanner.nextLine());
    }

    @Override
    public void showWastes(List<Waste> wastes) {
        for (Waste waste :wastes){
            System.out.printf("%d: %s\t%f", waste.getId(), waste.getName(), waste.getAmount());
        }
    }

    private void printPersons(List<Person> persons){
        for (Person person :persons) System.out.printf("%d  %s\n", person.getId(), person.getName());
    }
}
