package com.example.taserfan;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.taserfan.API.Connector;
import com.example.taserfan.Vehiculos.Bicicleta;
import com.example.taserfan.Vehiculos.Coche;
import com.example.taserfan.Vehiculos.Moto;
import com.example.taserfan.Vehiculos.Patin;
import com.example.taserfan.base.BaseActivity;
import com.example.taserfan.base.CallInterface;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InsertActivity extends BaseActivity implements AdapterView.OnItemSelectedListener,CallInterface, View.OnClickListener {

    EditText descEdit;
    EditText batEdit;
    EditText marcEdit;
    EditText precioHoEdit;
    EditText numPuerEdit;
    EditText numPlazaEdit;
    EditText tipoEdit;
    EditText velmaxEdit;
    EditText cilinEdit;
    EditText numRuedasEdit;
    EditText tamanyoEdit;
    EditText matriculaEdit;
    EditText idCarnetEdit;

    Button insertar;

    Spinner spinner;
    Spinner spinnerCol;
    Spinner estados;

    ArrayAdapter<String> vehi;
    ArrayAdapter<String> col;
    ArrayAdapter<String> est;
    String[] vehiculos = {"COCHE", "MOTO", "BICICLETA", "PATINETE"};
    String[] colores = {"verde", "rojo", "amarillo", "azul", "negro", "blanco"};
    String[] estado = { "baja", "alquilado", "taller", "preparado", "reserverdo"};

    Context context;

    Coche c;
    Moto m;
    Patin p;
    Bicicleta b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        context = this;
        idCarnetEdit = findViewById(R.id.idInsert);
        matriculaEdit = findViewById(R.id.matriInsert);
        descEdit = findViewById(R.id.descChange);
        batEdit = findViewById(R.id.batChange);
        marcEdit = findViewById(R.id.marcaChange);
        precioHoEdit = findViewById(R.id.precioChange);
        numPuerEdit = findViewById(R.id.numPuChange);
        numPlazaEdit = findViewById(R.id.numPlaChange);
        tipoEdit = findViewById(R.id.tipoChange);
        velmaxEdit = findViewById(R.id.velChange);
        cilinEdit = findViewById(R.id.cilinChange);
        numRuedasEdit = findViewById(R.id.numRuedasChange);
        tamanyoEdit = findViewById(R.id.tamanyoChange);

        insertar = findViewById(R.id.insertando);
        insertar.setOnClickListener(this);

        spinner = findViewById(R.id.spin);
        spinner.setOnItemSelectedListener(this);
        spinnerCol = findViewById(R.id.spin2);
        estados = findViewById(R.id.spin3);

        vehi = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vehiculos);
        vehi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        col = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colores);
        col.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        est = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estado);
        est.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(vehi);
        spinnerCol.setAdapter(col);
        estados.setAdapter(est);
    }

    @Override
    public void doInBackground() {
        Color color = Color.AZUL;
        Estado est= Estado.BAJA;
        Tablas tbl = Tablas.BICICLETA;
        switch (spinnerCol.getSelectedItem().toString()){
            case "verde":
                color = Color.VERDE;
                break;
            case "rojo":
                color = Color.ROJO;
                break;
            case "azul":
                color = Color.AZUL;
                break;
            case "amarillo":
                color = Color.AMARILLO;
                break;
            case "blanco":
                color = Color.BLANCO;
                break;
            case "negro":
                color = Color.NEGRO;
                break;
        }
        switch (spinner.getSelectedItem().toString()){
            case "COCHE":
                tbl = Tablas.COCHE;
                break;
            case "MOTO":
                tbl = Tablas.MOTO;
                break;
            case "BICICLETA":
                tbl = Tablas.BICICLETA;
                break;
            case "PATINETE":
                tbl = Tablas.PATINETE;
                break;
        }
        switch (estados.getSelectedItem().toString()){
            case "baja":
                est = Estado.BAJA;
                break;
            case "alquilado":
                est = Estado.ALQUILADO;
                break;
            case "taller":
                est = Estado.TALLER;
                break;
            case "preparado":
                est = Estado.PREPARADO;
                break;
            case "reservado":
                est = Estado.RESERVADO;
                break;
        }
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        switch (spinner.getSelectedItem().toString()){
            case "COCHE":
                    c = new Coche(matriculaEdit.getText().toString(), Float.parseFloat(precioHoEdit.getText().toString()),
                            marcEdit.getText().toString(), descEdit.getText().toString(),
                            color, Float.parseFloat(batEdit.getText().toString()), est, idCarnetEdit.getText().toString(), date,
                            tbl, Float.parseFloat(numPlazaEdit.getText().toString()), Float.parseFloat(numPuerEdit.getText().toString()));
                Connector.getConector().post(Coche.class, c, "/coche");
                break;
            case "MOTO":
                m = new Moto(matriculaEdit.getText().toString(), Float.parseFloat(precioHoEdit.getText().toString()),
                        marcEdit.getText().toString(), descEdit.getText().toString(),
                        color, Float.parseFloat(batEdit.getText().toString()), est, idCarnetEdit.getText().toString(), date,
                        tbl, Float.parseFloat(velmaxEdit.getText().toString()), Float.parseFloat(cilinEdit.getText().toString()));
                Connector.getConector().post(Moto.class, m, "/moto");
                break;
            case "BICICLETA":
                b = new Bicicleta(matriculaEdit.getText().toString(), Float.parseFloat(precioHoEdit.getText().toString()),
                        marcEdit.getText().toString(), descEdit.getText().toString(),
                        color, Float.parseFloat(batEdit.getText().toString()), est, idCarnetEdit.getText().toString(), date,
                        tbl, tipoEdit.getText().toString());
                Connector.getConector().post(Bicicleta.class, b, "/bicicleta");
                break;
            case "PATINETE":
                p = new Patin(matriculaEdit.getText().toString(), Float.parseFloat(precioHoEdit.getText().toString()),
                        marcEdit.getText().toString(), descEdit.getText().toString(),
                        color, Float.parseFloat(batEdit.getText().toString()), est, idCarnetEdit.getText().toString(), date,
                        tbl, Float.parseFloat(numRuedasEdit.getText().toString()), Float.parseFloat(tamanyoEdit.getText().toString()));
                Connector.getConector().post(Patin.class, p, "/patinete");
                break;
        }
    }

    @Override
    public void doInUI() {
        finish();
    }

    @Override
    public void onClick(View view) {
        executeCall(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String s = adapterView.getSelectedItem().toString();
        switch (s){
            case "COCHE":
                numPuerEdit.setVisibility(View.VISIBLE);
                numPlazaEdit.setVisibility(View.VISIBLE);
                tipoEdit.setVisibility(View.GONE);
                velmaxEdit.setVisibility(View.GONE);
                cilinEdit.setVisibility(View.GONE);
                numRuedasEdit.setVisibility(View.GONE);
                tamanyoEdit.setVisibility(View.GONE);
                break;
            case "MOTO":
                numPuerEdit.setVisibility(View.GONE);
                numPlazaEdit.setVisibility(View.GONE);
                tipoEdit.setVisibility(View.GONE);
                velmaxEdit.setVisibility(View.VISIBLE);
                cilinEdit.setVisibility(View.VISIBLE);
                numRuedasEdit.setVisibility(View.GONE);
                tamanyoEdit.setVisibility(View.GONE);
                break;
            case "BICICLETA":
                numPuerEdit.setVisibility(View.GONE);
                numPlazaEdit.setVisibility(View.GONE);
                tipoEdit.setVisibility(View.VISIBLE);
                velmaxEdit.setVisibility(View.GONE);
                cilinEdit.setVisibility(View.GONE);
                numRuedasEdit.setVisibility(View.GONE);
                tamanyoEdit.setVisibility(View.GONE);
                break;
            case "PATINETE":
                numPuerEdit.setVisibility(View.GONE);
                numPlazaEdit.setVisibility(View.GONE);
                tipoEdit.setVisibility(View.GONE);
                velmaxEdit.setVisibility(View.GONE);
                cilinEdit.setVisibility(View.GONE);
                numRuedasEdit.setVisibility(View.VISIBLE);
                tamanyoEdit.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}