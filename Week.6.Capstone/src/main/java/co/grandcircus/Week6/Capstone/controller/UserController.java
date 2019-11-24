/*
 * @Author: Kevin
 */

package co.grandcircus.Week6.Capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Week6.Capstone.model.Task;
import co.grandcircus.Week6.Capstone.model.User;
import co.grandcircus.Week6.Capstone.repo.TaskRepo;
import co.grandcircus.Week6.Capstone.repo.UserRepo;

@Controller
public class UserController {

	@Autowired
	UserRepo rp;
	
	@Autowired
	TaskRepo tr;
	
	@RequestMapping("/new-account")
	public ModelAndView newAccount() {
		return new ModelAndView("add-user");
	}
	
	@PostMapping("/add-user")
	public ModelAndView addUser(User user) {
		rp.save(user);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/login-user")
	public ModelAndView loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		List<User> users = rp.findAll();
		User loginUser = rp.findByEmail(email);
		if (!users.contains(loginUser)) {
			return new ModelAndView("sorry", "message", "Your email is not in our database");
		} if (!loginUser.getPassword().equals(password)) {
			return new ModelAndView("sorry", "message", "Your password does not match");
		}
		return new ModelAndView("task-list", "user", loginUser);
	}
	
	@PostMapping("/add-task")
	public ModelAndView addTask(@RequestParam("task") String task, @RequestParam("dueDate") String dueDate, int id) {
		Task newTask = new Task();
		newTask.setTask(task);
		newTask.setDueDate(dueDate);
		User loginUser = rp.findById(id);
		newTask.setUserId(loginUser);
		tr.save(newTask);
		return new ModelAndView("task-list","user", loginUser);
	}
	
	@RequestMapping("/mark-complete")
	public ModelAndView markComplete(int id) {
		Task completeTask = tr.findById(id);
		completeTask.setCompleted(true);
		tr.save(completeTask);
		User loginUser = completeTask.getUserId();
		return new ModelAndView("task-list","user", loginUser);
	}
	
	@RequestMapping("/delete-task")
	public ModelAndView deleteTask(int id) {
		Task deleteTask = tr.findById(id);
		User loginUser = deleteTask.getUserId();
		tr.delete(deleteTask);
		return new ModelAndView("task-list", "user", loginUser);
	}
}
