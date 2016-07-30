package com.ahmedadeltito.calculatordatabinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by ahmedadel on 11/07/16.
 * CalculatorModel is a Model that will be used in activity_main.xml layout file
 */
public class CalculatorModel extends BaseObservable {

    private String value;

    public CalculatorModel(String value) {
        this.value = value;
    }

    @Bindable
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        notifyPropertyChanged(com.ahmedadeltito.calculatordatabinding.BR.value);
    }
}
