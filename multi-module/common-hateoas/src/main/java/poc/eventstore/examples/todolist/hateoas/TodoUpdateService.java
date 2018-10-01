package poc.eventstore.examples.todolist.hateoas;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import poc.eventstore.examples.todolist.model.Goal;

/**
 * Created by popikyardo on 23.03.16.
 */
public interface TodoUpdateService {

    List<Goal> getAll();

    CompletableFuture<Goal> findById(String todoId);
}
