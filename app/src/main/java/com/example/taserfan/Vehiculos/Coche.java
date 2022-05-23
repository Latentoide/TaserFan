package com.example.taserfan.Vehiculos;

import com.example.taserfan.Color;
import com.example.taserfan.Estado;
import com.example.taserfan.Tablas;
import com.example.taserfan.Vehiculo;

import java.sql.Date;

public class Coche extends Vehiculo {
    private float numPlazas;
    private float numPuertas;

    public Coche(String matricula, float precioHora, String marca, String descripcion, Color color, float bateria, Estado estado, String idCarnet, Date date, Tablas tablas, float numPlazas, float numPuertas) {
        super(matricula, precioHora, marca, descripcion, color, bateria, estado, idCarnet, date, tablas);
        this.numPlazas = numPlazas;
        this.numPuertas = numPuertas;
    }

    public float getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(float numPlazas) {
        this.numPlazas = numPlazas;
    }

    public float getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(float numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return super.toString() + "({Coche: "+
                ", numPlazas=" + numPlazas +
                ", numPuertas=" + numPuertas +
                "})";
    }
}
