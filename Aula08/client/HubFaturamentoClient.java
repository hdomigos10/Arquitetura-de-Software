package client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HubFaturamentoClient {
    private final String baseUrl;
    private final HttpClient httpClient;

    public HubFaturamentoClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
    }

    public Long enviarPedidoParaFaturamento(Long pedidoId) {
        try {
            String jsonBody = "{\"pedidoId\": " + pedidoId + "}";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/api/faturas"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return Long.parseLong(response.body().trim());
            }
            throw new RuntimeException("Erro na comunicação com o Hub. Status: " + response.statusCode());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao integrar pedido com o Hub de Faturamento: " + e.getMessage(), e);
        }
    }
}
