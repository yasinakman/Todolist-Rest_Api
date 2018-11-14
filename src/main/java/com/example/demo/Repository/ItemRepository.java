package com.example.demo.Repository;

import com.example.demo.model.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<TodoItem,Integer> {
    Iterable<TodoItem> findAllByList(int todoList);}
