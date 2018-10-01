package poc.eventstore.examples.todolist.queryside.web;

import poc.eventstore.examples.todolist.common.controller.BaseController;
import poc.eventstore.examples.todolist.common.model.ResourceWithUrl;
import poc.eventstore.examples.todolist.hateoas.TodoHateoasController;
import poc.eventstore.examples.todolist.model.Goal;
import poc.eventstore.examples.todolist.queryside.backend.TodoUpdateServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping(value = "/goals")
public class TodoViewController extends BaseController {

    @Autowired
    private TodoUpdateServiceImpl queryService;

    @RequestMapping(method = GET)
    public HttpEntity<Collection<ResourceWithUrl>> listAll() {
        List<ResourceWithUrl> resourceWithUrls = queryService.getAll().stream().map(this::toResource).collect(Collectors.toList());
        return new ResponseEntity<>(resourceWithUrls, OK);
    }

    public ResourceWithUrl toResource(Goal todo) {
        ResourceWithUrl<Goal> result = new ResourceWithUrl<>(todo);
        if (todo != null) {
            result.setUrl(linkTo(methodOn(TodoHateoasController.class).getTodo(todo.getGoalId())).withSelfRel().getHref());
        }
        return result;
    }
}
