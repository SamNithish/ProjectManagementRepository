package com.phoenix.pma.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phoenix.pma.validations.UniqueValue;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "employee_seq")
	private long empId;

	@NotBlank(message = "Must Include Name")
	@Size(min = 2, max = 20, message = "Name size Should between 2 and 20")
	private String name;

	@NotBlank(message = "Must Include Email")
	@Email(message = "*Must be a valid email address")
	@UniqueValue
	private String email;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "empId"), inverseJoinColumns = @JoinColumn(name = "projId"))
	@JsonIgnore
	private List<Project> projects;

	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Employee() {
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

}
