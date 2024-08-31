package org.example.zuulserveoredgeservice;

import org.example.zuulserveoredgeservice.filter.GatewayFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ZuulServeOrEdgeServiceApplication {
    private static final Logger log = LoggerFactory.getLogger(GatewayFilter.class);

    public static void main(String[] args) {
        SpringApplication.run(ZuulServeOrEdgeServiceApplication.class, args);
    }

}
