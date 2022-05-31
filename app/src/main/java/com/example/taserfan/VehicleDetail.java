package com.example.taserfan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.taserfan.API.Connector;
import com.example.taserfan.API.Result;
import com.example.taserfan.Vehiculos.Bicicleta;
import com.example.taserfan.Vehiculos.Coche;
import com.example.taserfan.Vehiculos.Moto;
import com.example.taserfan.Vehiculos.Patin;
import com.example.taserfan.base.BaseActivity;
import com.example.taserfan.base.CallInterface;

import java.sql.Date;

public class VehicleDetail extends BaseActivity implements CallInterface {
    private Tablas tabla;
    private String matricula;
    private Context context;
    Result<Coche> c;
    Result<Moto> m;
    Result<Patin> p;
    Result<Bicicleta> b;

    Moto miMoto = null;
    Coche miCoche = null;
    Patin miPatin = null;
    Bicicleta miBici = null;

    Coche coche;
    Moto moto;
    Patin patin;
    Bicicleta bicicleta;

    ImageView im;

    TextView desc;
    TextView matr;
    TextView bat;
    TextView marc;
    TextView estado;
    TextView precioHo;
    TextView numPuer;
    TextView numPlaza;
    TextView tipo;
    TextView velmax;
    TextView cilin;
    TextView numRuedas;
    TextView tamanyo;

    EditText descEdit;
    EditText batEdit;
    EditText marcEdit;
    EditText estadoEdit;
    EditText precioHoEdit;
    EditText numPuerEdit;
    EditText numPlazaEdit;
    EditText tipoEdit;
    EditText velmaxEdit;
    EditText cilinEdit;
    EditText numRuedasEdit;
    EditText tamanyoEdit;

    Button elUpdate;
    Button cancelar;
    Button confirmar;
    String theColor="";
    Color elColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        tabla = (Tablas) getIntent().getExtras().getSerializable("tabla");
        matricula = getIntent().getExtras().getString("matricula");
        context = this;
        im = findViewById(R.id.fotoDet);
        desc = findViewById(R.id.descDet);
        matr = findViewById(R.id.matriDet);
        bat = findViewById(R.id.batDet);
        marc = findViewById(R.id.marcaDet);
        estado = findViewById(R.id.estaDet);
        precioHo = findViewById(R.id.precioDet);
        numPuer = findViewById(R.id.numPu);
        numPlaza = findViewById(R.id.numPla);
        tipo = findViewById(R.id.tipo);
        velmax = findViewById(R.id.velMax);
        cilin = findViewById(R.id.cilin);
        numRuedas = findViewById(R.id.numRuedas);
        tamanyo = findViewById(R.id.tamanyo);


        descEdit = findViewById(R.id.descChange);
        batEdit = findViewById(R.id.batChange);
        marcEdit = findViewById(R.id.marcaChange);
        estadoEdit = findViewById(R.id.estaChange);
        precioHoEdit = findViewById(R.id.precioChange);
        numPuerEdit = findViewById(R.id.numPuChange);
        numPlazaEdit = findViewById(R.id.numPlaChange);
        tipoEdit = findViewById(R.id.tipoChange);
        velmaxEdit = findViewById(R.id.velChange);
        cilinEdit = findViewById(R.id.cilinChange);
        numRuedasEdit = findViewById(R.id.numRuedasChange);
        tamanyoEdit = findViewById(R.id.tamanyoChange);

        elUpdate = findViewById(R.id.elInsert);
        cancelar = findViewById(R.id.Cancelar);
        confirmar = findViewById(R.id.confirmar);

