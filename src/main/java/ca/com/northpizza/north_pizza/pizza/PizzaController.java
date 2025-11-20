package ca.com.northpizza.north_pizza.pizza;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    public void register(@RequestBody @Valid PizzaDTO pizzaDTO){
        pizzaService.createPizza(pizzaDTO);
    }

    @GetMapping
    //Reduce the return of the list of items
    public Page<PizzaDTO> findAllPizza(@PageableDefault (size = 10) Pageable pageable){
        return pizzaService.findAllService(pageable);
    }

    @GetMapping("/{id}")
    public PizzaDTO findByIdPizza(@PathVariable Long id){
        return pizzaService.findByIdService(id);
    }

    @PutMapping("/{id}")
    public PizzaDTO updatePizza(@PathVariable Long id, @RequestBody @Valid PizzaDTO pizzaDTO){
        // PizzaDTO pizzaDTOUpdated = pizzaService.updatePizza(id, pizzaDTO);
        // return pizzaDTOUpdated
        return pizzaService.updatePizza(id, pizzaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id){
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }

}
