package ca.com.northpizza.north_pizza.pizza;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Determining that this class is a controller
@RestController
//Path/Mapping/endpoint of this controller
@RequestMapping(name = "/pizzas")
public class PizzaController {
    //Injecting the dependecy
    private final PizzaService pizzaService;

    //client --> controller --> Service
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    //controller --> Service
    //PizzaDTO information received from the client
    public void register(PizzaDTO pizzaDTO){
        pizzaService.createPizza(pizzaDTO);
    }
}
