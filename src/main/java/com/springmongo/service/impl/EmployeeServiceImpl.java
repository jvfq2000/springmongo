package com.springmongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmongo.model.Employee;
import com.springmongo.repository.EmployeeRepository;
import com.springmongo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee findById(String id) {
		return this.employeeRepository
			.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado."));
	}

	@Override
	public Employee create(Employee employee) {
		Employee boss =  this.employeeRepository
				.findById(employee.getBoss().getId())
				.orElseThrow(() -> new IllegalArgumentException("Chefe inexistente."));
		
		employee.setBoss(boss);
		
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findByWageRange(Integer from, Integer to) {
		return this.employeeRepository.findByWageRange(from, to);
	}
}
