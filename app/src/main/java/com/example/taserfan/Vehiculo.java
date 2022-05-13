package com.example.taserfan;

import java.sql.Date;

public class Vehiculo {
    private String matricula;
    private float precioHora;
    private String marca;
    private String descripcion;
    private String color;
    private float bateria;
    private String estado;
    private float idCarnet;
    private Date date;

    public Vehiculo(String matricula, float precioHora, String marca, String descripcion, String color, float bateria, String estado, float idCarnet, Date date) {
        this.matricula = matricula;
        this.precioHora = precioHora;
        this.marca = marca;
        this.descripcion = descripcion;
        this.color = color;
        this.bateria = bateria;
        this.estado = estado;
        this.idCarnet = idCarnet;
        this.date = date;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(float precioHora) {
        this.precioHora = precioHora;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getBateria() {
        return bateria;
    }

    public void setBateria(float bateria) {
        this.bateria = bateria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getIdCarnet() {
        return idCarnet;
    }

    public void setIdCarnet(float idCarnet) {
        this.idCarnet = idCarnet;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", precioHora=" + precioHora +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", color='" + color + '\'' +
                ", bateria=" + bateria +
                ", estado='" + estado + '\'' +
                ", idCarnet=" + idCarnet +
                '}';
    }
}
