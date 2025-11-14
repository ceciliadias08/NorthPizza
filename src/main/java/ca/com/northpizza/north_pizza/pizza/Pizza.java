package ca.com.northpizza.north_pizza.pizza;

import jakarta.persistence.*;
import lombok.*;

//Lombok use
@Entity //Communicate to database what is an entity through JPA
@Table(name = "Pizza") //Table's name
@Data //Getter, Setter, toString, EqualstoHashCode only in once
@AllArgsConstructor //Creates the constructor with all arguments
@NoArgsConstructor //Constructor with no arguments
public class Pizza {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Creation register flow to database
    private long id;
    private String name;
    @Enumerated (EnumType.STRING) //Informing JPA about the enum existence
    private Flavour flavour;
    private double price;
    @Enumerated (EnumType.STRING)
    private Size sizes;
    private boolean availability;
    @Enumerated (EnumType.STRING)
    private Category category;

}
