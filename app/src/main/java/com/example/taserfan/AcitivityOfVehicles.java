package com.example.taserfan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taserfan.API.Connector;
import com.example.taserfan.base.BaseActivity;
import com.example.taserfan.base.CallInterface;

import java.util.LinkedList;
import java.util.List;

public class AcitivityOfVehicles extends BaseActivity implements CallInterface, View.OnClickListener {
    private RecyclerView recyclerView;
    private List<Vehiculo> vehiculoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_of_vehicles);
        executeCall(this);
    }

    @Override
    public void doInBackground() {
        //hacer llamada y guardarla
        vehiculoList = new LinkedList<>(Connector.getConector().getAsList(Vehiculo.class, "/all"));
    }

    @Override
    public void doInUI() {
        recyclerView = findViewById(R.id.reciclerView);
        MyReciclerViewAdapter adaptador = new MyReciclerViewAdapter(this,vehiculoList);
        adaptador.setOnClickListener(this);
        recyclerView.setAdapter(adaptador);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View view){
        Intent myIntent = new Intent(AcitivityOfVehicles.this,VehicleDetail.class);
        int i = recyclerView.getChildAdapterPosition(view);
        myIntent.putExtra("infoPosition", vehiculoList.get(i));
        startActivity(myIntent);
    }
}