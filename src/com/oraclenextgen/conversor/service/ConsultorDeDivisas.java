package com.oraclenextgen.conversor.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultorDeDivisas {

    public Divisa obtenerValorActual(String codigoDeMoneda1, String codigoDeMoneda2) throws IOException, InterruptedException {

        System.out.println("Consultando el valor de intercambio actual, un momento");

        String direccionURL = "https://v6.exchangerate-api.com/v6/217f6641f3623a9e6b50f1a8/pair/" + codigoDeMoneda1 + "/" + codigoDeMoneda2;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccionURL))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Conversor conversor = gson.fromJson(json, Conversor.class);

        Divisa divisa = new Divisa(conversor);

        return divisa;
    }
}
