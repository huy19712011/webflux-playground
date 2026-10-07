package org.example.webfluxplayground.sec05.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

@Order(1)
@Service
public class AuthenticationWebFilter implements WebFilter {

    // for example - using low level - not official at this moment
    private final FilterErrorHandler errorHandler;
    public AuthenticationWebFilter(FilterErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    private static final Map<String, Category> TOKEN_CATEGORY_MAP = Map.of(
            "secret123", Category.STANDARD,
            "secret456", Category.PRIME
    );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        var token = exchange.getRequest().getHeaders().getFirst("auth-token");

        if(Objects.nonNull(token) && TOKEN_CATEGORY_MAP.containsKey(token)){
            exchange.getAttributes().put("category", TOKEN_CATEGORY_MAP.get(token));
            return chain.filter(exchange);
        }

        //return Mono.fromRunnable(() -> exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED));

        // for example - using low level - not official at this moment
        // test on Postman: remove header (auth-token --- secret123) => detail = Set the valid token
        return errorHandler.sendProblemDetail(exchange, HttpStatus.UNAUTHORIZED, "Set the valid token");
    }
}
