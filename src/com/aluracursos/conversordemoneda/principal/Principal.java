package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.models.Monedas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) {
//convert?from=MXN&to=USD&amount=500
        Monedas monedaUsa = new Monedas("USD");
        Monedas monedaMex = new Monedas("MXN");
        Monedas monedaEur = new Monedas("EUR");
        int cantidad = 500;
        var direccion = URI.create("https://api.fastforex.io/convert?api_key=8a4c8cfa1f-6a2b6d9b2a-schi30&convert?from=" + monedaUsa+ "&to="+ monedaMex+ "&amount=" + cantidad);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(direccion);
            String json = response.body();
            System.out.println(json);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
