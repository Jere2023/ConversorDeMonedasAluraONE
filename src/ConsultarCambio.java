import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarCambio {
    public Consulta consultar(String monedaOrigen, String monedaDestino, double cantidad) throws IOException, InterruptedException {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/146e6a7a86c2e1a8e2a42f9c/pair/"+
                monedaOrigen + "/" + monedaDestino + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), Consulta.class);
    }

}
