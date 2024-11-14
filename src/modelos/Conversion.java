package modelos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversion {
    public static double getConversion(String baseCode, String targetCode, double cantidad) throws Exception {
        String token = "0b14289b1ee8a86dc48c7ff0";
        HttpClient cliente = HttpClient.newHttpClient();
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%f", token, baseCode, targetCode, cantidad);
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = response.body();
            ApiConversion bodyApi = gson.fromJson(json, ApiConversion.class);
            if(response.statusCode() != 200){
                throw new Exception(bodyApi.errorType());
            }
            return bodyApi.conversion_result();
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
