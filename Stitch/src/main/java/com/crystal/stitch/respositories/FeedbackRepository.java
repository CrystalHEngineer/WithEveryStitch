package com.crystal.stitch.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crystal.stitch.models.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

	// Retrieve all
	List<Feedback> findAll();
	
}


