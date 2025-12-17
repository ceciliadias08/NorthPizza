package ca.com.northpizza.north_pizza.users;

import jakarta.validation.constraints.NotBlank;

//It's the conversion itself and model mapping is the "translator"
//Entity --> database
//DTO --> client/consumer
public class UsersDTO {
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
