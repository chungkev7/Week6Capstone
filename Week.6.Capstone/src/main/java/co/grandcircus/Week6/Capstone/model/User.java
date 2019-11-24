package co.grandcircus.Week6.Capstone.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;

	@OneToMany(mappedBy = "userId", orphanRemoval = true)
	List<Task> tasks = new ArrayList<>();

	public User() {
		super();
	}

	public User(String email, String password, List<Task> tasks) {
		super();
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}

	public User(int id, String email, String password, List<Task> tasks) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "User = " + id + ", email = " + email + ", password = " + password + ", tasks = " + tasks;
	}

	
}
