package com.example.promotionProduct.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@Configuration
public class ServerInfoConfig {

    @Bean
    public ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String port = env.getProperty("server.port", "8080");
            String host = InetAddress.getLocalHost().getHostAddress();

            System.out.println("=================================");
            System.out.println("🚀 Application started!");
            System.out.println("👉 Local API_1:    http://localhost:" + port + "/api/v1/promotions") ;
            System.out.println("👉 Local API_2:    http://localhost:" + port + "/api/v1/promotions/native") ;
            System.out.println("👉 Network:  http://" + host + ":" + port);
            System.out.println("=================================");
        };
    }
}
