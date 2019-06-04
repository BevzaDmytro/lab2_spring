package lab2.controllers;

import lab2.entities.User;
import lab2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/login")
    User login(@RequestParam("email") String email, @RequestParam("password") String pw){
//    User login(){
        User user =  userService.loginUser("qwerty@gmail.com", "12345");
        return user;
    }

    @RequestMapping(value = {"/user", "/"})
    Optional<User> getUser(){
        //TODO: поправити авторизацію
        //TODO: переписати getuser на отримання параметра
        return userService.getUser();
//        return null;
    }

}
