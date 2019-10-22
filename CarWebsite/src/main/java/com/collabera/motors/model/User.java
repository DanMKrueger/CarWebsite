package com.collabera.motors.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "users", schema = "cardealership")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	@Id
	private int id;
	@Column(name="user_name")
	private String user_name;
	@Column(name="user_password")
	private String user_password;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="admin")
	private Boolean admin;
	
	public User(int id, String user_name, String user_password, String first_name, String last_name, Boolean admin) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.admin = admin;
	}
	
	public User() {
		super();
		this.id = 0;
		this.user_name = "";
		this.user_password = "";
		this.first_name = "";
		this.last_name = "";
		this.admin = false;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", user_name=" + user_name + ", user_password=" + user_password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", admin=" + admin + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}


}
