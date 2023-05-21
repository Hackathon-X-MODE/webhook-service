package com.example.example.service;

import com.example.example.client.ProxyClient;
import com.example.example.model.WebHookPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebHookService {

    private final ProxyClient proxyClient;


    public void accept(List<WebHookPayload> payloads) {
        payloads.forEach(payload -> {
            log.info("send to {}", payload.getUrl());
            this.proxyClient.proxy(payload.getUrl(), payload);
        });
    }
}
