package com.springmongo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmongo.model.Employee;

@Service
public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(String id);
	public Employee create(Employee employee);
	public List<Employee> findByWageRange(Integer from, Integer to);
}
