package com.alura.challenge.albert.conversor;

import com.alura.challenge.albert.conversor.enumeration.EDivisas;
import com.alura.challenge.albert.conversor.http.UrlApi;
import com.alura.challenge.albert.conversor.modelo.Conversion;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
            throws IOException, InterruptedException {

        String salida;
        var apiKey = "14b36e2bd68cca67972876fe";
        Conversion conversion;

        do {
            System.out.println("\n********************************");
            System.out.println("SISTEMA DE CONVERSION DE MONEDAS");
            System.out.println("********************************\n");

            var divisaUno = menuMonedas("Digita el numero de la moneda origen.");

            var divisaDos = menuMonedas("\nDigita el numero de la moneda destino.", divisaUno);

            System.out.print("\nEscriba el monto que desea cambiar: ");
            var monto = reader.nextDouble();

            var url = new UrlApi();

            conversion = url.invocarServicioConversion(apiKey, divisaUno, divisaDos, monto);

            System.out.println(monto + " " + divisaUno.getNombre() + " equivalen a: " + conversion.getResultadoConversion()
                    + " " + divisaDos.getNombre());
            System.out.println("Para el día " + conversion.getFechaDeConsulta() + " con una tasa de conversion de: "
                    + conversion.getTasaDeConversion());

            System.out.println("¿Desea seguir s/n?");
            System.out.print("> ");
            salida = reader.next();

        } while (salida.equalsIgnoreCase("s"));

    }

    private static EDivisas menuMonedas(String titulo) {
        return menuMonedas(titulo, null);
    }

    private static EDivisas menuMonedas(String titulo, EDivisas monedaEscogida) {
        int opcionEscogida;

        System.out.println(titulo);

        for (EDivisas divisas : EDivisas.values()) {
            if (divisas != monedaEscogida) {
                System.out.println(divisas.getIdentificador() + ". " + divisas.getNombre());
            }
        }

        System.out.print("> ");

        opcionEscogida = reader.nextInt();

        return EDivisas.getDivisa(opcionEscogida);
    }

}
