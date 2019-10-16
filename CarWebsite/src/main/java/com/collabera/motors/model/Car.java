package com.collabera.motors.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars", schema = "cardealership")
public class Car {

	@Id
	private int id;
	@Column
	private String make;
	@Column
	private String model;
	@Column
	private String car_year;
	@Column
	private String color;
	@Column
	private String description;
	@Column
	private String picture;

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCar_year() {
		return car_year;
	}

	public void setCar_year(String car_year) {
		this.car_year = car_year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Car(int id, String make, String model, String car_year, String color, String description, String picture) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.car_year = car_year;
		this.color = color;
		this.description = description;
		this.picture = picture;
	}

	public Car() {
		super();
		this.id = 0;
		this.make = "";
		this.model = "";
		this.car_year = "";
		this.color = "";
		this.description = "";
		this.picture = "";
	}

	@Override
	public String toString() {
		return "[id=" + id + ", make=" + make + ", model=" + model + ", car_year=" + car_year + ", color=" + color
				+ ", description=" + description + ", picture=" + picture + "]";
	}

}
