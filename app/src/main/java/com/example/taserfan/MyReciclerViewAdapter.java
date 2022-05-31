package com.example.taserfan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyReciclerViewAdapter extends RecyclerView.Adapter<MyReciclerViewAdapter.ViewHolder> {
    private LayoutInflater myInflator;
    private View.OnClickListener myClicker;
    private List<Vehiculo> myVehicleList;
    private Context context;

    public  MyReciclerViewAdapter(Context myContext, List<Vehiculo> myVehicleList){
        this.myVehicleList = myVehicleList;
        context = myContext;
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
                viewHolder.imageView.setImageResource(R.drawable.ic_moto);
                break;
            case COCHE:
                viewHolder.imageView.setImageResource(R.drawable.ic_car);
                break;
            case PATINETE:
                viewHolder.imageView.setImageResource(R.drawable.ic_patinete);
                break;
            case BICICLETA:
                viewHolder.imageView.setImageResource(R.drawable.ic_bicicleta);
                break;
        }

        switch (v.getColor()){
            case "verde":
                viewHolder.imageView.setColorFilter(ContextCompat.getColor(context,R.color.verde));
                break;
            case "amarillo":
                viewHolder.imageView.setColorFilter(ContextCompat.getColor(context,R.color.amarillo));
                break;
            case "rojo":
                viewHolder.imageView.setColorFilter(ContextCompat.getColor(context,R.color.rojo));
                break;
            case "blanco":
                viewHolder.imageView.setColorFilter(ContextCompat.getColor(context,R.color.gris));
                break;
            case "negro":
                viewHolder.imageView.setColorFilter(ContextCompat.getColor(context,R.color.grisOscuro));
                break;
            case "azul":
                viewHolder.imageView.setColorFilter(ContextCompat.getColor(context,R.color.azul));
                break;
        }

        viewHolder.estado.setText(v.getEstado());
        viewHolder.precio.setText(v.getPrecioHora() + "€");
        viewHolder.matricula.setText(v.getMatricula());
        viewHolder.marca.setText(v.getMarca());
        viewHolder.setBackground(position);

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
        TextView matricula;
        TextView precio;
        TextView marca;
        TextView estado;
        View view;



        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.fotoVel);
            matricula = itemView.findViewById(R.id.matricula);
            precio = itemView.findViewById(R.id.precio);
            marca = itemView.findViewById(R.id.marca);
            estado = itemView.findViewById(R.id.estado);
            this.view = itemView;
        }

        public void setBackground(int position){
            if(position%2 == 0){
                view.setBackgroundColor(context.getResources().getColor(R.color.blacoLocura));
            }
            else{
                view.setBackgroundColor(context.getResources().getColor(R.color.moraditoOsc));
            }
        }


    }
}
