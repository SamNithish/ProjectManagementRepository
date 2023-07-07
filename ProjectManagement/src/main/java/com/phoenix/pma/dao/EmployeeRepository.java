package com.phoenix.pma.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phoenix.pma.dto.EmployeeProject;
import com.phoenix.pma.entities.Employee;

@RepositoryRestResource(collectionResourceRel = "apiemployees", path = "apiemployees")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query(nativeQuery = true, value = "select e.name as name, count(pe.emp_id )  as projectCount "
			+ "from employee e left join project_employee pe "
			+ "on pe.emp_id =e.emp_id group by e.name order by 2 desc")
	public List<EmployeeProject> employeeProjects();

	public Employee findByEmail(String value);

	Iterable<Employee> findAll(Sort sort);

	Page<Employee> findAll(Pageable pageable);

	// method name should be like property same in the entity .. haaan yes .. spring
	// is Smart enough Dood !
	public Employee findByEmpId(long id);

}
