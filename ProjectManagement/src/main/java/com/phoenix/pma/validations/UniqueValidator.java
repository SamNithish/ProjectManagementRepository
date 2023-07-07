package com.phoenix.pma.validations;

import org.springframework.beans.factory.annotation.Autowired;

import com.phoenix.pma.dao.EmployeeRepository;
import com.phoenix.pma.entities.Employee;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("Entered validation method...");
		Employee emp = empRepo.findByEmail(value);
		if (emp != null)
			return false;
		else
			return true;
	}

}
