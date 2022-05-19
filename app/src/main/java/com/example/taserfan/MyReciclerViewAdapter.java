package com.example.taserfan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyReciclerViewAdapter extends RecyclerView.Adapter<MyReciclerViewAdapter.ViewHolder> {
    private LayoutInflater myInflator;
    private View.OnClickListener myClicker;
    private List<Vehiculo> myVehicleList;

    public  MyReciclerViewAdapter(Context myContext, List<Vehiculo> myVehicleList){
        this.myVehicleList = myVehicleList;
        myInflator = (LayoutInflater) myContext.getSystemService(myContext.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = myInflator.inflate(R.layout.view_layout, parent,false);
        view.setOnClickListener(myClicker);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position){
        Vehiculo v = myVehicleList.get(position);
        switch (v.getTipo()){
            case MOTO:
                //viewHolder.imageView.setImageResource(R.drawable.);
                break;
            case COCHE:
                //viewHolder.imageView.setImageResource(R.drawable.);
                break;
            case PATINETE:
                //viewHolder.imageView.setImageResource(R.drawable.);
                break;
            case BICICLETA:
                //viewHolder.imageView.setImageResource(R.drawable.);
                break;
        }
        viewHolder.estado.setText(v.getEstado());
        viewHolder.marca.setText(v.getMarca());
        viewHolder.precio.setText(String.valueOf(v.getPrecioHora()));
        viewHolder.matricula.setText(v.getMatricula());
        viewHolder.nombre.setText(v.getDescripcion());
        viewHolder.color.setText(v.getColor());

    }

    @Override
    public int getItemCount(){
        return myVehicleList.size();
    }

    public void setOnClickListener(View.OnClickListener click){
        myClicker = click;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        TextView color;
        TextView matricula;
        TextView nombre;
        TextView precio;
        TextView marca;
        TextView estado;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.fotoVel);
            color = itemView.findViewById(R.id.color);
            matricula = itemView.findViewById(R.id.matricula);
            nombre = itemView.findViewById(R.id.nombre);
            precio = itemView.findViewById(R.id.precio);
            marca = itemView.findViewById(R.id.marca);
            estado = itemView.findViewById(R.id.estado);
        }

    }
}
