package ca.com.northpizza.north_pizza.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository //Gets the information to service to delivery it
public interface UsersRepository extends JpaRepository<Users, Long> {
    UserDetails findByLogin(String login); //abstract method, doesn't have execution
}
