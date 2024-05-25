package com.alura.challenge.albert.conversor;

import com.alura.challenge.albert.conversor.divisa.AsignarDivisa;
import com.alura.challenge.albert.conversor.http.UrlApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        String divisaUno;
        String divisaDos;
        String direccion;
        int monedaEscogidaUno;
        int monedaEscogidaDos;
        double monto;
        String apiKey = "14b36e2bd68cca67972876fe";

        Scanner reader = new Scanner(System.in);

        System.out.println("¿Digta el número de la moneda desea cambiar?: ");
        System.out.println("1. Dólares");
        System.out.println("2. Pesos colombianos");
        System.out.println("3. Pesos argentinos");
        System.out.println("4. Real brasilero");
        System.out.println("5. Pesos mexicanos");

        monedaEscogidaUno = reader.nextInt();

        System.out.println("¿A cuál moneda desea cambilarla?");
        System.out.println("1. Dólares");
        System.out.println("2. Pesos colombianos");
        System.out.println("3. Pesos argentinos");
        System.out.println("4. Real brasilero");
        System.out.println("5. Pesos mexicanos");

        monedaEscogidaDos = reader.nextInt();

        System.out.println("Escriba el monto que desea cambiar: ");
        monto = reader.nextInt();

        var divisa = new AsignarDivisa();

        divisaUno = divisa.sigla(monedaEscogidaUno);
        divisaDos = divisa.sigla(monedaEscogidaDos);

        var url = new UrlApi();
        direccion = url.url(apiKey, divisaUno, divisaDos, monto);

        System.out.println(direccion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
