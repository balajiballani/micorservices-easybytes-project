package com.eazybytes.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import java.time.Duration;

@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }
    /*This is customization of routes as displayed in the filter below*/

    @Bean
    public RouteLocator eazyBankLoanRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route(
                        p -> p.path("/eazybank/loans/**").filters(f -> f.rewritePath(
                                "/eazybank/loans/(?<segment>.*)", "/${segment}"

                        ).retry(retryConfig -> retryConfig.setMethods(HttpMethod.GET).setRetries(3)
                                .setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000), 2, true))).uri("lb://LOANS")
                )
                .route(
                        p -> p.path("/eazybank/cards/**").filters(f -> f.rewritePath(
                                "/eazybank/cards/(?<segment>.*)", "/${segment}"
                        )).uri("lb://CARDS"))
                .route(
                        p -> p.path("/eazybank/accounts/**").filters(f -> f.rewritePath(
                                "/eazybank/accounts/(?<segment>.*)", "/${segment}"
                        ).circuitBreaker(config -> config.setName("accountsCircuitBreaker").setFallbackUri("forward:/contactSupport"))).uri("lb://ACCOUNTS")
                ).build();
    }

}
