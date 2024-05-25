package com.alura.challenge.albert.conversor.http;

public class UrlApi {
    String url;

    public String url(String apiKey, String divisaUno, String divisaDos, double monto){

        url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + divisaUno + "/"
                + divisaDos + "/" + monto;
        return url;
    }

}
