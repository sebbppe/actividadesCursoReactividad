package org.example.repository;

import org.example.repository.model.ToDo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToDoRepository extends ReactiveMongoRepository<ToDo, String> {

}
