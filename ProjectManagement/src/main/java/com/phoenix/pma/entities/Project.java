package com.phoenix.pma.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "project_seq")
	private long projId;

	@NotBlank(message = "Must Include Name")
	@Size(min = 2, max = 69, message = "Name size Should between 2 and 20")
	private String name;
	private String stage;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "projId"), inverseJoinColumns = @JoinColumn(name = "empId"))
	@JsonIgnore
	private List<Employee> employees;

	@NotNull(message = "Must Include Start Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@NotNull(message = "Must Include End Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	public Project(String name, String stage) {
		super();
		this.name = name;
		this.stage = stage;
	}

	public Project() {

	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getProjId() {
		return projId;
	}

	public void setProjId(long projId) {
		this.projId = projId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void addEmployee(Employee emp) {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(emp);
	}

	@Override
	public String toString() {
		return "Project [name=" + name + "]";
	}

}
