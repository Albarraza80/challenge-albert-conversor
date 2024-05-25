package com.alura.challenge.albert.conversor.http;

import com.alura.challenge.albert.conversor.enumeration.EDivisas;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UrlApi {
    private String url( String apiKey, EDivisas monedaUno, EDivisas monedaDos, double monto ){
        String url;

        url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaUno.getCodigo() + "/"
                + monedaDos.getCodigo() + "/" + monto;

        return url;
    }
    
    public String invocarServicioConversion( String apiKey, EDivisas monedaUno, EDivisas monedaDos,
                                             double monto )
        throws IOException, InterruptedException {
        HttpClient client;
        
        HttpRequest solicitud;
        
        HttpResponse<String> respuesta;
        
        String direccion;
        
        direccion = url( apiKey, monedaUno, monedaDos, monto );

        client = HttpClient.newHttpClient();

        solicitud = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        respuesta = client.send( solicitud, HttpResponse.BodyHandlers.ofString() );
        
        return respuesta.body();
    }

}
