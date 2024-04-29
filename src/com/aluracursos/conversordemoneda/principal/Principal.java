package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.metods.MonedaAPI;
import com.aluracursos.conversordemoneda.models.Monedas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String monedaDeCambio = "";
        String monedaACambiar = "";
        int cantidad;
        int opcionDeConversion = 0;


        while (opcionDeConversion != 9) {

            System.out.println("""
                    *******************************************************
                    Sea bienvenido/a al Conversor de Moneda :D
                    1) Dolar =>> Peso Argentino
                    2) Peso Argentino =>> Dolar
                    3) Dolar =>> Real Brasileño
                    4) Real Brasileño =>> Dolar
                    5) Dolar =>> Peso Colombiano
                    6) Peso Colombiano =>> Dolar
                    7) Dolar =>> Peso Mexicano
                    8) Peso Mexicano =>> Dolar
                    9) Salir
                    Elija una opción Válida:
                    *******************************************************
                    """);
            Scanner input = new Scanner(System.in);
            opcionDeConversion = input.nextInt();

            switch (opcionDeConversion) {
                case 1:
                    monedaDeCambio = "USD";
                    monedaACambiar = "ARS";
                    break;
                case 2:
                    monedaDeCambio = "ARS";
                    monedaACambiar = "USD";
                    break;
                case 3:
                    monedaDeCambio = "USD";
                    monedaACambiar = "BRL";
                    break;
                case 4:
                    monedaDeCambio = "BRL";
                    monedaACambiar = "USD";
                    break;
                case 5:
                    monedaDeCambio = "USD";
                    monedaACambiar = "COP";
                    break;
                case 6:
                    monedaDeCambio = "COP";
                    monedaACambiar = "USD";
                    break;
                case 7:
                    monedaDeCambio = "USD";
                    monedaACambiar = "MXN";
                    break;
                case 8:
                    monedaDeCambio = "MXN";
                    monedaACambiar = "USD";
                    break;
                case 9:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                System.out.println("Opción no válida");
                continue; // Vuelve al inicio del bucle
            }
            if(opcionDeConversion != 9) {
                System.out.println("Ingrese la cantidad a convertir:");
                cantidad = input.nextInt();
            }
            else{
                break;
            }

            try {
                var direccion = "https://api.fastforex.io/convert?api_key=8a4c8cfa1f-6a2b6d9b2a-schi30&convert?from=" + monedaDeCambio + "&to=" + monedaACambiar + "&amount=" + cantidad;
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(direccion);
                String json = response.body();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(json);
                MonedaAPI monedaApi = gson.fromJson(json, MonedaAPI.class);

                Monedas moneda = new Monedas(monedaApi);


                System.out.println("el valor de " + cantidad + " [" + monedaDeCambio +  "] corresponde al valor final de =>>> " + monedaApi.result().get(monedaACambiar));

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
