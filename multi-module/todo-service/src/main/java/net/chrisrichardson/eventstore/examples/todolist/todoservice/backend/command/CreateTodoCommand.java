package net.chrisrichardson.eventstore.examples.todolist.todoservice.backend.command;


import net.chrisrichardson.eventstore.examples.todolist.model.GoalInfo;

public class CreateTodoCommand implements TodoCommand {

    private GoalInfo todo;

    public CreateTodoCommand(GoalInfo todo) {
        this.todo = todo;
    }

    public GoalInfo getTodo() {
        return todo;
    }
}
