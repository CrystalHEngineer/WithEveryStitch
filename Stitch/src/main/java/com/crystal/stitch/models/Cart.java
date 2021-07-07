package com.crystal.stitch.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String total;
	 
	
	@Column(name ="order_status")
	private String Order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
				
	@ManyToOne
	@JoinColumn(name="guest_id")
	private Guest guest;
						
	@OneToMany(mappedBy="cart",
		cascade=CascadeType.ALL,
		fetch=FetchType.LAZY)
	private List<CartItem> cartItems;
		
	@Column(updatable=false)
	@DateTimeFormat(pattern ="yyy-MM-DD HH:mm:ss")
	private Date createdAt;
			
	@DateTimeFormat(pattern ="yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
			
	@PrePersist
	protected void onCreate() {
		this.createdAt= new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt= new Date();
	}
			
	//construct
	public Cart() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	

	public String getOrder() {
		return Order;
	}
	public void setOrder(String order) {
		Order = order;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
