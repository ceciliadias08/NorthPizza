package ca.com.northpizza.north_pizza.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //To say to spring that it's an entity
@Table(name = "Users") //Name of the table on the database
@Data //Gets, setters, toString, hashEqualsAndCodes
@AllArgsConstructor //With the parameters
@NoArgsConstructor //No parameters
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Id made by the database
    private Long id;
    private String login;
    private String password;

}
