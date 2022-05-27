package com.example.taserfan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taserfan.API.Connector;
import com.example.taserfan.Vehiculos.Bicicleta;
import com.example.taserfan.Vehiculos.Coche;
import com.example.taserfan.Vehiculos.Moto;
import com.example.taserfan.Vehiculos.Patin;
import com.example.taserfan.base.BaseActivity;
import com.example.taserfan.base.CallInterface;
import com.google.android.material.snackbar.Snackbar;

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

        ItemTouchHelper mIth = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        // move item in `fromPos` to `toPos` in adapter.
                        recyclerView.getAdapter().notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                        return true;// true if moved, false otherwise
                    }
                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        Vehiculo vehiculo = vehiculoList.get(viewHolder.getAdapterPosition());
                        int position = viewHolder.getAdapterPosition();
                        Coche c;
                        Moto m;
                        Patin p;
                        Bicicleta b;
                        executeCall(new CallInterface() {
                            @Override
                            public void doInBackground() {
                                switch (vehiculo.getTipo()){
                                    case COCHE:
                                        Connector.getConector().delete(Coche.class, "/coche?matricula="+vehiculo.getMatricula());
                                        break;
                                    case MOTO:
                                        Connector.getConector().delete(Coche.class, "/moto?matricula="+vehiculo.getMatricula());
                                        break;
                                    case BICICLETA:
                                        Connector.getConector().delete(Coche.class, "/bicicleta?matricula="+vehiculo.getMatricula());
                                        break;
                                    case PATINETE:
                                        Connector.getConector().delete(Coche.class, "/patinete?matricula="+vehiculo.getMatricula());
                                        break;
                                }
                            }
                            @Override
                            public void doInUI() {
                                vehiculoList.remove(position);
                                adaptador.notifyItemRemoved(position);
                                adaptador.notifyDataSetChanged();
                            }
                        });
                    }
                });
        mIth.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View view){
        Intent myIntent = new Intent(AcitivityOfVehicles.this,VehicleDetail.class);
        int i = recyclerView.getChildAdapterPosition(view);
        myIntent.putExtra("matricula", vehiculoList.get(i).getMatricula());
        myIntent.putExtra("tabla", vehiculoList.get(i).getTipo());
        startActivity(myIntent);
    }
}