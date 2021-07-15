package dev.jorik.apps.commonwaste.waste.presentation;

import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.person.domain.PersonsUseCase;
import dev.jorik.apps.commonwaste.waste.domain.WastesUseCase;

import java.util.List;

public class WastesPresenter {
    private WastesView view;
    private final WastesUseCase wastesDomain;
    private final PersonsUseCase personsDomain;
    private ViewWaste viewState;

    public WastesPresenter(WastesUseCase wastesDomain, PersonsUseCase personsDomain/*, WastesRouter router*/) {
        this.wastesDomain = wastesDomain;
        this.personsDomain = personsDomain;
        viewState = new ViewWaste();
    }

    public void attachView(WastesView view) {
        this.view = view;
        view.obtainPersons(personsDomain.getPersons());
        view.inputName();
    }

    public void onInputName(String name){
        if(name.isEmpty()){
        } else {


            viewState.setName(name);
            view.inputAmount();
        }
    }

    public void onInputAmoun(float amount){
        viewState.setAmount(amount);
        view.inputPayerId(personsDomain.getPersons());
    }

    public void onInputPayerId(long payerId){
        viewState.setPayerId(payerId);
        view.inputConsumersId(personsDomain.getPersons());
    }

    public void onInputConsumersId(String consumersId){
        long[] ids = parseArray(consumersId.split(" "));
        if(ids.length == 1 && ids[0] == 0){
            viewState.setConsumersId(getAllIds());
        } else {
            viewState.setConsumersId(ids);
        }
        wastesDomain.createWaste(viewState.getName(), viewState.getAmount(), viewState.getPayerId(), viewState.getConsumersId());
        viewState = new ViewWaste();
        view.inputName();
    }

    private long[] parseArray(String[] stringArray){
        long[] rArray = new long[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) rArray[i] = Long.parseLong(stringArray[i]);
        return rArray;
    }

    private long[] getAllIds(){
        List<Person> persons = personsDomain.getPersons();
        long[] rArray = new long[persons.size()];
        for(int i=0; i<persons.size(); i++) rArray[i] = persons.get(i).getId();
        return rArray;
    }
}
