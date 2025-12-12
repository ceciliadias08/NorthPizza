package ca.com.northpizza.north_pizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//Spring boot building owner
@Configuration
@EnableWebSecurity //Team security of this building
public class SecurityConfiguration {
    //Filter
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{ //Verification "door"
        http.csrf(csrf -> csrf.disable()). //Simulates to be the admin
                sessionManagement(session ->session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //Security with amnesia
        return http.build();
    }

    //Security, authenticating the configurations
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
