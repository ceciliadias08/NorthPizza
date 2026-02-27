package ca.com.northpizza.north_pizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//Spring boot building owner
@Configuration
@EnableWebSecurity //Team security of this building
public class SecurityConfiguration {
    private final Filter filter;

    public SecurityConfiguration(Filter filter){
        this.filter = filter;
    }

    //Filter
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{ //Verification "door"
        http.csrf(csrf -> csrf.disable()). //Simulates to be the admin
                sessionManagement(session ->session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Security with amnesia
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers( "/v3/api-docs/**").permitAll()
                        .requestMatchers( "/swagger-ui.html").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .anyRequest().authenticated())
                        .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    //Security, authenticating the configurations
    //Create the logic of authentication
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
