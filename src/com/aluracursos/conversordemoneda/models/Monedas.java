package com.aluracursos.conversordemoneda.models;

import com.aluracursos.conversordemoneda.metods.MonedaAPI;

import java.util.Map;

public class Monedas{
    private String base;
    private int amount;
    private Map<Double, String> result;

    public Monedas(MonedaAPI base) {
        this.base = String.valueOf(base);
    }



    public void setLugar(String base) {
        this.base = base;
    }

}
