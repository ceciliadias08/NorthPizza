package ca.com.northpizza.north_pizza.config;

import ca.com.northpizza.north_pizza.users.Users;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String createToken(Users users){
        try {
            Algorithm algorithm = Algorithm.HMAC256("1234");
            LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(3);
            return JWT.create()
                    .withIssuer("North Pizza")
                    .withSubject(users.getLogin())
                    .withExpiresAt(expirationDate.toInstant(ZoneOffset.of("-05:00")))
                    .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("Error create token", e);
        }
    }

    public String searchUserFromToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("1234");
            return JWT.require(algorithm)
                    .withIssuer("North Pizza")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch(JWTVerificationException e){
            throw new RuntimeException("Invalid Token");
        }
    }
}
