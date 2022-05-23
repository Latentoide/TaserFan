package com.example.taserfan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taserfan.API.Connector;
import com.example.taserfan.Vehiculos.Bicicleta;
import com.example.taserfan.Vehiculos.Coche;
import com.example.taserfan.Vehiculos.Moto;
import com.example.taserfan.Vehiculos.Patin;
import com.example.taserfan.base.BaseActivity;
import com.example.taserfan.base.CallInterface;

public class VehicleDetail extends BaseActivity implements CallInterface {
    private Tablas tabla;
    private String matricula;
    Coche c;
    Moto m;
    Patin p;
    Bicicleta b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        tabla = (Tablas) getIntent().getExtras().getSerializable("tabla");
        matricula = getIntent().getExtras().getString("matricula");
    }

    @Override
    public void doInBackground() {
        switch (tabla){
            case COCHE:
                c = Connector.getConector().get(Coche.class, "/coche?matricula=" + matricula);
                break;
            case MOTO:
                m = Connector.getConector().get(Moto.class, "/moto?matricula=" + matricula);
                break;
            case BICICLETA:
                b = Connector.getConector().get(Bicicleta.class, "/bicicleta?matricula=" + matricula);
                break;
            case PATINETE:
                p = Connector.getConector().get(Patin.class, "/patinete?matricula=" + matricula);
                break;
        }

    }

    @Override
    public void doInUI() {

    }
}