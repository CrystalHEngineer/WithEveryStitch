package com.crystal.stitch.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;


import com.crystal.stitch.models.User;
import com.crystal.stitch.respositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		
		this.userRepo = userRepo;
	}
	
	public  User registerUser(User inputUser) {
		
		String hashed = BCrypt.hashpw(inputUser.getPassword(), BCrypt.gensalt());
		inputUser.setPassword(hashed);
		return this.userRepo.save(inputUser);
	}
	
	public User findUserByEmail(String email) {
		
		return this.userRepo.findByEmail(email);
	}
	
	public User findUserById(Long Id) {
		
		return this.userRepo.findUserById(Id);
	}
	
	public boolean authenticateUser(String email, String password) {
		
		User theUser = this.userRepo.findByEmail(email);
		
		if (theUser == null) {
			return false;
		}
		
		else {
			
			if(BCrypt.checkpw(password, theUser.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
}

