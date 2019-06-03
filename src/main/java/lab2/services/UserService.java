package lab2.services;

import lab2.entities.User;
import lab2.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        User savedUser = userRepository.saveAndFlush(user);
        return savedUser;
    }

    public void createUser() {
        User user = new User("Dima", "1234");
        userRepository.saveAndFlush(user);
    }

    public Optional<User> getUser() {
        return userRepository.findById(1);
    }

    public void updateName(){

    }

    public User loginUser(String email, String pw) {
        return userRepository.getUserByEmailAndPassword(email, pw);
    }
}
