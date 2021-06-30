package com.crystal.stitch.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crystal.stitch.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	
	boolean existsByEmail(String email);
	
	User findByEmail(String email);
	User findUserById(Long id);
}

