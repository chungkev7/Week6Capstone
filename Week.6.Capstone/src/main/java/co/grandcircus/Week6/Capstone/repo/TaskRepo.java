package co.grandcircus.Week6.Capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Week6.Capstone.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {

	Task findById(int id);
	}
