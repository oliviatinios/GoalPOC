package net.chrisrichardson.eventstore.examples.todolist;

import net.chrisrichardson.eventstore.examples.todolist.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Goal, String> {

}

