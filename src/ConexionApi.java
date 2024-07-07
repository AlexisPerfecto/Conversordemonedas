import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {


    private HttpClient httpClient;

    public ConexionApi() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getApiResponse(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String apiResponse = response.body();
        return apiResponse;

    }
}
