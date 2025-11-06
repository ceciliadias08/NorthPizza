package ca.com.northpizza.north_pizza.pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Do persistency of data on the databases
public interface PizzaRepository extends JpaRepository<Pizza,Long> {

}
