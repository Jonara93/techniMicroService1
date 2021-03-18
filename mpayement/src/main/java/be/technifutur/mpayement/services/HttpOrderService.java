package be.technifutur.mpayement.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@Service
public class HttpOrderService {

    public void paidOrderRequest(int orderId) throws Exception {
        // {{ }} --> permet de faire directement les méthodes lié à l'objet (ici hashmap)
        var values = new HashMap<String, Integer>() {{
            put("orderId", orderId);
        }};

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);

//        Pour voir comment est transformer la HashMap en json
//        System.out.println(requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9001/orders/paid"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
    }
}
