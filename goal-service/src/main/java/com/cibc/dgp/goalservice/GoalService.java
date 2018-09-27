package com.cibc.dgp.goalservice;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.cibc.dgp.api.goal.model.Goal;

import io.eventuate.EntityWithIdAndVersion;


public interface GoalService {
	
    public CompletableFuture<EntityWithIdAndVersion<GoalAggregate>> addGoal(Goal goal);


    public CompletableFuture<EntityWithIdAndVersion<GoalAggregate>> updateGoal(String id, Goal goal); 
}
