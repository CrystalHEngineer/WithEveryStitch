package com.crystal.stitch.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crystal.stitch.models.Guest;

@Repository
public interface GuestRepository extends CrudRepository <Guest, Long> {

}
