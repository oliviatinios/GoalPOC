package poc.eventstore.examples.todolist.todoservice.backend.domain;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import poc.eventstore.examples.todolist.model.GoalInfo;
import poc.eventstore.examples.todolist.todoservice.backend.command.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class TodoService {

    private final AggregateRepository<TodoAggregate, TodoCommand> aggregateRepository;
    private final AggregateRepository<TodoBulkDeleteAggregate, TodoCommand> bulkDeleteAggregateRepository;


    public TodoService(AggregateRepository<TodoAggregate, TodoCommand> todoRepository, AggregateRepository<TodoBulkDeleteAggregate, TodoCommand> bulkDeleteAggregateRepository) {
        this.aggregateRepository = todoRepository;
        this.bulkDeleteAggregateRepository = bulkDeleteAggregateRepository;
    }

    public CompletableFuture<EntityWithIdAndVersion<TodoAggregate>> save(GoalInfo todo) {
        return aggregateRepository.save(new CreateTodoCommand(todo));
    }

    public CompletableFuture<EntityWithIdAndVersion<TodoAggregate>> remove(String id) {
        return aggregateRepository.update(id, new DeleteTodoCommand());
    }

    public CompletableFuture<EntityWithIdAndVersion<TodoAggregate>> update(String id, GoalInfo newTodo) {
        return aggregateRepository.update(id, new UpdateTodoCommand(id, newTodo));
    }

    public CompletableFuture<EntityWithIdAndVersion<TodoBulkDeleteAggregate>> deleteAll(List<String> ids) {
        return bulkDeleteAggregateRepository.save(new DeleteTodosCommand(ids));
    }
}
