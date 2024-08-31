package org.example.zuulserveoredgeservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class GatewayFilter implements GlobalFilter, Ordered {
    private static final Logger log = LoggerFactory.getLogger(GatewayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String method = String.valueOf(exchange.getRequest().getMethod());
        String requestURL = exchange.getRequest().getURI().toString();

        String headerAuth = exchange.getRequest().getHeaders().getFirst("Authorization");

        if(headerAuth == null || headerAuth.isEmpty()) {
            return null;
        }

        // Log the method and request URL
        log.info(String.format("%s request to %s", method, requestURL));

        // Continue the filter chain
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
