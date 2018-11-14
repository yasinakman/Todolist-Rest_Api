package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int listId;
    @Column(nullable = false)
    private String listName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "list", cascade = CascadeType.ALL)
    private List<TodoItem> items;

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<TodoItem> getItems() {
        return items;
    }

    public void setItems(List<TodoItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "listId=" + listId +
                ", listName='" + listName + '\'' +
                ", items=" + items +
                '}';
    }
}
