package poc.eventstore.examples.todolist.todoservice.backend.command;


import poc.eventstore.examples.todolist.model.GoalInfo;


public class UpdateTodoCommand implements TodoCommand {
    private String id;
    private GoalInfo todo;

    public UpdateTodoCommand(String id, GoalInfo todo) {
        this.id = id;
        this.todo = todo;
    }

    public String getId() {
        return id;
    }

    public GoalInfo getTodo() {
        return todo;
    }
}
