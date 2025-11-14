package ca.com.northpizza.north_pizza.pizza;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PizzaDTO> findAllService() {
        //Return the pizza list
        return pizzaRepository.findAll().stream().map(pizza -> modelMapper.map(pizza, PizzaDTO.class))
                .collect(Collectors.toList());
    }

    public PizzaDTO findByIdService(Long id){
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(pizza, PizzaDTO.class);
    }
}
