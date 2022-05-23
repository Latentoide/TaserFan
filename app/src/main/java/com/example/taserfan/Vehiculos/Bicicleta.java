package com.example.taserfan.Vehiculos;

import java.sql.Date;
import com.example.taserfan.Color;
import com.example.taserfan.Estado;
import com.example.taserfan.Tablas;
import com.example.taserfan.Vehiculo;

public class Bicicleta extends Vehiculo{
    private String tipo;

    public Bicicleta(String matricula, float precioHora, String marca, String descripcion, Color color, float bateria, Estado estado, String idCarnet, Date date, Tablas tablas, String tipo) {
        super(matricula, precioHora, marca, descripcion, color, bateria, estado, idCarnet, date, tablas);
        this.tipo = tipo;
    }

    public String getTipoBic() {
        return tipo;
    }

    public void setTipoBic(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  super.toString() + "(Bicicleta{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
