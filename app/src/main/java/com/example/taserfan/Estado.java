package com.example.taserfan;

public enum Estado {
    BAJA("baja"), ALQUILADO("alquilado"), TALLER("taller"), PREPARADO("preparado"), RESERVADO("reserverdo");
    private String str;
    Estado(String str){
        this.str = str;
    }

    public String getEstado(){
        return str;
    }
}
