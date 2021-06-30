package com.crystal.stitch.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crystal.stitch.models.Feedback;
import com.crystal.stitch.respositories.FeedbackRepository;

@Service
public class FeedbackService {

    // add the repository as a dependency
   private final FeedbackRepository fRepo;
    
   // Constructor
   public FeedbackService(FeedbackRepository feedbackRepository) {
       this.fRepo = feedbackRepository;
   }
    
    //Methods
    
    // Retrieve All
    public List<Feedback> findAllFeedback() {
        return this.fRepo.findAll();
    }
    // Create
    public Feedback createFeedback(Feedback newFeedback) {
        return this.fRepo.save(newFeedback);
    }
    
    // Read - Find One
    public Feedback findOneFeedback(Long id) {
        return this.fRepo.findById(id).orElse(null);
    }
    
    // Update
    public Feedback updateFeedback(Feedback updatedFeedback) {
        return this.fRepo.save(updatedFeedback);
    }

    // Delete
    public void deleteFeedback(Long id) {
        this.fRepo.deleteById(id);
    }	
	
}
