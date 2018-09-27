package com.cibc.dgp.goalservice;

import com.cibc.dgp.api.goal.model.Goal;

public class UpdateGoalEventImpl implements GoalEvent{
	private Goal goal;

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
 public UpdateGoalEventImpl (Goal goal) {
	 setGoal(goal);
 }
}
