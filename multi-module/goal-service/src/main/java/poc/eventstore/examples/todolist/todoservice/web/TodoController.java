package poc.eventstore.examples.todolist.todoservice.web;

import poc.eventstore.examples.todolist.common.controller.BaseController;
import poc.eventstore.examples.todolist.common.model.ResourceWithUrl;
import poc.eventstore.examples.todolist.hateoas.TodoHateoasController;
import poc.eventstore.examples.todolist.model.Goal;
import poc.eventstore.examples.todolist.model.GoalInfo;
import poc.eventstore.examples.todolist.todoservice.backend.TodoViewServiceImpl;
import poc.eventstore.examples.todolist.todoservice.backend.domain.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping(value = "/goal")
public class TodoController extends BaseController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoViewServiceImpl todoViewService;

    @RequestMapping(method = POST)
    public CompletableFuture<ResourceWithUrl> saveTodo(@RequestBody GoalInfo todo, HttpServletRequest request) {
        return todoService.save(todo).thenApply(e -> withRequestAttributeContext(request, () -> toResource(e.getAggregate().getTodo(), e.getEntityId())));
    }

    @RequestMapping(value = "/{goal-id}", method = DELETE)
    public CompletableFuture<ResourceWithUrl> deleteOneTodo(@PathVariable("goal-id") String id, HttpServletRequest request) {
        return todoService.remove(id)
                .thenApply(e -> withRequestAttributeContext(request, () -> toResource(e.getAggregate().getTodo(), e.getEntityId())));
    }

    @RequestMapping(method = DELETE)
    public void deleteAllTodos() throws Exception {
        List<Goal> todosToDelete = todoViewService.getAll();
        if (todosToDelete.size() > 0) {
            todoService.deleteAll(todoViewService.getAll()
                    .stream()
                    .map(Goal::getGoalId)
                    .collect(Collectors.toList()));
        }
    }

    @RequestMapping(value = "/{goal-id}", method = PATCH, headers = {"Content-type=application/json"})
    public CompletableFuture<ResourceWithUrl> updateTodo(@PathVariable("goal-id") String id, @RequestBody GoalInfo newTodo, HttpServletRequest request) {
        return todoService.update(id, newTodo).thenApply(e -> withRequestAttributeContext(request, () -> toResource(e.getAggregate().getTodo(), e.getEntityId()))
        );
    }

    protected ResourceWithUrl toResource(GoalInfo todo, String id) {
        ResourceWithUrl<GoalInfo> result = new ResourceWithUrl<>(todo);
        result.setId(id);
        result.setUrl(ControllerLinkBuilder.linkTo(methodOn(TodoHateoasController.class).getTodo(id)).withSelfRel().getHref());
        return result;
    }
}
