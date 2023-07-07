package com.phoenix.pma.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.pma.dao.EmployeeRepository;
import com.phoenix.pma.entities.Employee;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping
	public List<Employee> EmployeesList() {
		return (List<Employee>) empRepo.findAll();
	}

	@GetMapping("/{id}")
	public Employee getEmployeebyID(@PathVariable("id") long id) {
		return empRepo.findById(id).get();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@RequestBody @Valid Employee emp) {
		return empRepo.save(emp);
	}

	@PutMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee update(@RequestBody Employee emp) {
		return empRepo.save(emp);
	}

	@PatchMapping(path = "/{id}", consumes = "application/json")
	public Employee partialUpdate(@PathVariable("id") long id, @RequestBody Employee patchEmp) {
		Employee emp = empRepo.findById(id).get();
		if (patchEmp.getEmail() != null) {
			emp.setEmail(patchEmp.getEmail());
		}
		if (patchEmp.getName() != null) {
			emp.setName(patchEmp.getName());
		}
		return empRepo.save(emp);
	}

	@DeleteMapping("/{id}")
	public void delEmpbyID(@PathVariable("id") long id) {
		empRepo.deleteById(id);
	}

	@GetMapping(params = { "page", "size" })
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") int page, @RequestParam("size") int size) {
		Pageable pageAndSize = PageRequest.of(page, size);
		return empRepo.findAll(pageAndSize);
	}

}
