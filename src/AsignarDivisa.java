public class AsignarDivisa {

    private String divisa;
    public String sigla(int moneda) {

        switch (moneda) {
            case 1:
                divisa = "USD";
                break;
            case 2:
                divisa = "COP";
                break;
            case 3:
                divisa = "ARS";
                break;
            case 4:
                divisa = "BRL";
                break;
            case 5:
                divisa = "MXN";
                break;
        }
        return divisa;
    }
}
