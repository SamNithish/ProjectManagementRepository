package com.phoenix.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoenix.pma.dao.EmployeeRepository;
import com.phoenix.pma.dao.ProjectRepository;
import com.phoenix.pma.entities.Employee;
import com.phoenix.pma.entities.Project;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
//	now we can Also use this "EmployeeServiceClass empRepo;" refer class

	@Autowired
	ProjectRepository proRepo;

	@GetMapping
	public String empList(Model model) {
		List<Employee> employees = (List<Employee>) empRepo.findAll();
		model.addAttribute("empList", employees);
		return "Employee/employeeList";
	}

	@GetMapping("/new")
	public String newEmp(Model model) {
		Employee emp = new Employee();
		List<Project> projects = (List<Project>) proRepo.findAll();
		model.addAttribute("allProjects", projects);
		model.addAttribute("employee", emp);
		return "Employee/newemployee";
	}

	@PostMapping("/save")
	public String saveEmp(@Valid Employee emp, Errors error) {
		if(error.hasErrors()) {
			return "Employee/newemployee";
		}
		empRepo.save(emp);
		return "redirect:/employees";

	}

	@GetMapping("/update")
	public String displayEmpUpdateForm(@RequestParam("id") long id, Model model) {
		Employee emp = empRepo.findByEmpId(id);
		model.addAttribute("employee", emp);
		return "Employee/newemployee";
	}
	
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("id") long id) {
		empRepo.deleteById(id);
		return "redirect:/employees";
	}

}
