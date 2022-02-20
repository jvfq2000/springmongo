package com.springmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Employee {
	@Id
	private String id;
	
	private String name;
	
	private Integer wage;
	
	@DBRef
	private Employee boss;
}
