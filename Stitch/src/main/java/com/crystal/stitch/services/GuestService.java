package com.crystal.stitch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystal.stitch.models.Guest;
import com.crystal.stitch.respositories.GuestRepository;

@Service
public class GuestService {
	@Autowired
	private GuestRepository gRepo;
	
	//saves first guest when DB is empty
	public  Guest saveFirstGuest(Guest firstGuest) {
		
		firstGuest.setEmail("null@null");
		firstGuest.setName("Guest");		
		return this.gRepo.save(firstGuest);
	}
	
	// get user by guest id
	public Guest getGuestId() {
		return this.gRepo.findById((long) 1).orElse(null);
	}
}

