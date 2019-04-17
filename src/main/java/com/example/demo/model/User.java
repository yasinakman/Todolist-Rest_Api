package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String eMail;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Event> events;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", events=" + events +
                '}';
    }
}
