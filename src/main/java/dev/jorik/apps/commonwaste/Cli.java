package dev.jorik.apps.commonwaste;

import dev.jorik.apps.commonwaste.domain.CommonWasteInteractor;
import dev.jorik.apps.commonwaste.domain.CommonWasteRouter;
import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.person.domain.PersonsUseCase;
import dev.jorik.apps.commonwaste.person.presentation.PersonPresenter;
import dev.jorik.apps.commonwaste.person.ui.PersonsScreen;
import dev.jorik.apps.commonwaste.ui.Feature;
import dev.jorik.apps.commonwaste.waste.domain.WastesUseCase;
import dev.jorik.apps.commonwaste.waste.presentation.WastesPresenter;
import dev.jorik.apps.commonwaste.waste.ui.WastesScreen;

import java.util.Scanner;

public class Cli{

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        PersonsUseCase persons = new PersonsUseCase();
//        WastesUseCase wastes = new WastesUseCase();
//
//        CommonWasteRouter router = new CommonWasteRouter(factoryPerson(scanner, persons), factoryWaste(scanner, wastes, persons));
//        CommonWasteInteractor interactor = new CommonWasteInteractor(persons, wastes);
//
//        router.start();
        new Feature(new Scanner(System.in)).start();
    }

//    private static PersonsScreen factoryPerson(Scanner scanner, PersonsUseCase persons){
//        return new PersonsScreen(scanner, new PersonPresenter(persons));
//    }
//
//    private static WastesScreen factoryWaste(Scanner scanner, WastesUseCase wastes, PersonsUseCase persons){
//        return new WastesScreen(scanner, new WastesPresenter(wastes, persons));
//    }
}
