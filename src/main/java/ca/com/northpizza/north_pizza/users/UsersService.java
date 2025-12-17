package ca.com.northpizza.north_pizza.users;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //Delivery the information provided from repository
public class UsersService implements UserDetailsService{
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usersRepository.findByLogin(login);
    }

    public UsersDTO createUser(UsersDTO usersDTO){
        Users users = modelMapper.map(usersDTO, Users.class);
        usersRepository.save(users);
        return modelMapper.map(users, UsersDTO.class);
    }


}
