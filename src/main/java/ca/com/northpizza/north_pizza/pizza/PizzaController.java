package ca.com.northpizza.north_pizza.pizza;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

//Determining that this class is a controller
@RestController
//Path/Mapping/endpoint of this controller
@RequestMapping("/pizzas")
public class PizzaController {
    //Injecting the dependency
    private final PizzaService pizzaService;

    //client --> controller --> Service
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    //controller --> Service
    //PizzaDTO information received from the client
    @PostMapping
    public ResponseEntity<PizzaDTO> register(@RequestBody @Valid PizzaDTO pizzaDTO, UriComponentsBuilder uriComponentsBuilder){
       PizzaDTO pizzaDTORegister = pizzaService.createPizza(pizzaDTO);
       //Build the uri path to return
       URI path = uriComponentsBuilder.path("/pizzas/{id}").buildAndExpand(pizzaDTORegister.getId()).toUri();
       return ResponseEntity.created(path).body(pizzaDTORegister);
    }

    @GetMapping
    //Reduce the return of the list of items
    public ResponseEntity<Page<PizzaDTO>> findAllPizza(@PageableDefault (size = 10) Pageable pageable){
        Page<PizzaDTO> pizzaDTOFindAll = pizzaService.findAllService(pageable);
        return ResponseEntity.ok(pizzaDTOFindAll);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDTO> findByIdPizza(@PathVariable Long id){
        PizzaDTO pizzaDTOFind = pizzaService.findByIdService(id);
        return ResponseEntity.ok(pizzaDTOFind);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDTO> updatePizza(@PathVariable Long id, @RequestBody @Valid PizzaDTO pizzaDTO){
        PizzaDTO pizzaDTOUpdated = pizzaService.updatePizza(id, pizzaDTO);
        return ResponseEntity.ok(pizzaDTOUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id){
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }

}
