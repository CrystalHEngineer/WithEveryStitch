package com.crystal.stitch.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.crystal.stitch.models.User;
import com.crystal.stitch.respositories.UserRepository;


@Component
public class UserValidator {
	
	private final UserRepository userRepo;
	
	public UserValidator(UserRepository userRepo) {
		
		this.userRepo = userRepo;
	}
	
	public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	
	public void validate(Object target, Errors errors) {
		
		User user = (User)target;
		
		
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			errors.rejectValue("password", "Match", "Password or Account not valid");
		}
		
		else if(this.userRepo.existsByEmail(user.getEmail())) {
			
			errors.rejectValue("email", "Match", "Password or Account not valid");
		}
	}

}
