package com.phoenix.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.pma.dao.ProjectRepository;
import com.phoenix.pma.dto.ProjectEmployee;
import com.phoenix.pma.entities.Project;

@Service
public class ProjectServiceClass {
	
	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project emp) {
		return proRepo.save(emp);
	}

	public List<Project> findAll() {
		return (List<Project>) proRepo.findAll();
	}

	public List<ProjectEmployee> projectEmployees() {
		return proRepo.projectEmployees();
	}

}
