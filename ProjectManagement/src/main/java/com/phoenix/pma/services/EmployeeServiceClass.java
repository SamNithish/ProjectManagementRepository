package com.phoenix.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.pma.dao.EmployeeRepository;
import com.phoenix.pma.dto.EmployeeProject;
import com.phoenix.pma.entities.Employee;

@Service
public class EmployeeServiceClass {

	// Field injection (defenitely need the @autowired annotation)
	@Autowired
	EmployeeRepository empRepo;

	// Contructor Injection (this doesnt need @autowired Annotation)
//	public EmployeeServiceClass(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}

	// Setter Injection (It does need @autowired Annotation)
//	@Autowired
//	public void setEmpRepo(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}

	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}

	public List<Employee> findAll() {
		return (List<Employee>) empRepo.findAll();
	}

	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}

}
