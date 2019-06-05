package lab2.controllers;

import lab2.entities.User;
import lab2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    String  login(@RequestParam("email") String email, @RequestParam("password") String pw){
        return userService.loginUser(email, pw);
    }

    @RequestMapping(value = {"/user", "/"}, method = RequestMethod.GET)
    Optional<User> getUser(@RequestHeader("Authorization") String token){

        int userId =  userService.getUserOnline(token);
        return userService.getUser(userId);
//        return null;
    }


}
