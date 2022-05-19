package com.example.taserfan;

import java.io.Serializable;
import java.sql.Date;

public class Vehiculo implements Serializable {
        private String matricula;
        private float precioHora;
        private String marca;
        private String descripcion;
        private String color;
        private float bateria;
        private String estado;
        private String idCarnet;
        private Date date;
        private Tablas tipo;

        public Vehiculo(String matricula, float precioHora, String marca, String descripcion, String color, float bateria, String estado, String idCarnet, Date date, Tablas tipo) {
            this.matricula = matricula;
            this.precioHora = precioHora;
            this.marca = marca;
            this.descripcion = descripcion;
            this.color = color;
            this.bateria = bateria;
            this.estado = estado;
            this.idCarnet = idCarnet;
            this.date = date;
            this.tipo = tipo;
        }

        public Vehiculo(String matricula,float precioHora,String marca,String color,String estado,String idCarnet, Tablas tipo){
            this.matricula = matricula;
            this.precioHora = precioHora;
            this.marca = marca;
            this.color = color;
            this.idCarnet = idCarnet;
            this.tipo = tipo;
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

        public String getIdCarnet() {
            return idCarnet;
        }

        public void setIdCarnet(String idCarnet) {
            this.idCarnet = idCarnet;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Tablas getTipo() {
            return tipo;
        }

        public void setTipo(Tablas tipo) {
            this.tipo = tipo;
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
