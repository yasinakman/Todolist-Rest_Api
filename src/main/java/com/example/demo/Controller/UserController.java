package com.example.demo.Controller;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Event;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepo;

    @RequestMapping("/addUser")
    public User addUser(User user){
        userRepo.save(user);
        return user;
    }
    @RequestMapping("/showUsers")
    public List<User> showUsers(){
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        System.out.println(users);
        return users;
    }
}
