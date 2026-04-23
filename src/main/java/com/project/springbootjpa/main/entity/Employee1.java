package com.project.springbootjpa.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="employee")
public class Employee1 {
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name ="emp_id")
private int id;
private String name;
private String address;
private double salary;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmployeeName() {
	return name;
}
public void setEmployeeName(String name) {
	this.name = name;
}
public String getEmployeeAddress() {
	return address;
}
public void setEmployeeAddress(String address) {
	this.address = address;
}
public double getEmployeeSalary() {
	return salary;
}
public void setEmployeeSalary(double salary) {
	this.salary = salary;
}




	
	
}
