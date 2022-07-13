package developer.prateek.jwt_authentication.controller;

import developer.prateek.jwt_authentication.entity.User;
import developer.prateek.jwt_authentication.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @GetMapping("/welcome")
    public String welcome() {
        String text = "This is a welcome page, and can't be accessed by any un-authenticated user.";
        return text;
    }

    @GetMapping("/loadUserByUsername")
    public UserDetails loadUserByUsername(@RequestParam String userName) {
        return customUserDetailService.loadUserByUsername(userName);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        System.out.println("User : "+user.toString());
        return customUserDetailService.addUser(user);
    }
}
