package lab2.controllers;

import lab2.services.UserService;
import lab2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    UserService userService;

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    void add(){
        userService.createUser();
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Optional<User> get(){
        return userService.getUser();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    void update(){

    }

    @RequestMapping(value = "/updateAll", method = RequestMethod.PUT)
    void updateUser(){

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    void delete(){

    }


}
