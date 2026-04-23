package com.project.springbootjpa.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.springbootjpa.main.entity.Employee;
import com.project.springbootjpa.main.service.EmployeeService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// @RequestMapping(value ="/save", method=RequestMethod.POST)
	@PostMapping("/save")
	public String aveEmp(@RequestBody Employee employee) {
		String result = service.saveEmployee(employee);
		return result;
	}

	@GetMapping("findbyid/{id}/")
	public Employee getEmpById(@PathVariable("id") Long id) {
		return service.getEmpById(id);
	}

	@PutMapping("./update-emp/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee newEmp) {
		if (!(id > 0)) {
			return null;
		}
		return service.updateEmployee(id, newEmp);
	}

	@DeleteMapping("./delete/{id}")
	public String deleteEmp(@PathVariable Long id) {
		return service.deleteEmp(id);
	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmps() {
		return service.getAllEmps();
	}

	@GetMapping("/get-emp-name")
	public Employee getByName(@RequestParam String name) {
		System.out.println(name);
		return service.findByEmpName(name);
	}

	@GetMapping("/sal")
	public Employee getBySal(@RequestParam double sal) {
		System.out.println(sal);
		return service.findByEmpSal(sal);
	}

}
