package com.example.taserfan.Vehiculos;

import java.sql.Date;
import com.example.taserfan.Color;
import com.example.taserfan.Estado;
import com.example.taserfan.Tablas;
import com.example.taserfan.Vehiculo;

public class Patin extends Vehiculo{
    private float numRuedas;
    private float tamanyo;

    public Patin(String matricula, float precioHora, String marca, String descripcion, Color color, float bateria, Estado estado, String idCarnet, Date date, Tablas tablas, float numRuedas, float tamanyo) {
        super(matricula, precioHora, marca, descripcion, color, bateria, estado, idCarnet, date, tablas);
        this.numRuedas = numRuedas;
        this.tamanyo = tamanyo;
    }

    public float getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(float numRuedas) {
        this.numRuedas = numRuedas;
    }

    public float getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(float tamanyo) {
        this.tamanyo = tamanyo;
    }

    @Override
    public String toString() {
        return super.toString() + "(Patin{" +
                ", numRuedas=" + numRuedas +
                ", tamanyo=" + tamanyo +
                '}';
    }
}
