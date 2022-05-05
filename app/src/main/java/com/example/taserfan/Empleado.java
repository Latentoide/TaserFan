package com.example.taserfan;

import java.util.Date;

public class Empleado {
    private String nombre, apellidos, domiciolio, codigoPostal;
    private String dni;
    private Date fecha;

    public Empleado(String nombre, String apellidos, String domiciolio, String codigoPostal, String dni, Date fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domiciolio = domiciolio;
        this.codigoPostal = codigoPostal;
        this.dni = dni;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomiciolio() {
        return domiciolio;
    }

    public void setDomiciolio(String domiciolio) {
        this.domiciolio = domiciolio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
