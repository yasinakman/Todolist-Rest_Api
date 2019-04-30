package com.example.demo.TestController;

import com.example.demo.Repository.ListDAO;
import com.example.demo.model.TodoItem;
import com.example.demo.model.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
class Initializer implements CommandLineRunner {
    @Autowired
    ListDAO listRepository;


    @Override
    public void run(String... strings) {
        TodoList list = new TodoList();
        list.setListName("yasin");

        listRepository.save(list);

//        TodoList djug = listRepository.findByListName("yasin");
        TodoItem e = new TodoItem();
        e.setItemName("developing");
        e.setDeadline(new Date());
        e.setCreateDate(new Date());
        e.setStatus(true);
        e.setList(1);

        TodoItem ee = new TodoItem();
        ee.setItemName("swimming");
        ee.setDeadline(new Date());
        ee.setCreateDate(new Date());
        ee.setStatus(true);
        ee.setList(1);

        List<TodoItem> items = new ArrayList<>();
        items.add(e);
        items.add(ee);
        list.setItems(items);
        listRepository.save(list);

        //listRepository.findAll().forEach(System.out::println);
    }
}