package com.project.springbootjpa.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springbootjpa.main.entity.Employee;
import com.project.springbootjpa.main.repository.EmployeeReopsitory;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeReopsitory repo;
	
	public String saveEmployee(Employee emp) {
	
		repo.save(emp);
		return "Employee " + emp.getEmployeeName() + " saved.....";
	}
	public Employee getEmpById(Long id) {
		return null;
	}
	public Employee updateEmployee(Long id,Employee newEmp) {
		Employee oldEmp=null;
		Optional<Employee> optionalEmp=repo.findById(id);
		
		if(optionalEmp.isPresent()) {
			oldEmp = optionalEmp.get();
			oldEmp.setEmployeeName(newEmp.getEmployeeName());
			oldEmp.setEmployeeAddress(newEmp.getEmployeeAddress());
			oldEmp.setEmployeeSalary(newEmp.getEmployeeSalary());
			repo.save(oldEmp);
		}
		return oldEmp;
	}
	
	
	public String deleteEmp(Long id) {
		Optional<Employee> optionalEmp = repo.findById(id);
		if(optionalEmp.isPresent()) {
			Employee e= optionalEmp.get();
			repo.delete(e);
			return "employee" +e.getEmployeeName() + " deleted successfully";
			}
		
		return "emp with id : " +id + "is not availble in db ";
	}
	
	public List<Employee> getAllEmps(){
		return repo.findAll();
	}
	
	public Employee findByEmpName(String name) {
		Optional<Employee> optionalEmp=repo.findByEmployeeName(name);
		System.out.println(optionalEmp);
		if(optionalEmp.isPresent()) {
			return optionalEmp.get();
		}
		return null;
	}
	
	public Employee findByEmpSal(Double sal) {
		Optional<Employee> optionalEmp=repo.findByEmployeeSalary(sal);
		System.out.println(optionalEmp);
		if(optionalEmp.isPresent()) {
			return optionalEmp.get();
		}
		return null;
	}

	
}
