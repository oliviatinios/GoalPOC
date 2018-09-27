package com.cibc.dgp.goalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibc.dgp.api.goal.model.Goal;

import io.eventuate.EntityWithIdAndVersion;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping(value = "/goals")
public class GoalController {
    @Autowired
    private GoalService goalService;
    
    @RequestMapping(method = POST)
    public String saveGoal(@RequestBody Goal goal, HttpServletRequest request) throws Throwable{
        
    	CompletableFuture<EntityWithIdAndVersion<GoalAggregate>> response= goalService.addGoal(goal);
 
    	return response.get().getEntityId();
        
    }


    
    private Object withRequestAttributeContext(HttpServletRequest request, Object object) {
		// TODO Auto-generated method stub
		return null;
	}



	@RequestMapping(value = "/{goal-id}", method = PUT, headers = {"Content-type=application/json"})
    public String updateGoal(@PathVariable("goal-id") String id, @RequestBody Goal goal, HttpServletRequest request) throws Throwable{
        //return goalService.updateGoal(id, goal).thenApply(e -> withRequestAttributeContext(request, () -> toResource(e.getAggregate().getTodo(), e.getEntityId()))
        
    
        		
            	CompletableFuture<EntityWithIdAndVersion<GoalAggregate>> response= goalService.updateGoal(id, goal);
        
           	return response.get().getEntityId();
               
     
    }

    
}