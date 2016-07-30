package com.ahmedadeltito.calculatordatabinding;

import android.databinding.BindingAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ahmedadel on 11/07/16
 * CustomDataBindingAdapter is an customized type of DataBindingComponent to make custom methods for custom fonts.
 */
public class CustomDataBindingAdapter {

    @BindingAdapter("fontTextView")
    public void setFontTextView(TextView textView, String fontTextView) {
        textView.setTypeface(FontCache.getInstance().get(fontTextView));
    }

    @BindingAdapter("fontButton")
    public void setFontButton(Button button, String fontButton) {
        button.setTypeface(FontCache.getInstance().get(fontButton));
    }

}
