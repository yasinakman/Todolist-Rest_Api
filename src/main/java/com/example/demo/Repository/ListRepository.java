package com.example.demo.Repository;


import com.example.demo.model.TodoList;
import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<TodoList,Integer> {
    TodoList findByListName(String listName);
}
