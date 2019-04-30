package com.example.demo.Repository;

import com.example.demo.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventDAO extends CrudRepository<Event,Long> {
}
