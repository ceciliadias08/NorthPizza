package ca.com.northpizza.north_pizza.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class Filter extends OncePerRequestFilter {
    private final TokenService tokenService;

    public Filter(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = searchToken(request);
        if(token != null) {
            tokenService.searchUserFromToken(token);
        }
        filterChain.doFilter(request, response);
    }

    private String searchToken(HttpServletRequest request){
        var authorization = request.getHeader("Authorization");
        if(authorization != null){
            return authorization.replace("Bearer ","");
        }
        return null;
    }
}
