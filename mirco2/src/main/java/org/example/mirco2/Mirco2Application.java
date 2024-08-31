package org.example.mirco2;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Mirco2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mirco2Application.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @RestController
    class ReadMessageController {

        @Autowired
        private RestTemplate restTemplate;

        @GetMapping("/api/read-message")
        @CircuitBreaker(name = "readMessageCB", fallbackMethod = "getDefaultMessage")
        public String readMessage() {
            return restTemplate.getForObject("http://localhost:9091/api/message", String.class);
        }
    }
    public String getDefaultMessage() {
        return "this is a default message if the service not available";
    }
}
