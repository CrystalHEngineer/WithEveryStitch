package com.crystal.stitch.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crystal.stitch.models.Cart;

@Repository
public interface CartRepository  extends CrudRepository <Cart,Long>{

}
