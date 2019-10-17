package com.collabera.motors.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturers", schema = "cardealership")
public class Manufacturer {
	
	@Id
	private int id;
	@Column
	private String make;
	@Column
	private String image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Manufacturer(int id, String make, String image) {
		super();
		this.id = id;
		this.make = make;
		this.image = image;
	}
	public Manufacturer() {
		super();
		this.id = 0;
		this.make = "";
		this.image = "";
	}
	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", make=" + make + ", image=" + image + "]";
	}
	
	

}
