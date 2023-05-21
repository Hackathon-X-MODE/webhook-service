package com.example.example.controller;

import com.example.example.model.WebHookPayload;
import com.example.example.service.WebHookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AmqpController {

    private final WebHookService webHookService;

    @RabbitListener(queues = "webhook", concurrency = "2")
    public void processComment(final List<WebHookPayload> webHookPayloads) {
        log.info("Accepted webhook {}", webHookPayloads.size());
        this.webHookService.accept(webHookPayloads);
        log.info("Webhook submitted");
    }

}
