package com.aluracursos.conversordemoneda.metods;

import java.util.Map;

public record MonedaAPI(String base, int amount, Map<String, Double> result) {

}
