package dev.jorik.apps.commonwaste.domain;

import dev.jorik.apps.commonwaste.person.presentation.PersonRouter;
import dev.jorik.apps.commonwaste.person.ui.PersonsScreen;
import dev.jorik.apps.commonwaste.waste.presentation.WastesRouter;
import dev.jorik.apps.commonwaste.waste.ui.WastesScreen;

public class CommonWasteRouter implements PersonRouter, WastesRouter {
    private PersonsScreen personsScreen;
    private WastesScreen wastesScreen;
    private Object currentScreen;

    public CommonWasteRouter(PersonsScreen personsScreen, WastesScreen wastesScreen) {
        this.personsScreen = personsScreen;
        this.wastesScreen = wastesScreen;
        this.currentScreen = personsScreen;
    }

    public void start(){
        this.currentScreen = personsScreen;
        personsScreen.start();
    }

    @Override
    public void forward() {
        if(currentScreen == personsScreen){
            currentScreen = wastesScreen;
            personsScreen = null;
            wastesScreen.start();
        } else if (currentScreen == wastesScreen){
            System.out.println("END");
        }
    }
}
