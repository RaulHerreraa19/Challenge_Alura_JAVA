package com.aluracursos.conversordemoneda.models;

import com.aluracursos.conversordemoneda.metods.MonedaAPI;

import java.util.Map;

public class Monedas{
    private String base_code;
    private String target_code;
    private int conversion_rate;
    private int conversion_result;
    public int amount;
    public Monedas(MonedaAPI base) {
        this.base_code = String.valueOf(base);
    }



    public void setLugar(String base) {
        this.base_code = base;
    }

    @Override
    public String toString() {
        return "Estás convirtiendo la cantidad de " + amount + " de " + base_code + " a " + target_code + "Y equivale a " + conversion_result + target_code;
    }
}
