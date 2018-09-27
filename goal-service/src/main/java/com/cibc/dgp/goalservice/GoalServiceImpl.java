package com.cibc.dgp.goalservice;

import java.util.concurrent.CompletableFuture;

import com.cibc.dgp.api.goal.model.Goal;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;

public class GoalServiceImpl implements GoalService {
	
	
	
	
	private final AggregateRepository<GoalAggregate, GoalCommand> aggregateRepository;

	   public GoalServiceImpl(AggregateRepository<GoalAggregate, GoalCommand> todoRepository) {
	        this.aggregateRepository = todoRepository;
	    }


    public CompletableFuture<EntityWithIdAndVersion<GoalAggregate>> addGoal(Goal goal) {
        return aggregateRepository.save(new AddGoalCommandImpl(goal));
    }


    public CompletableFuture<EntityWithIdAndVersion<GoalAggregate>> updateGoal(String id, Goal goal) {
        return aggregateRepository.update(id, new UpdateGoalCommandImpl(goal));
    }


}
