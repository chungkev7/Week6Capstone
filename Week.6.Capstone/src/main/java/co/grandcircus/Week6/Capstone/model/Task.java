package co.grandcircus.Week6.Capstone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String task;
	private String dueDate;
	private boolean isCompleted;

	@ManyToOne
	private User userId;

	public Task() {
		super();
	}

	public Task(String task, String dueDate) {
		super();
		this.task = task;
		this.dueDate = dueDate;
	}

	public Task(String task, String dueDate, User userId) {
		super();
		this.task = task;
		this.dueDate = dueDate;
		this.userId = userId;
	}

	public Task(int id, String task, String dueDate, User userId) {
		super();
		this.id = id;
		this.task = task;
		this.dueDate = dueDate;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Task = " + task + ", Due date = " + dueDate + ", isCompleted = " + isCompleted;
	}

}
