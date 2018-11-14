package com.example.demo.Repository;

import com.example.demo.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event,Long> {
}
