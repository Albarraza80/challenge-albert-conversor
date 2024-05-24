public class UrlApi {
    String url;

    public String Url(String apiKey, String divisaUno, String divisaDos, double monto){

        url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + divisaUno + "/"
                + divisaDos + "/" + monto;
        return url;
    }

}
