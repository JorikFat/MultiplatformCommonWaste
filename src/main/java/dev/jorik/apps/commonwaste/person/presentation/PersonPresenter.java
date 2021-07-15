package dev.jorik.apps.commonwaste.person.presentation;

import dev.jorik.apps.commonwaste.person.domain.PersonsUseCase;

public class PersonPresenter {
    private PersonView view;
    private final PersonsUseCase domain;

    public PersonPresenter(PersonsUseCase domain) {
        this.domain = domain;
    }

    public void attachView(PersonView view){
        this.view = view;
        view.startFill();
    }

    public void onInputName(String name){
        if(!name.isEmpty()){
            domain.createPerson(name);
            view.startFill();
        }
    }
}
