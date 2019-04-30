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
        System.out.println(userDao.findByUserName(user.getUserName())+"	added");
        return user;
    }
    @RequestMapping("/showUsers")
    public List<User> showUsers(){
    	List<User> users = new ArrayList<>();
        userDao.findAll().forEach(users::add);
        System.out.println(users);
        return users;
    }
    @RequestMapping("/showUser/{userName}")
    public User getUser(@PathVariable String userName){
        User user = userDao.findByUserName(userName);
        System.out.println(user);
        return user;
    }
    @RequestMapping("/deleteUsers")
    public List<User> delAndShowUsers(){
    	List<User> users = new ArrayList<>();
    	System.out.println(users+"	deleted");
    	userDao.deleteAll();
    	userDao.findAll().forEach(users::add);
    	return users;
    }
}
