package dev.jorik.apps.commonwaste.person.ui;

import dev.jorik.apps.commonwaste.person.presentation.PersonPresenter;
import dev.jorik.apps.commonwaste.person.presentation.PersonView;

import java.util.Scanner;

public class PersonsScreen implements PersonView {
    private final Scanner scanner;
    private final PersonPresenter presenter;

    public PersonsScreen(Scanner scanner, PersonPresenter presenter) {
        this.scanner = scanner;
        this.presenter = presenter;
    }

    public void start(){
        System.out.println("Введите имена:");
        this.presenter.attachView(this);
    }

    @Override
    public void startFill() {
        presenter.onInputName(scanner.nextLine());
    }

    @Override
    public void finish() {
//        scanner.close();
    }
}
