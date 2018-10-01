package poc.eventstore.examples.todolist.hateoas;

import poc.eventstore.examples.todolist.common.controller.BaseController;
import poc.eventstore.examples.todolist.common.model.ResourceWithUrl;
import poc.eventstore.examples.todolist.model.Client;
import poc.eventstore.examples.todolist.model.Goal;
import poc.eventstore.examples.todolist.model.GoalInfo;
import poc.eventstore.examples.todolist.model.SaveForAnythingDetails;

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
        Goal goal = result.getContent();
        
        GoalInfo goalInfo = new GoalInfo();
        goalInfo.setCreateBy(goal.getCreateBy());
        goalInfo.setCreateOn(goal.getCreateOn());
        goalInfo.setGoalId(goal.getGoalId());
        goalInfo.setGoalName(goal.getGoalName());
        goalInfo.setGoalStatusCode(goal.getGoalStatusCode());
        goalInfo.setGoalSubtypeCode(goal.getGoalSubtypeCode());
        goalInfo.setGoalTypeCode(goal.getGoalTypeCode());
        goalInfo.setModifiedBy(goal.getModifiedBy());
        goalInfo.setModifiedOn(goal.getModifiedOn());
        goalInfo.setNote(goal.getNote());
        
        Client primaryClient = new Client();
        primaryClient.setClientXRefId(goal.getClientXRefId());
        goalInfo.setPrimaryClient(primaryClient);

        SaveForAnythingDetails saveForAnythingDetails = new SaveForAnythingDetails();
        saveForAnythingDetails.setCompleteDate(goal.getCompleteDate());
        saveForAnythingDetails.setCost(goal.getCost());
        saveForAnythingDetails.setCostFrequencyCode(goal.getCostFrequencyCode());
        saveForAnythingDetails.setCostTimeValue(goal.getCostTimeValue());
        saveForAnythingDetails.setCurrencyCode(goal.getCurrencyCode());
        saveForAnythingDetails.setInvestmentPropertyInd(goal.getInvestmentPropertyInd());
        saveForAnythingDetails.setOwnedHomeCanadaInd(goal.getOwnedHomeCanadaInd());
        saveForAnythingDetails.setRecurrence(goal.getRecurrence());
        saveForAnythingDetails.setStartDate(goal.getStartDate());
        saveForAnythingDetails.setTargetDateCode(goal.getTargetDateCode());
        goalInfo.setSaveForAnythingDetails(saveForAnythingDetails);

        ResourceWithUrl<GoalInfo> result2 = new ResourceWithUrl<>(goalInfo);
        
        
        /*if (todo != null) {
            result.setUrl(linkTo(methodOn(TodoHateoasController.class).getTodo(todo.getGoalId())).withSelfRel().getHref());
        }*/

        if (todo != null) {
        	result2.setUrl(linkTo(methodOn(TodoHateoasController.class).getTodo(goalInfo.getGoalId())).withSelfRel().getHref());
        }

        return result2;
    }
}
