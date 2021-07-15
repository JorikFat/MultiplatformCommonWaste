package dev.jorik.apps.commonwaste.result.presentation;

import dev.jorik.apps.commonwaste.domain.CommonWasteInteractor;

public class ResultPresenter {
    private CommonWasteInteractor domain;

    public ResultPresenter(CommonWasteInteractor interactor) {
        domain = interactor;
    }

    public void attachView(ResultView view){
        view.showResults(domain.getPersons(), domain.getWastes());
    }
}
