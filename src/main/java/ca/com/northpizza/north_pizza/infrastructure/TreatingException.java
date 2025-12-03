package ca.com.northpizza.north_pizza.infrastructure;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TreatingException {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> treatException(){
        return ResponseEntity.notFound().build();
    }
}
