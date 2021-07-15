package dev.jorik.apps.commonwaste.person.presentation;

import dev.jorik.apps.commonwaste.person.domain.PersonsUseCase;

public class PersonPresenter {
    private PersonView view;
//    private PersonRouter router;
    private final PersonsUseCase domain;

    public PersonPresenter(PersonsUseCase domain/*, PersonRouter router*/) {
        this.domain = domain;
//        this.router = router;
    }

    public void attachView(PersonView view){
        this.view = view;
        view.startFill();
    }

/*
    public void setRouter(PersonRouter router){
        this.router = router;
    }
*/

    public void onInputName(String name){
        if(name.isEmpty()){
//        if(name.equals("х")){
//            view.finish();
//            router.forward();
        } else {
            domain.createPerson(name);
            view.startFill();
        }
    }
}
