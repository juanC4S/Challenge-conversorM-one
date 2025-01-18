import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarConversor {
    public Conversor buscaDivisa(String base, String target, double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/2ae5bc2ac9061975ad3e0bd5/pair/"+base+"/"+target+"/"+cantidad);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }


}
