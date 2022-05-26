package com.example.taserfan;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.taserfan.API.Connector;
import com.example.taserfan.API.Result;
import com.example.taserfan.Vehiculos.Bicicleta;
import com.example.taserfan.Vehiculos.Coche;
import com.example.taserfan.Vehiculos.Moto;
import com.example.taserfan.Vehiculos.Patin;
import com.example.taserfan.base.BaseActivity;
import com.example.taserfan.base.CallInterface;

public class VehicleDetail extends BaseActivity implements CallInterface {
    private Tablas tabla;
    private String matricula;
    Result<Coche> c;
    Result<Moto> m;
    Result<Patin> p;
    Result<Bicicleta> b;

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
    EditText matrEdit;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        tabla = (Tablas) getIntent().getExtras().getSerializable("tabla");
        matricula = getIntent().getExtras().getString("matricula");

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
        matrEdit = findViewById(R.id.matriChange);
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
        String theColor="";
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
                im.setColorFilter(ContextCompat.getColor(this,R.color.verde));
                break;
            case "amarillo":
                im.setColorFilter(ContextCompat.getColor(this,R.color.amarillo));
                break;
            case "rojo":
                im.setColorFilter(ContextCompat.getColor(this,R.color.rojo));
                break;
            case "blanco":
                im.setColorFilter(ContextCompat.getColor(this,R.color.gris));
                break;
            case "negro":
                im.setColorFilter(ContextCompat.getColor(this,R.color.grisOscuro));
                break;
            case "azul":
                im.setColorFilter(ContextCompat.getColor(this,R.color.azul));
                break;
        }
    }
}