        executeCall(this);
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
        switch (tabla){
            case COCHE:
                im.setImageResource(R.drawable.ic_car);
                coche = ((Result.Success<Coche>) c).getData();
                numPuer.setVisibility(View.VISIBLE);
                numPlaza.setVisibility(View.VISIBLE);
                velmax.setVisibility(View.GONE);
                cilin.setVisibility(View.GONE);
                tipo.setVisibility(View.GONE);
                numRuedas.setVisibility(View.GONE);
                tamanyo.setVisibility(View.GONE);
                theColor = coche.getColor();
                desc.setText(coche.getDescripcion());
                matr.setText(coche.getMatricula());
                bat.setText(String.valueOf(coche.getBateria()));
                marc.setText(coche.getMarca());
                estado.setText(coche.getEstado());
                precioHo.setText(String.valueOf(coche.getPrecioHora()));
                numPuer.setText(String.valueOf(coche.getNumPuertas()));
                numPlaza.setText(String.valueOf(coche.getNumPlazas()));
                break;
            case MOTO:
                im.setImageResource(R.drawable.ic_moto);
                moto = ((Result.Success<Moto>) m).getData();
                numPuer.setVisibility(View.GONE);
                numPlaza.setVisibility(View.GONE);
                tipo.setVisibility(View.GONE);
                velmax.setVisibility(View.VISIBLE);
                cilin.setVisibility(View.VISIBLE);
                numRuedas.setVisibility(View.GONE);
                tamanyo.setVisibility(View.GONE);
                theColor = moto.getColor();
                desc.setText(moto.getDescripcion());
                matr.setText(moto.getMatricula());
                bat.setText(String.valueOf(moto.getBateria()));
                marc.setText(moto.getMarca());
                estado.setText(moto.getEstado());
                precioHo.setText(String.valueOf(moto.getPrecioHora()));
                velmax.setText(String.valueOf(moto.getVelMax()));
                cilin.setText(String.valueOf(moto.getCilindrada()));

                break;
            case BICICLETA:
                im.setImageResource(R.drawable.ic_bicicleta);
                bicicleta = ((Result.Success<Bicicleta>) b).getData();
                numPuer.setVisibility(View.GONE);
                numPlaza.setVisibility(View.GONE);
                tipo.setVisibility(View.VISIBLE);
                velmax.setVisibility(View.GONE);
                cilin.setVisibility(View.GONE);
                numRuedas.setVisibility(View.GONE);
                tamanyo.setVisibility(View.GONE);
                theColor = bicicleta.getColor();
                desc.setText(bicicleta.getDescripcion());
                matr.setText(bicicleta.getMatricula());
                bat.setText(String.valueOf(bicicleta.getBateria()));
                marc.setText(bicicleta.getMarca());
                estado.setText(bicicleta.getEstado());
                precioHo.setText(String.valueOf(bicicleta.getPrecioHora()));
                tipo.setText(bicicleta.getTipoBic());
                break;
            case PATINETE:
                im.setImageResource(R.drawable.ic_patinete);
                patin =((Result.Success<Patin>) p).getData();
                numPuer.setVisibility(View.GONE);
                numPlaza.setVisibility(View.GONE);
                tipo.setVisibility(View.GONE);
                velmax.setVisibility(View.GONE);
                cilin.setVisibility(View.GONE);
                numRuedas.setVisibility(View.VISIBLE);
                tamanyo.setVisibility(View.VISIBLE);
                theColor = patin.getColor();
                desc.setText(patin.getDescripcion());
                matr.setText(patin.getMatricula());
                bat.setText(String.valueOf(patin.getBateria()));
                marc.setText(patin.getMarca());
                estado.setText(patin.getEstado());
                precioHo.setText(String.valueOf(patin.getPrecioHora()));
                numRuedas.setText(String.valueOf(patin.getNumRuedas()));
                tamanyo.setText(String.valueOf(patin.getTamanyo()));
                break;
        }

        switch (theColor){
            case "verde":
                elColor = Color.VERDE;
                im.setColorFilter(ContextCompat.getColor(this,R.color.verde));
                break;
            case "amarillo":
                elColor = Color.AMARILLO;
                im.setColorFilter(ContextCompat.getColor(this,R.color.amarillo));
                break;
            case "rojo":
                elColor = Color.ROJO;
                im.setColorFilter(ContextCompat.getColor(this,R.color.rojo));
                break;
            case "blanco":
                elColor = Color.BLANCO;
                im.setColorFilter(ContextCompat.getColor(this,R.color.gris));
                break;
            case "negro":
                elColor = Color.NEGRO;
                im.setColorFilter(ContextCompat.getColor(this,R.color.grisOscuro));
                break;
            case "azul":
                elColor = Color.AZUL;
                im.setColorFilter(ContextCompat.getColor(this,R.color.azul));
                break;
        }

        elUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descEdit.setVisibility(View.VISIBLE);
                descEdit.setText(desc.getText());
                batEdit.setVisibility(View.VISIBLE);
                bat.setText(bat.getText());
                marcEdit.setVisibility(View.VISIBLE);
                marcEdit.setText(marc.getText());
                estadoEdit.setVisibility(View.VISIBLE);
                estadoEdit.setText(estado.getText());
                precioHoEdit.setVisibility(View.VISIBLE);
                precioHoEdit.setText(precioHo.getText());
                confirmar.setVisibility(View.VISIBLE);
                numPuer.setVisibility(View.GONE);
                numPlaza.setVisibility(View.GONE);
                velmax.setVisibility(View.GONE);
                cilin.setVisibility(View.GONE);
                tipo.setVisibility(View.GONE);
                numRuedas.setVisibility(View.GONE);
                tamanyo.setVisibility(View.GONE);
                desc.setVisibility(View.GONE);
                matr.setVisibility(View.GONE);
                bat.setVisibility(View.GONE);
                marc.setVisibility(View.GONE);
                estado.setVisibility(View.GONE);
                precioHo.setVisibility(View.GONE);
                switch (tabla){
                    case COCHE:

                        numPuerEdit.setVisibility(View.VISIBLE);
                        numPuerEdit.setText(numPuer.getText());
                        numPlazaEdit.setVisibility(View.VISIBLE);
                        numPlazaEdit.setText(numPlaza.getText());
                        tipoEdit.setVisibility(View.GONE);
                        velmaxEdit.setVisibility(View.GONE);
                        cilinEdit.setVisibility(View.GONE);
                        numRuedasEdit.setVisibility(View.GONE);
                        tamanyoEdit.setVisibility(View.GONE);
                        break;
                    case MOTO:
                        numPuerEdit.setVisibility(View.GONE);
                        numPlazaEdit.setVisibility(View.GONE);
                        tipoEdit.setVisibility(View.GONE);
                        velmaxEdit.setVisibility(View.VISIBLE);
                        velmaxEdit.setText(velmax.getText());
                        cilinEdit.setVisibility(View.VISIBLE);
                        cilinEdit.setText(cilin.getText());
                        numRuedasEdit.setVisibility(View.GONE);
                        tamanyoEdit.setVisibility(View.GONE);

                        break;
                    case BICICLETA:
                        numPuerEdit.setVisibility(View.GONE);
                        numPlazaEdit.setVisibility(View.GONE);
                        tipoEdit.setVisibility(View.VISIBLE);
                        tipoEdit.setText(tipo.getText());
                        velmaxEdit.setVisibility(View.GONE);
                        cilinEdit.setVisibility(View.GONE);
                        numRuedasEdit.setVisibility(View.GONE);
                        tamanyoEdit.setVisibility(View.GONE);
                        break;
                    case PATINETE:
                        numPuerEdit.setVisibility(View.GONE);
                        numPlazaEdit.setVisibility(View.GONE);
                        tipoEdit.setVisibility(View.GONE);
                        velmaxEdit.setVisibility(View.GONE);
                        cilinEdit.setVisibility(View.GONE);
                        numRuedasEdit.setVisibility(View.VISIBLE);
                        numRuedasEdit.setText(numRuedas.getText());
                        tamanyoEdit.setVisibility(View.VISIBLE);
                        tamanyoEdit.setText(tamanyo.getText());
                        break;
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String theColor="";
                descEdit.setVisibility(View.GONE);
                batEdit.setVisibility(View.GONE);
                marcEdit.setVisibility(View.GONE);
                estadoEdit.setVisibility(View.GONE);
                precioHoEdit.setVisibility(View.GONE);
                confirmar.setVisibility(View.GONE);
                numPuerEdit.setVisibility(View.GONE);
                numPlazaEdit.setVisibility(View.GONE);
                tipoEdit.setVisibility(View.GONE);
                velmaxEdit.setVisibility(View.GONE);
                cilinEdit.setVisibility(View.GONE);
                numRuedasEdit.setVisibility(View.GONE);
                tamanyoEdit.setVisibility(View.GONE);
                switch (tabla){
                    case COCHE:
                        im.setImageResource(R.drawable.ic_car);
                        coche = ((Result.Success<Coche>) c).getData();
                        numPuer.setVisibility(View.VISIBLE);
                        numPlaza.setVisibility(View.VISIBLE);
                        velmax.setVisibility(View.GONE);
                        cilin.setVisibility(View.GONE);
                        tipo.setVisibility(View.GONE);
                        numRuedas.setVisibility(View.GONE);
                        tamanyo.setVisibility(View.GONE);
                        theColor = coche.getColor();
                        desc.setText(coche.getDescripcion());
                        matr.setText(coche.getMatricula());
                        bat.setText(String.valueOf(coche.getBateria()));
                        marc.setText(coche.getMarca());
                        estado.setText(coche.getEstado());
                        precioHo.setText(String.valueOf(coche.getPrecioHora()));
                        numPuer.setText(String.valueOf(coche.getNumPuertas()));
                        numPlaza.setText(String.valueOf(coche.getNumPlazas()));
                        break;
                    case MOTO:
                        im.setImageResource(R.drawable.ic_moto);
                        moto = ((Result.Success<Moto>) m).getData();
                        numPuer.setVisibility(View.GONE);
                        numPlaza.setVisibility(View.GONE);
                        tipo.setVisibility(View.GONE);
                        velmax.setVisibility(View.VISIBLE);
                        cilin.setVisibility(View.VISIBLE);
                        numRuedas.setVisibility(View.GONE);
                        tamanyo.setVisibility(View.GONE);
                        theColor = moto.getColor();
                        desc.setText(moto.getDescripcion());
                        matr.setText(moto.getMatricula());
                        bat.setText(String.valueOf(moto.getBateria()));
                        marc.setText(moto.getMarca());
                        estado.setText(moto.getEstado());
                        precioHo.setText(String.valueOf(moto.getPrecioHora()));
                        velmax.setText(String.valueOf(moto.getVelMax()));
                        cilin.setText(String.valueOf(moto.getCilindrada()));

                        break;
                    case BICICLETA:
                        im.setImageResource(R.drawable.ic_bicicleta);
                        bicicleta = ((Result.Success<Bicicleta>) b).getData();
                        numPuer.setVisibility(View.GONE);
                        numPlaza.setVisibility(View.GONE);
                        tipo.setVisibility(View.VISIBLE);
                        velmax.setVisibility(View.GONE);
                        cilin.setVisibility(View.GONE);
                        numRuedas.setVisibility(View.GONE);
                        tamanyo.setVisibility(View.GONE);
                        theColor = bicicleta.getColor();
                        desc.setText(bicicleta.getDescripcion());
                        matr.setText(bicicleta.getMatricula());
                        bat.setText(String.valueOf(bicicleta.getBateria()));
                        marc.setText(bicicleta.getMarca());
                        estado.setText(bicicleta.getEstado());
                        precioHo.setText(String.valueOf(bicicleta.getPrecioHora()));
                        tipo.setText(bicicleta.getTipoBic());
                        break;
                    case PATINETE:
                        im.setImageResource(R.drawable.ic_patinete);
                        patin =((Result.Success<Patin>) p).getData();
                        numPuer.setVisibility(View.GONE);
                        numPlaza.setVisibility(View.GONE);
                        tipo.setVisibility(View.GONE);
                        velmax.setVisibility(View.GONE);
                        cilin.setVisibility(View.GONE);
                        numRuedas.setVisibility(View.VISIBLE);
                        tamanyo.setVisibility(View.VISIBLE);
                        theColor = patin.getColor();
                        desc.setText(patin.getDescripcion());
                        matr.setText(patin.getMatricula());
                        bat.setText(String.valueOf(patin.getBateria()));
                        marc.setText(patin.getMarca());
                        estado.setText(patin.getEstado());
                        precioHo.setText(String.valueOf(patin.getPrecioHora()));
                        numRuedas.setText(String.valueOf(patin.getNumRuedas()));
                        tamanyo.setText(String.valueOf(patin.getTamanyo()));
                        break;
                }

                switch (theColor){
                    case "verde":
                        im.setColorFilter(ContextCompat.getColor(context,R.color.verde));
                        break;
                    case "amarillo":
                        im.setColorFilter(ContextCompat.getColor(context,R.color.amarillo));
                        break;
                    case "rojo":
                        im.setColorFilter(ContextCompat.getColor(context,R.color.rojo));
                        break;
                    case "blanco":
                        im.setColorFilter(ContextCompat.getColor(context,R.color.gris));
                        break;
                    case "negro":
                        im.setColorFilter(ContextCompat.getColor(context,R.color.grisOscuro));
                        break;
                    case "azul":
                        im.setColorFilter(ContextCompat.getColor(context,R.color.azul));
                        break;
                }
            }
        });
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estado elEstado = Estado.BAJA;

                switch (estadoEdit.getText().toString()){
                    case "baja":
                            elEstado = Estado.BAJA;
                        break;
                    case "alquilado":
                        elEstado = Estado.ALQUILADO;
                        break;
                    case "taller":
                        elEstado = Estado.TALLER;
                        break;
                    case "preparado":
                        elEstado = Estado.PREPARADO;
                        break;
                    case "reserverdo":
                        elEstado = Estado.RESERVADO;
                        break;
                }

                switch (tabla){
                    case MOTO:
                        miMoto = new Moto(descEdit.getText().toString(), Float.parseFloat(precioHoEdit.getText().toString()), marcEdit.getText().toString(), descEdit.getText().toString(), elColor, Float.parseFloat(batEdit.getText().toString()),  elEstado, moto.getIdCarnet(), moto.getDate(), Tablas.MOTO, Float.parseFloat(velmaxEdit.getText().toString()), Float.parseFloat(cilinEdit.getText().toString()));
                        break;
                    case COCHE:
                        miCoche = new Coche(descEdit.getText().toString(), Float.parseFloat(precioHoEdit.getText().toString()), marcEdit.getText().toString(), descEdit.getText().toString(), elColor, Float.parseFloat(batEdit.getText().toString()),  elEstado, coche.getIdCarnet(), coche.getDate(), Tablas.COCHE, Float.parseFloat(numPlazaEdit.getText().toString()), Float.parseFloat(numPlazaEdit.getText().toString()));
                        break;
                    case PATINETE:
                        miPatin = new Patin(descEdit.getText().toString(), Float.parseFloat(precioHoEdit.getText().toString()), marcEdit.getText().toString(), descEdit.getText().toString(), elColor, Float.parseFloat(batEdit.getText().toString()),  elEstado, patin.getIdCarnet(), patin.getDate(), Tablas.PATINETE, Float.parseFloat(numRuedasEdit.getText().toString()), Float.parseFloat(tamanyoEdit.getText().toString()));
                        break;
                    case BICICLETA:
                        miBici = new Bicicleta(descEdit.getText().toString(), Float.parseFloat(precioHoEdit.getText().toString()), marcEdit.getText().toString(), descEdit.getText().toString(), elColor, Float.parseFloat(batEdit.getText().toString()),  elEstado, bicicleta.getIdCarnet(), bicicleta.getDate(), Tablas.BICICLETA, tipoEdit.getText().toString());
                        break;
                }
                executeCall(new CallInterface() {
                    @Override
                    public void doInBackground() {
                        switch (tabla){
                            case MOTO:
                                Connector.getConector().put(Moto.class, miMoto, "/moto");
                                break;
                            case COCHE:
                                Connector.getConector().put(Coche.class, miCoche, "/coche");
                                break;
                            case PATINETE:
                                Connector.getConector().put(Patin.class, miPatin, "/patinete");
                                break;
                            case BICICLETA:
                                Connector.getConector().put(Bicicleta.class, miBici, "/bicicleta");
                                break;
                        }
                    }

                    @Override
                    public void doInUI() {
                        Intent intent = new Intent(context, AcitivityOfVehicles.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}