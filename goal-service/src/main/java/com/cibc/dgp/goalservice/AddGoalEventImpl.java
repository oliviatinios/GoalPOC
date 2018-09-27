package com.cibc.dgp.goalservice;

import com.cibc.dgp.api.goal.model.Goal;

public class AddGoalEventImpl implements GoalEvent {
	
	private Goal goal;

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
	public AddGoalEventImpl(Goal goal) {
		setGoal(goal);
	}
	

}
