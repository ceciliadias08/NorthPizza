package ca.com.northpizza.north_pizza.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Do a hash in the password
public class EncoderPassword {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encode(String password){
        return encoder.encode(password);
    }
}
