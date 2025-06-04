package com.cesar.school.sensetrack.yuricsg.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApiKeyGenerator {

    private String apiKey;

    @PostConstruct
    public void init() {
        this.apiKey = UUID.randomUUID().toString();
        System.out.println("\n=============================");
        System.out.println("✅ API Key gerada: " + apiKey);
        System.out.println("🔐 Use o header: X-API-KEY");
        System.out.println("=============================\n");
    }

    public String getApiKey() {
        return apiKey;
    }
}
