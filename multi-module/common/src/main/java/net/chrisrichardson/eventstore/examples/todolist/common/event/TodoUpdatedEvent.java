package net.chrisrichardson.eventstore.examples.todolist.common.event;


import net.chrisrichardson.eventstore.examples.todolist.model.GoalInfo;

public class TodoUpdatedEvent implements TodoEvent {

    private GoalInfo todo;

    private TodoUpdatedEvent() {
    }

    public TodoUpdatedEvent(GoalInfo todo) {
        this.todo = todo;
    }

    public GoalInfo getTodo() {
        return todo;
    }

    public void setTodo(GoalInfo todo) {
        this.todo = todo;
    }
}