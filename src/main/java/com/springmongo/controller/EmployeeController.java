package com.springmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springmongo.model.Employee;
import com.springmongo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> findAll() {
		return this.employeeService.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable String id) {
		return this.employeeService.findById(id);
	}
	
	@GetMapping("/range")
	public List<Employee> findByWageRange(
		@RequestParam Integer from,
		@RequestParam Integer to
	) {
		return this.employeeService.findByWageRange(from, to);
	}
	
	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return this.employeeService.create(employee);
	}
}
