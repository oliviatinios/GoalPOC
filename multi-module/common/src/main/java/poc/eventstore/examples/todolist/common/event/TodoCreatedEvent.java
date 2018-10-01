package poc.eventstore.examples.todolist.common.event;

import poc.eventstore.examples.todolist.model.GoalInfo;

public class TodoCreatedEvent implements TodoEvent {

    GoalInfo todo;

    private TodoCreatedEvent() {
    }

    public TodoCreatedEvent(GoalInfo todo) {
        this.todo = todo;
    }

    public GoalInfo getTodo() {
        return todo;
    }

    public void setTodo(GoalInfo todo) {
        this.todo = todo;
    }
}