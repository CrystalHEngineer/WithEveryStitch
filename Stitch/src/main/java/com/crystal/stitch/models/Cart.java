package com.crystal.stitch.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cart {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
}
