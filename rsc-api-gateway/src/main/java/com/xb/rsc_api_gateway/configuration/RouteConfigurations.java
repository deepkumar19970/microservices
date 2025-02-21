package com.xb.rsc_api_gateway.configuration;

import com.xb.rsc_api_gateway.security.AuthorizationHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfigurations {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder ,AuthorizationHeaderGatewayFilterFactory authFilter ) {
        return builder.routes().route("RSC-INFO", e -> e.path("/rsc-info/*"
                )/*.filters(f -> f.filter(authFilter.apply(new AuthorizationHeaderGatewayFilterFactory.Config())))*/
                        .uri("http://localhost:8081"))
                .route("RSC-ADDRESS", e -> e.path("/rsc-address/*"
                )/*.filters(f -> f.filter(authFilter.apply(new AuthorizationHeaderGatewayFilterFactory.Config())))*/
                .uri("http://localhost:8082"))
                .build();
    }
}
