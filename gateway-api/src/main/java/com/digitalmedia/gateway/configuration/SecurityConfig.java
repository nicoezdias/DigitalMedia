package com.digitalmedia.gateway.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final ReactiveClientRegistrationRepository reactiveClientRegistrationRepository;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .oauth2Login()
                .and()
                .logout()
                .logoutSuccessHandler(oidcServerLogoutSuccessHandler())
                ;
        return http.build();
    }

    private ServerLogoutSuccessHandler oidcServerLogoutSuccessHandler(){
        OidcClientInitiatedServerLogoutSuccessHandler oidcClientInitiatedLogoutSuccessHandler
                = new OidcClientInitiatedServerLogoutSuccessHandler(reactiveClientRegistrationRepository);
        oidcClientInitiatedLogoutSuccessHandler.setPostLogoutRedirectUri("${app.uri-keycloak-login}");
        return oidcClientInitiatedLogoutSuccessHandler;
    }
}
