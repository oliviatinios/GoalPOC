package poc.eventstore.examples.todolist;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.eventstore.examples.todolist.model.Goal;


public interface TodoRepository extends JpaRepository<Goal, String> {

}

