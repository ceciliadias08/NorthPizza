package ca.com.northpizza.north_pizza.pizza;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//Determining that this class is a controller
@RestController
//Path/Mapping/endpoint of this controller
@RequestMapping("/pizzas")
public class PizzaController {
    //Injecting the dependecy
    private final PizzaService pizzaService;

    //client --> controller --> Service
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    //controller --> Service
    //PizzaDTO information received from the client
    @PostMapping
    public void register(@RequestBody PizzaDTO pizzaDTO){
        pizzaService.createPizza(pizzaDTO);
    }

    @GetMapping
    public List<PizzaDTO> findAllController(){
        return pizzaService.findAllService();
    }
}
