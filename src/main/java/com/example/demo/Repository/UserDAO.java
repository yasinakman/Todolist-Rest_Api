package com.example.demo.Repository;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User,Long> {
    User findByUserName(String userName);
}
