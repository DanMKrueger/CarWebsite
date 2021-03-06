package com.collabera.motors.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cars", schema = "cardealership")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {

	@Id
	private int id;
	@Column(name="make")
	private String make;
	@Column(name="model")
	private String model;
	@Column(name="car_year")
	private String car_year;
	@Column(name="color")
	private String color;
	@Column(name="description")
	private String description;
	@Column(name="picture")
	private String picture;
	@Column(name="price")
	private String price;

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
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
				+ ", description=" + description + ", picture=" + picture + ", price=" + price + "]";
	}

}
