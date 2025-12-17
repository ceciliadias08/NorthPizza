package ca.com.northpizza.north_pizza.users;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

//Informing it's a controller
@RestController
//Informing the adress
@RequestMapping("/users")
public class UsersController {
    //Responsible for the business rule
    private final UsersService usersService;

    //Constructor used to final variable
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping
    //RequestBody is informing that the information is insert at the body
    //Valid is to make sure that notation NotBlank is done
    //UriComponentsBuilder help to build the created entity's metadata
    public ResponseEntity<UsersDTO> register(@RequestBody @Valid UsersDTO usersDTO, UriComponentsBuilder uriComponentsBuilder){
        UsersDTO userDTORegister = usersService.createUser(usersDTO);
        URI path = uriComponentsBuilder.path("/users/{id}").buildAndExpand(userDTORegister.getId()).toUri();
        return ResponseEntity.created(path).body(userDTORegister);
    }

}
