package com.example.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebHookPayload {

    private String url;

    private String orderId;

    private UUID commentId;

    private String comment;

    private String problem;
}
