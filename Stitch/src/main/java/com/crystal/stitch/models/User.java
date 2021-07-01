package com.crystal.stitch.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import com.crystal.stitch.models.Cart;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@Email
	@NotBlank
	private String email;
	
	private String gender;
	
	@NotBlank
	@Size(min=8)
	private String password;
	@Transient
	private String passwordConfirmation;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_idea", 
//			   joinColumns = @JoinColumn(name = "user_id"),
//			   inverseJoinColumns = @JoinColumn(name = "cartitem_id"))
//	private List<Cart> purchaseCart;
//	
	
	public User() {};

//	public User(@NotBlank String name, @Email @NotBlank String email, String gender,
//			@NotBlank @Size(min = 8) String password, String passwordConfirmation, List<Cart> purchaseCart) {
//		
//		this.name = name;
//		this.email = email;
//		this.gender = gender;
//		this.password = password;
//		this.passwordConfirmation = passwordConfirmation;
//		this.purchaseCart = purchaseCart;
//	}
	
	
	

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

//	public List<Cart> getPurchaseCart() {
//		return purchaseCart;
//	}
//
//	public void setPurchaseCart(List<Cart> purchaseCart) {
//		this.purchaseCart = purchaseCart;
//	}
//	
}