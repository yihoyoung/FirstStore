package service;

import domain.User;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email){
        User user = userRepository.findbyEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("The requested user is not found.");
        }
        return new LoginUserDetails(user);
    }

    public User save(String email, String password, String username){
        User newUser = null;
        User user = userRepository.findbyEmail(email);
        if(user == null){
            newUser = new User(email, new BCryptPasswordEncoder().encode(password), username);
            newUser = userRepository.save(newUser);
        }else{
            throw new ServiceException("The user is exist.");
        }
        return newUser;
    }
}
