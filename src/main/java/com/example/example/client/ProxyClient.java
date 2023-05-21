package com.example.example.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class ProxyClient {

    private final WebClient webClient;

    public ProxyClient() {
        this.webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


    public void proxy(String url, Object body) {
        try {
            this.webClient.post().uri(url).bodyValue(body).retrieve().toBodilessEntity().block();
        } catch (Exception e) {
            log.error("Can't send request {}", url, e);
        }
    }
}
