package net.chrisrichardson.eventstore.examples.todolist.hateoas;

import net.chrisrichardson.eventstore.examples.todolist.model.Goal;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by popikyardo on 23.03.16.
 */
public interface TodoUpdateService {

    List<Goal> getAll();

    CompletableFuture<Goal> findById(String todoId);
}
