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
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping
	public String projList(Model model) {
		List<Project> projects = (List<Project>) proRepo.findAll();
		model.addAttribute("projList", projects);
		return "Project/projectlist";
	}

	@GetMapping("/new")
	public String newProj(Model model) {
		Project proj = new Project();
		List<Employee> employees = (List<Employee>) empRepo.findAll();
		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", proj);
		return "Project/newproject";
	}

	@PostMapping("/save")
	public String saveEmp(@Valid Project proj, Errors error) {
		if(error.hasErrors()) {
			return "Project/newproject";
		}
		proRepo.save(proj);
		return "redirect:/projects";

	}

	@GetMapping("/update")
	public String displayEmpUpdateForm(@RequestParam("id") long id, Model model) {
		Project proj = proRepo.findByProjId(id);
		model.addAttribute("project", proj);
		return "Project/newproject";
	}

	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("id") long id) {
		proRepo.deleteById(id);
		return "redirect:/projects";
	}
}
