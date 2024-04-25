package com.aluracursos.conversordemoneda.models;

public class Monedas {
    private String lugar;

    public Monedas(String lugar) {
        this.lugar = lugar;
    }



    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return lugar;
    }
}
