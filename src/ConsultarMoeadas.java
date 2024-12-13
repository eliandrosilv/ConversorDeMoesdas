import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultarMoeadas {
    //  https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP
    private String apiConversao = "https://v6.exchangerate-api.com/v6/1c65c9a3fc6425cd5d67e330/pair";

    public ConversionRate getConversionRate(String fromCurrency, String toCurrency) throws Exception {
        String apiUrl = apiConversao + "/" + fromCurrency + "/" + toCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição: Código " + response.statusCode());
        }

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        double rate = jsonObject.get("conversion_rate").getAsDouble();

        return new ConversionRate(fromCurrency, toCurrency, rate);
    }
}
