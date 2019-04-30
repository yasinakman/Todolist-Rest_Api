package com.example.demo.Controller;

import com.example.demo.Repository.ListDAO;
import com.example.demo.model.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ListController {
    @Autowired
    ListDAO todoListDao;
    @Autowired
    ItemController itemCtl;

    @PostMapping("/addTodoList")
    public TodoList addTodoList(TodoList todoList) {
        if(!"".equals(todoList.getListName())) {
            todoListDao.save(todoList);
            return todoList;
        }
        throw new IllegalStateException();
    }

    @DeleteMapping("/deleteTodoList/{listId}")
    public String deleteTodoListById(@PathVariable int listId) {
        itemCtl.deleteAllItemsByListId(listId);
        todoListDao.deleteById(listId);
        return "deleted " + listId;
    }

    @RequestMapping("/getTodoListById")
    public TodoList getTodoListById(@RequestParam int listId) {
        TodoList l = todoListDao.findById(listId).orElse(null);

        if(l!=null) {
            return l;
        }else {
            //return "no list found with id " + listId;
            throw new IllegalStateException("no list found with provided id: " + listId);
        }
    }

    @RequestMapping("/getTodoListAll")
    public List<TodoList> getTodoListAll() {
        return (List<TodoList>) todoListDao.findAll();

    }
}
