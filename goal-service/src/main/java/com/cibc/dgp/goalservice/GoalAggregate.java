package com.cibc.dgp.goalservice;

import java.util.Collections;
import java.util.List;

import com.cibc.dgp.api.goal.model.Goal;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

public class GoalAggregate extends ReflectiveMutableCommandProcessingAggregate<GoalAggregate, GoalCommand>{

    private Goal goal;
    private boolean deleted;
 
    public List<Event> process(AddGoalCommandImpl cmd) {
        if (this.deleted) {
            return Collections.emptyList();
        }
        return EventUtil.events(new AddGoalEventImpl(cmd.getGoal()));
    }

    public List<Event> process(UpdateGoalCommandImpl cmd) {
        if (this.deleted) {
            return Collections.emptyList();
        }
        return EventUtil.events(new UpdateGoalEventImpl(cmd.getGoal()));
    }

 


    public void apply(AddGoalEventImpl event) {
        this.goal = event.getGoal();
    }

    public void apply(UpdateGoalEventImpl event) {
        this.goal = event.getGoal();
    }

 

 
	
}
