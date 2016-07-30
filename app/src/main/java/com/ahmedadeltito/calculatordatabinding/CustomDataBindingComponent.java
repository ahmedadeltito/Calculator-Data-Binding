package com.ahmedadeltito.calculatordatabinding;

/**
 * Created by ahmedadel on 11/07/16.
 * CustomDataBindingComponent is an helper class that implements DataBindingComponent to user the customize data binding component
 */

public class CustomDataBindingComponent implements android.databinding.DataBindingComponent {

    @Override
    public CustomDataBindingAdapter getCustomDataBindingAdapter() {
        return new CustomDataBindingAdapter();
    }
}
