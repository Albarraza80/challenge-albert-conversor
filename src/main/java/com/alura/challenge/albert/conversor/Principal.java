package com.alura.challenge.albert.conversor;

import com.alura.challenge.albert.conversor.enumeration.EDivisas;
import com.alura.challenge.albert.conversor.http.UrlApi;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    private static final Scanner reader = new Scanner( System.in );
    
    public static void main( String[] args )
        throws IOException, InterruptedException {
        var apiKey = "14b36e2bd68cca67972876fe";

        var monedaUno = menuMonedas( "Digita el numero de la moneda origen.");

        var monedaDos = menuMonedas( "Digita el numero de la moneda destino.", monedaUno );

        System.out.println( "Escriba el monto que desea cambiar: " );
        var monto = reader.nextDouble();

        var url = new UrlApi();

        var respuesta = url.invocarServicioConversion( apiKey, monedaUno, monedaDos, monto );

        System.out.println( respuesta );
    }

    private static EDivisas menuMonedas( String titulo ) {
        return menuMonedas(titulo, null);
    }

    private static EDivisas menuMonedas( String titulo, EDivisas monedaEscogida) {
        int opcionEscogida;

        System.out.println( titulo );

        for( EDivisas divisas : EDivisas.values() ) {
            if( divisas != monedaEscogida ) {
                System.out.println(divisas.getIdentificador() + ". " + divisas.getNombre());
            }
        }

        opcionEscogida = reader.nextInt();

        return EDivisas.getDivisa( opcionEscogida );
    }
}
