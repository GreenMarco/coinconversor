package com.odisea.coinconversor.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.odisea.coinconversor.modelos.Moneda;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello world!");

        String op = "0";
        Scanner opci = new Scanner(System.in);
        Scanner lectura = new Scanner(System.in);
        Moneda myMoneda = new Moneda();
        double valor;

        System.out.println("\nHola, Bienvenido al conversor de monedas\n");
        while (!op.equals("6")){
            System.out.println("""

                    Primero selecciona una moneda, ingresa su codigo o su opción
                    O si lo prefieres, ingresa 6 o Salir para Salir

                    1 - USD Dolar estadounidense
                    2 - MXN Peso mexicano
                    3 - COP Peso colombiano
                    4 - NIO Córdoba nicaraguense
                    5 - DOP Peso dominicano
                    6 - Salir
                    """);
            op = opci.nextLine();
            switch (op){
                case "1":
                case "USD":
                    myMoneda = consulta("USD");
                    System.out.println(myMoneda);
                    System.out.println("Cuanto quieres cambiar a USD");

                    valor = lectura.nextDouble();
                    calcula(myMoneda, valor);
                    break;
                case "2":
                case "MXN":
                    myMoneda = consulta("MXN");
                    System.out.println(myMoneda);
                    System.out.println("Cuanto quieres cambiar a MXN");
                    valor = lectura.nextDouble();
                    calcula(myMoneda, valor);

                    break;
                case "3":
                case "COP":
                    myMoneda = consulta("COP");
                    System.out.println(myMoneda);
                    System.out.println("Cuanto quieres cambiar a COP");
                    valor = lectura.nextDouble();
                    calcula(myMoneda, valor);
                    break;
                case "4":
                case "NIO":
                    myMoneda = consulta("NIO");
                    System.out.println(myMoneda);
                    System.out.println("Cuanto quieres cambiar a NIO");
                    valor = lectura.nextDouble();
                    calcula(myMoneda, valor);
                    break;
                case "5":
                case "DOP":
                    consulta("DOP");
                    System.out.println(myMoneda);
                    System.out.println("Cuanto quieres cambiar a DOP");
                    valor = lectura.nextDouble();
                    calcula(myMoneda, valor);
                    break;
                case "6":
                case "Salir":
                    System.out.println("Gracias, vuelva pronto c:");
                    break;
                default:
                    System.out.println("Opción NO válida");
                    break;
            }
        }
    }

    public static Moneda consulta(String parametro) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        String direction ="https://v6.exchangerate-api.com/v6/8736629935531fcc85ea7f82/latest/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direction + parametro))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        //Obtengo el JSON de la API
        //System.out.println(response.body());

        return gson.fromJson(json, Moneda.class);
    }

    public static void calcula(Moneda myMoneda, Double valor){
        System.out.println("\nEsto es lo que valen en las distintas monedas: " +
                "\nUSD = " + myMoneda.getConversionRates().getUSD()*valor+
                "\nMXN = " + myMoneda.getConversionRates().getMXN()*valor+
                "\nCOP = " + myMoneda.getConversionRates().getCOP()*valor+
                "\nNIO = " + myMoneda.getConversionRates().getNIO()*valor+
                "\nDOP = " + myMoneda.getConversionRates().getDOP()*valor);
    }
}