package com.uniovi.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	private String dni;
	private String name;
	private String lastName;
	private String role;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private Set<Mark> marks;

	public User(String dni, String name, String lastName) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
	}
	
	public User() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getFullName() {
		return this.name + " " + this.lastName;
	}
	
	public Set<Mark> getMarks(){
		return new HashSet<Mark>(marks);
	}

	public void setMarks(Set marks) {
		this.marks = marks;		
	}

}

