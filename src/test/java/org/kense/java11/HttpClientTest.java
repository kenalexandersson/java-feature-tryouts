package org.kense.java11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

class HttpClientTest {

    @Test
    @DisplayName("should execute an asynchronous request")
    void async() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.isitfridayalready.com/"))
                .build();

        Consumer<String> stringConsumer = body -> assertThat(body)
                .contains("Is it Friday already?");

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(stringConsumer)
                .join();


    }

    @Test
    @DisplayName("should execute a synchronous request")
    void sync() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.isitfridayalready.com/"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertThat(response.statusCode())
                .isEqualTo(200);

        assertThat(response.body())
                .contains("Is it Friday already?");
    }
}
