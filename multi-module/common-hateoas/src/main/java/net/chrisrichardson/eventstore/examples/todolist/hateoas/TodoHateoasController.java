package net.chrisrichardson.eventstore.examples.todolist.hateoas;

import net.chrisrichardson.eventstore.examples.todolist.common.controller.BaseController;
import net.chrisrichardson.eventstore.examples.todolist.common.model.ResourceWithUrl;
import net.chrisrichardson.eventstore.examples.todolist.model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by popikyardo on 23.03.16.
 */
@RestController
@RequestMapping(value = "/goal")
public class TodoHateoasController extends BaseController {

    @Autowired
    private TodoUpdateService queryService;

    @RequestMapping(value = "/{goal-id}", method = GET)
    public CompletableFuture<ResourceWithUrl> getTodo(@PathVariable("goal-id") String id) {
        return queryService.findById(id).thenApply(this::toResource);
    }

    public ResourceWithUrl toResource(Goal todo) {
        ResourceWithUrl<Goal> result = new ResourceWithUrl<>(todo);
        if (todo != null) {
            result.setUrl(linkTo(methodOn(TodoHateoasController.class).getTodo(todo.getGoalId())).withSelfRel().getHref());
        }
        return result;
    }
}
