package ca.com.northpizza.north_pizza.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Configurations {
    @Bean //Model mapper identification
    //Model = entities
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}