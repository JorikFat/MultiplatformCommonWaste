package dev.jorik.apps.commonwaste.ui;

import dev.jorik.apps.commonwaste.domain.CommonWasteInteractor;
import dev.jorik.apps.commonwaste.person.domain.PersonsUseCase;
import dev.jorik.apps.commonwaste.person.presentation.PersonPresenter;
import dev.jorik.apps.commonwaste.person.ui.PersonsScreen;
import dev.jorik.apps.commonwaste.result.presentation.ResultPresenter;
import dev.jorik.apps.commonwaste.result.ui.ResultScreen;
import dev.jorik.apps.commonwaste.waste.domain.WastesUseCase;
import dev.jorik.apps.commonwaste.waste.presentation.WastesPresenter;
import dev.jorik.apps.commonwaste.waste.ui.WastesScreen;

import java.util.Scanner;

public class Feature {

    private Scanner scanner;
    private PersonsUseCase personsUseCase;
    private WastesUseCase wastesUseCase;
    private CommonWasteInteractor interactor;

    public Feature(Scanner scanner){
        this.scanner = scanner;
        personsUseCase = new PersonsUseCase();
        wastesUseCase = new WastesUseCase();
        interactor = new CommonWasteInteractor(personsUseCase, wastesUseCase);
    }

    public void start(){
        PersonPresenter personPresenter = new PersonPresenter(personsUseCase/*, this*/);
        PersonsScreen personsScreen = new PersonsScreen(scanner, personPresenter);
        personsScreen.start();
        personsScreen = null;
        WastesPresenter wastesPresenter = new WastesPresenter(wastesUseCase, personsUseCase);
        WastesScreen wastesScreen = new WastesScreen(scanner, wastesPresenter);
        wastesScreen.start();
        wastesScreen = null;
        ResultPresenter resultPresenter = new ResultPresenter(personsUseCase, wastesUseCase);
        ResultScreen resultScreen = new ResultScreen(resultPresenter);
        resultScreen.start();
    }
}
