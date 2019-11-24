package co.grandcircus.Week6.Capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Week6.Capstone.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	
	User findById(int id);
	
}
