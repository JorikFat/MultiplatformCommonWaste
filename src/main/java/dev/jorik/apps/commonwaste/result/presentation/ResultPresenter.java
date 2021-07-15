package dev.jorik.apps.commonwaste.result.presentation;

import dev.jorik.apps.commonwaste.person.domain.PersonsUseCase;
import dev.jorik.apps.commonwaste.waste.domain.WastesUseCase;

public class ResultPresenter {
    private PersonsUseCase personsDomain;
    private WastesUseCase wastesDomain;

    public ResultPresenter(PersonsUseCase personsDomain, WastesUseCase wastesDomain) {
        this.personsDomain = personsDomain;
        this.wastesDomain = wastesDomain;
    }

    public void attachView(ResultView view){
        view.showResults(personsDomain.getPersons(), wastesDomain.getWastes());
    }
}
