package com.cibc.dgp.goalservice;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.cibc.dgp.goalservice.GoalAggregate")
public interface GoalEvent extends Event {

}
