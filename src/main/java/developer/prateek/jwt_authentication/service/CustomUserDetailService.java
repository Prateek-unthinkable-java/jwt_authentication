package developer.prateek.jwt_authentication.service;

import developer.prateek.jwt_authentication.entity.User;
import developer.prateek.jwt_authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if (userRepository.userExitsWithName(username)) {
//            System.out.println("User : "+userRepository.getUserByName(username));
//            return (UserDetails) userRepository.getUserByName(username);
//        } else {
//            throw new UsernameNotFoundException("User not found !!");
//        }
        if (userRepository.existsByUsername(username)) {
            return (UserDetails) userRepository.getUserByName(username);
        } else {
            throw new UsernameNotFoundException("User not found !!");
        }
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
