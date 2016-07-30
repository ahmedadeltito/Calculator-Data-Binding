package com.ahmedadeltito.calculatordatabinding.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ahmedadeltito.calculatordatabinding.CustomDataBindingComponent;
import com.ahmedadeltito.calculatordatabinding.presenter.MainActivityPresenter;
import com.ahmedadeltito.calculatordatabinding.R;
import com.ahmedadeltito.calculatordatabinding.databinding.ActivityMainBinding;
import com.ahmedadeltito.calculatordatabinding.model.CalculatorModel;
import com.ahmedadeltito.calculatordatabinding.viewmodel.MainActivityViewModel;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * MainActivity is the view activity that is connected to activity_main.xml layout and implementing data binding technique
 */

public class MainActivity extends AppCompatActivity implements MainActivityPresenter {

    private CalculatorModel calculatorModel;
    private String equation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            equation = savedInstanceState.getString("equation");
        }
        calculatorModel = new CalculatorModel(equation);

        DataBindingUtil.setDefaultComponent(new CustomDataBindingComponent());

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel(this);
        activityMainBinding.setModel(calculatorModel);
        activityMainBinding.setViewModel(mainActivityViewModel);

    }

    /**
     * onSaveInstanceState is override for not losing the calculation data during screen orientation
     * @param outState is the bundle that will save data after re-creating the activity lifecycle again
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("equation", equation);
    }

    /**
     * showCalculation is a listener that will be fired once any button on calculator is clicked
     * @param value
     */
    @Override
    public void showCalculation(String value) {
        if (value.equals(MainActivity.this.getResources().getString(R.string.equal))) {
            try {
                Expression expression = new ExpressionBuilder(equation).build();
                double result = expression.evaluate();
                equation = Double.toString(result);
                calculatorModel.setValue(equation);
            } catch (Exception ex) {
                equation = "";
                calculatorModel.setValue("ERROR");
            }
        } else if (value.equals(MainActivity.this.getResources().getString(R.string.delete))) {
            equation = "";
            calculatorModel.setValue("0");
        } else {
            equation += value;
            calculatorModel.setValue(equation);
        }
    }
}
