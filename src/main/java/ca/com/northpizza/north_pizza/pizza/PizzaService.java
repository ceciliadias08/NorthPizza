package ca.com.northpizza.north_pizza.pizza;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final ModelMapper modelMapper;

    public PizzaService(PizzaRepository pizzaRepository, ModelMapper modelMapper){
        this.pizzaRepository = pizzaRepository;
        this.modelMapper = modelMapper;
    }

    //Received pizzaDTO coming from client --> controller --> service
    public PizzaDTO createPizza(PizzaDTO pizzaDTO){
        //Convert the information from DTO to class Pizza
        //Saving the entity of pizza inside the variable pizza with the conversion of DTO to pizza class
        Pizza pizza = modelMapper.map(pizzaDTO, Pizza.class);
        //Passing the information of variable to repository
        pizzaRepository.save(pizza);
        return modelMapper.map(pizza, PizzaDTO.class);
    }

}
