package com.example.taserfan;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class GestionPreferencias {
    private SharedPreferences sharedPreferences;
    private static GestionPreferencias instancia;

    private GestionPreferencias(){

    }

    public String getIP(Context context){
        inicializa(context);
        return sharedPreferences.getString("ipKey", "10.19.11.5");
    }

    public String getPort(Context context){
        inicializa(context);
        return sharedPreferences.getString("puertoKey", "4567");
    }

    private void inicializa(Context context){
        if(sharedPreferences == null){
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public String getTheme(Context context){
        inicializa(context);
        return sharedPreferences.getString(context.getString(R.string.settings_theme_key),ThemeSetup.Mode.DEFAULT.name());
    }

    public static GestionPreferencias getInstance(){
        if(instancia == null){
            instancia = new GestionPreferencias();
        }
        return instancia;
    }
}

