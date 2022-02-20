package com.springmongo.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmongo.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
	@Query("{$and: [{'wage': {$gte: ?0}}, {'wage': {$lte: ?1}}] }")
	public List<Employee> findByWageRange(Integer from, Integer to);
}
