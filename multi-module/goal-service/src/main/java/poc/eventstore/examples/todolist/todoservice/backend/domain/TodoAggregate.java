package poc.eventstore.examples.todolist.todoservice.backend.domain;


import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import poc.eventstore.examples.todolist.common.event.TodoCreatedEvent;
import poc.eventstore.examples.todolist.common.event.TodoDeletedEvent;
import poc.eventstore.examples.todolist.common.event.TodoUpdatedEvent;
import poc.eventstore.examples.todolist.model.GoalInfo;
import poc.eventstore.examples.todolist.todoservice.backend.command.CreateTodoCommand;
import poc.eventstore.examples.todolist.todoservice.backend.command.DeleteTodoCommand;
import poc.eventstore.examples.todolist.todoservice.backend.command.TodoCommand;
import poc.eventstore.examples.todolist.todoservice.backend.command.UpdateTodoCommand;

import java.util.Collections;
import java.util.List;

public class TodoAggregate extends ReflectiveMutableCommandProcessingAggregate<TodoAggregate, TodoCommand> {

    private GoalInfo todo;
    private boolean deleted;

    public List<Event> process(CreateTodoCommand cmd) {
        if (this.deleted) {
            return Collections.emptyList();
        }
        return EventUtil.events(new TodoCreatedEvent(cmd.getTodo()));
    }

    public List<Event> process(UpdateTodoCommand cmd) {
        if (this.deleted) {
            return Collections.emptyList();
        }
        return EventUtil.events(new TodoUpdatedEvent(cmd.getTodo()));
    }

    public List<Event> process(DeleteTodoCommand cmd) {
        if (this.deleted) {
            return Collections.emptyList();
        }
        return EventUtil.events(new TodoDeletedEvent());
    }


    public void apply(TodoCreatedEvent event) {
        this.todo = event.getTodo();
    }

    public void apply(TodoUpdatedEvent event) {
        this.todo = event.getTodo();
    }

    public void apply(TodoDeletedEvent event) {
        this.deleted = true;
    }

    public GoalInfo getTodo() {
        return todo;
    }

}


