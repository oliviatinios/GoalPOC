package poc.eventstore.examples.todolist.queryside.backend;


import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import poc.eventstore.examples.todolist.common.event.TodoCreatedEvent;
import poc.eventstore.examples.todolist.common.event.TodoDeletedEvent;
import poc.eventstore.examples.todolist.common.event.TodoUpdatedEvent;
import poc.eventstore.examples.todolist.model.Goal;

@EventSubscriber(id = "todoQuerySideEventHandlers")
public class TodoViewEventSubscriber {

    private TodoUpdateServiceImpl todoQueryServiceImpl;

    public TodoViewEventSubscriber(TodoUpdateServiceImpl todoQueryServiceImpl) {
        this.todoQueryServiceImpl = todoQueryServiceImpl;
    }

    @EventHandlerMethod
    public void create(DispatchedEvent<TodoCreatedEvent> de) {
        Goal todo = new Goal(de.getEvent().getTodo());
        todo.setGoalId(de.getEntityId());
        
        todoQueryServiceImpl.save(todo);
    }

    @EventHandlerMethod
    public void delete(DispatchedEvent<TodoDeletedEvent> de) {
        todoQueryServiceImpl.remove(de.getEntityId());
    }

    @EventHandlerMethod
    public void update(DispatchedEvent<TodoUpdatedEvent> de) {
        Goal todo = new Goal(de.getEvent().getTodo());
        todo.setGoalId(de.getEntityId());
        todoQueryServiceImpl.save(todo);
    }
}
