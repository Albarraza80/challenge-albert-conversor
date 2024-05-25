package com.alura.challenge.albert.conversor.enumeration;

/**
 *
 * @author RobertAntonio
 */
public enum EDivisas {
    DOLAR( 1, "USD", "Dolares estadounidenses" ),
    EURO( 2, "EUR", "Euros" ),
    COLOMBIA_PESOS( 3, "COP", "Pesos colombianos" ),
    ARGENTINA_PESOS( 4, "ARS", "Pesos argentinos" ),
    MEXICO_PESOS( 5, "MXN", "Pesos mexicanos" ),
    BRASIL_REAL( 6, "BRL", "Reales brasileros" ),
    BOLIVAR_SOBERANO( 7, "VES", "Bolivar soberano venezolano" );

    private final int identificador;
    private final String codigo;
    private final String nombre;

    private EDivisas( int identificador, String codigo, String nombre ) {
        this.identificador = identificador;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public static EDivisas getDivisa( int identificador ) {
        for( EDivisas divisa : EDivisas.values() ) {
            if( divisa.getIdentificador() == identificador ) {
                return divisa;
            }
        }

        return null;
    }
}
