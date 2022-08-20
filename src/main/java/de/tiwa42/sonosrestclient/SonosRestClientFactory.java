package de.tiwa42.sonosrestclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SonosRestClientFactory {
    private final AuthCredentials authCredentials;

    public SonosRestClient getSonosRestClient(String credentials) {
        return new SonosRestClientImpl();
    }

    public SonosRestClientFactory(String clientId, String redirectUri, String state, String clientSecret) {
        authCredentials = new AuthCredentials(clientId, redirectUri, state, clientSecret);
    }

    public String authorizeClient() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(authCredentials.getLoginUrl()))
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
