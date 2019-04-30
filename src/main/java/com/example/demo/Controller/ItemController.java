package com.example.demo.Controller;

import com.example.demo.Repository.ItemDAO;
import com.example.demo.model.TodoItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class ItemController {
    @Autowired
    ItemDAO itemDao;

    @PostMapping("/addItem")
    public TodoItem addItem(TodoItem item) throws IllegalStateException {
        if (item != null) {
            if (item.getItemName() != null && !item.getItemName().isEmpty()) {
                if (item.getList() != 0) {
                    item.setCreateDate(new Date());
                    System.out.println(item.getDeadline());
                    itemDao.save(item);
                    return item;
                }
            }
        }
        // return "itemName and/or list are not provided";
        throw new IllegalStateException("itemName and/or list are not provided");
    }

    @PutMapping("/changeItemStatusById/{itemId}")
    public TodoItem changeItemStatusById(@PathVariable int itemId) throws IllegalStateException {

        TodoItem it = itemDao.findById(itemId).orElse(null);
        if (it != null) {
            if (it.isStatus()) {
                it.setStatus(false);
            } else {
                it.setStatus(true);
            }
            itemDao.save(it);
            return it;
        } else {
            throw new IllegalStateException("no item found with id " + itemId);
        }
    }

    @DeleteMapping("/deleteItemById/{itemId}")
    public String deleteItemById(@PathVariable int itemId) {
        itemDao.deleteById(itemId);
        return "deleted " + itemId;
    }

    @DeleteMapping("/deleteAllItemsByListId/{listId}")
    public String deleteAllItemsByListId(@PathVariable int listId) {
        Iterable<TodoItem> todoItems = itemDao.findAllByList(listId);
        for (TodoItem it : todoItems) {
            this.deleteItemById(it.getItemId());
        }
        itemDao.deleteAll(todoItems);
        return "deleted all items of listId: " + listId;
    }

    @RequestMapping("/getAllItemsByListId/{listId}")
    public List<TodoItem> getAllItemsByListId(@PathVariable int listId) {
        Iterable<TodoItem> todoItems = itemDao.findAllByList(listId);

        return (List<TodoItem>) todoItems;
    }

    @RequestMapping("/getItemById")
    public TodoItem getItemById(@RequestParam int itemId) throws JsonProcessingException {
        TodoItem it = itemDao.findById(itemId).orElse(null);
        if (it != null) {
            return it;
        } else {
            throw new IllegalStateException("no item found with id " + itemId);
        }
    }

    @RequestMapping("/getAllItems")
    public List<TodoItem> getAllItems() {
        return (List<TodoItem>) itemDao.findAll();
    }
}