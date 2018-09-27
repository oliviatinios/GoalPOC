package com.cibc.dgp.goalservice;

import com.cibc.dgp.api.goal.model.Goal;

public class AddGoalCommandImpl implements GoalCommand {
	
    private Goal goal;

    public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public AddGoalCommandImpl(Goal goal) {
        this.goal = goal;
    }


}
