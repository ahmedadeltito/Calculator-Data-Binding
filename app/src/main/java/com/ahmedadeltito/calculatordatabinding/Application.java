package com.ahmedadeltito.calculatordatabinding;

import android.content.Context;

/**
 * Created by ahmedadel on 11/07/16.
 */
public class Application extends android.app.Application {

    private static Context context;

    public void onCreate(){
        super.onCreate();
        Application.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return Application.context;
    }
}
