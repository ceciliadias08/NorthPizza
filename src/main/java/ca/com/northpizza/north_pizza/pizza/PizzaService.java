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

}
