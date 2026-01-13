package ca.com.northpizza.north_pizza.users;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
//Sending requisition
public class LoginController {

    //Dependency injection, to utilize methods from other classes
    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }


    @PostMapping
    public ResponseEntity<Void> validationUser(@RequestBody @Valid CredentialUserDTO credentialUserDTO){
        //Generating token based on user's login and password
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(credentialUserDTO.getLogin(), credentialUserDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
