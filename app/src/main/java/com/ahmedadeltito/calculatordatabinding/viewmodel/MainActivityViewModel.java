package com.ahmedadeltito.calculatordatabinding.viewmodel;

import com.ahmedadeltito.calculatordatabinding.presenter.MainActivityPresenter;

/**
 * Created by ahmedadel on 11/07/16.
 * MainActivityViewModel is the view model that is a connected point between activity_main.xml layout file
 * and MainActivity view model
 */
public class MainActivityViewModel {

    private MainActivityPresenter mainActivityPresenter;

    public MainActivityViewModel(MainActivityPresenter mainActivityPresenter) {
        this.mainActivityPresenter = mainActivityPresenter;
    }

    public void onShowData(String value) {
        mainActivityPresenter.showCalculation(value);
    }

}
