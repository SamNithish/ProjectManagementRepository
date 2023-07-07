package com.phoenix.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoenix.pma.dao.EmployeeRepository;
import com.phoenix.pma.dao.ProjectRepository;
import com.phoenix.pma.dto.EmployeeProject;
import com.phoenix.pma.dto.ProjectEmployee;
import com.phoenix.pma.dto.StagesCount;
import com.phoenix.pma.entities.Employee;
import com.phoenix.pma.entities.Project;
import com.phoenix.pma.springExample.Cars;

@Controller
public class HomeController {

	@Value("${hey}")
	private String ver;
 
	@Autowired
	Cars car;

	/**
	 * there are three types of injection 1. field injection 2. Constructor
	 * injection 3. setter injection
	 */

	// Field injection (definitely need the @Autowired annotation)
	@Autowired
	EmployeeRepository empRepo;

//	//Constructor Injection (this does'nt need @Autowired Annotation)
//	EmployeeRepository empRepo;
//	public HomeController(EmployeeRepository empRepo) {
//		this.empRepo=empRepo;
//	}

//	//Setter Injection (It does need @Autowired Annotation)
//	EmployeeRepository empRepo;
//	@Autowired
//	public void setEmpRepo(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}

	@Autowired
	ProjectRepository proRepo;
	
	@RequestMapping("/")
	public String mainDood() {
		return "main";
	}

	@RequestMapping("/home")
	public String homePage(Model model) throws JsonProcessingException {

//		Map<String, Object> map = new HashMap<>();

		// we are querying the database for employees
		List<Employee> employees = (List<Employee>) empRepo.findAll();
		model.addAttribute("empList", employees);

		// we are querying the database for projects
		List<Project> projects = (List<Project>) proRepo.findAll();
		model.addAttribute("projList", projects);

		// we are querying the database for employee's project count
		List<EmployeeProject> empProj = empRepo.employeeProjects();
		model.addAttribute("empprojs", empProj);

		// we are querying the database for project's employee count
		List<ProjectEmployee> projEmp = proRepo.projectEmployees();
		model.addAttribute("projemps", projEmp);

		// we are querying the database for Stages
		List<StagesCount> projectData = proRepo.stgcnt();
		model.addAttribute("sc", projectData);

		// lets convert projectData object into a jSon Structure to use in javaScript
		ObjectMapper objectmapper = new ObjectMapper();
		String jsonString = objectmapper.writeValueAsString(projectData);
		// Should look like [["NOTSTARTED",1],["INPROGRESS",2],["COMPLETED",1]]
		model.addAttribute("stages", jsonString);

		model.addAttribute("www", ver);

		return "Home/home";
	}

}