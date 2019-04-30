package com.example.demo.Controller;

import com.example.demo.Repository.UserDAO;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserDAO userDao;

    @RequestMapping("/addUser")
    public User addUser(User user){
        userDao.save(user);
        return user;
    }
    @RequestMapping("/showUsers")
    public List<User> showUsers(){
        List<User> users = new ArrayList<>();
        userDao.findAll().forEach(users::add);
        System.out.println(users);
        return users;
    }
    @RequestMapping("/showUsers/{userName}")
    public User getUser(@PathVariable String userName){
        User u1 = userDao.findByUserName(userName);
        System.out.println(u1.getUserName());
        return u1;
    }
}
