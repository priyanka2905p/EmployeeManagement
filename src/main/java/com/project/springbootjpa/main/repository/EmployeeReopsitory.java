package com.project.springbootjpa.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springbootjpa.main.entity.Employee;

@Repository
public interface EmployeeReopsitory extends JpaRepository<Employee , Long>
{
	
	Optional<Employee> findByEmployeeName(String employeeName);
	Optional<Employee> findByEmployeeSalary(double employeeSalary);
	
}
