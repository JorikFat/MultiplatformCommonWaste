package dev.jorik.apps.commonwaste.waste.domain;

import dev.jorik.apps.commonwaste.person.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class WastesUseCase {
    private final List<Waste> wastes = new ArrayList<>();
    private WastesBus interactor;

    public void setInteractor(WastesBus interactor){
        this.interactor = interactor;
    }

    public void createWaste(String name, float amount, long payerId, long[] consumenrsId){
        long id = wastes.isEmpty() ? 1 : wastes.get(wastes.size() - 1).getId() + 1;
        Waste waste = new Waste(id, name, amount, interactor.getPerson(payerId), interactor.getPersons(consumenrsId));
        wastes.add(waste);
        Person payer = waste.getPayer();
        payer.setBalance(payer.getBalance() - waste.getAmount());

        float payPart = waste.getAmount() / waste.getConsumers().size();
        for(Person consumers :waste.getConsumers()){
            consumers.setBalance(consumers.getBalance() + payPart);
        }
    }

    public List<Waste> getWastes(){
        return wastes;
    }
}
