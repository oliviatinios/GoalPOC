package poc.eventstore.examples.todolist.queryside.backend;


import io.eventuate.CompletableFutureUtil;
import poc.eventstore.examples.todolist.TodoRepository;
import poc.eventstore.examples.todolist.hateoas.TodoUpdateService;
import poc.eventstore.examples.todolist.model.Goal;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;


public class TodoUpdateServiceImpl implements TodoUpdateService {

    private TodoRepository repository;

    public TodoUpdateServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    public Goal save(Goal todo) {
    	
    	System.out.println("##################################################");
    	System.out.println("##################################################");
    	System.out.println("##################################################");
    	System.out.println("##################################################");
    	System.out.println("##################################################");
    	System.out.println("##################################################");
    	System.out.println("##################################################");
    	System.out.println("##################################################");
    	System.out.println("##################################################");
    	System.out.println("################################################## " + todo);
    	
        return repository.save(todo);
    }

    public List<Goal> getAll() {
        return repository.findAll();
    }

    public void remove(String id) {
        repository.delete(id);
    }

    public void removeAll() {
        repository.deleteAll();
    }

    public CompletableFuture<Goal> findById(String todoId) {
        Goal res = repository.findOne(todoId);
        if (res != null) {
            return CompletableFuture.completedFuture(res);
        }
        return CompletableFutureUtil.failedFuture(new NoSuchElementException("No todo with given id found"));
    }

}
