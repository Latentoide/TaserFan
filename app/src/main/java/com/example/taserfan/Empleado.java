package com.example.taserfan;



public class Empleado {
    private String nombre, apellidos, domiciolio, codigoPostal;
    private String dni;


    public Empleado(String nombre, String apellidos, String domiciolio, String codigoPostal, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domiciolio = domiciolio;
        this.codigoPostal = codigoPostal;
        this.dni = dni;

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


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

