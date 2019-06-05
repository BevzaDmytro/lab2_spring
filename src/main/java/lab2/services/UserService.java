package lab2.services;

import lab2.entities.User;
import lab2.entities.UsersOnline;
import lab2.repos.UserRepository;
import lab2.repos.UsersOnlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersOnlineRepository usersOnlineRepository;

    public User addUser(User user){
        User savedUser = userRepository.saveAndFlush(user);
        return savedUser;
    }

    public void createUser() {
        User user = new User("Dima", "1234");
        userRepository.saveAndFlush(user);
    }

    public Optional<User> getUser(int userId) {
        return userRepository.findById(userId);
    }

    public void updateName(){

    }

    public String loginUser(String email, String pw) {
        User user = userRepository.getUserByEmailAndPassword(email, pw);
        String token =  null;
        if(user != null) {
             token  = this.generateAuthToken();
            usersOnlineRepository.saveAndFlush(new UsersOnline(token, user.getId()));
        }
        return "{ \"token\" : \""+token+"\"}";
    }

    private String generateAuthToken() {
        String symbols = "qwertyasdhfgsdg";
        StringBuilder randString = new StringBuilder();
        int count = 10;
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return String.valueOf(randString);
    }

    public int getUserOnline(String token){
        UsersOnline online = usersOnlineRepository.findByUserId(token);
        return online.getUserId();
    }

    public boolean isUserAdmin(String token) {
        int userId =  this.getUserOnline(token);
        User user = null;
        Optional<User> optionalUser;
        optionalUser = this.getUser(userId);
        if(optionalUser.isPresent()) {
             user = optionalUser.get();
        }
        if(user != null)
         return user.isAdmin();
        else return false;
    }

    public boolean isUserLoggedIn(String token) {
        int userId = -1;
         userId =  this.getUserOnline(token);
         return userId != -1;
    }
}
