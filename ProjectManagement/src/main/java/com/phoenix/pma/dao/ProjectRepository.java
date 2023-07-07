package com.phoenix.pma.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phoenix.pma.dto.ProjectEmployee;
import com.phoenix.pma.dto.StagesCount;
import com.phoenix.pma.dto.projectTimes;
import com.phoenix.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel = "apiprojects", path = "apiprojects")
public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Query(nativeQuery = true, value = "select p.name as ename, count(pe.emp_id )  as employeeCount "
			+ "from project p left join project_employee pe "
			+ "on pe.proj_id=p.proj_id group by p.name order by 2 desc")
	public List<ProjectEmployee> projectEmployees();

	Iterable<Project> findAll(Sort sort);

	Page<Project> findAll(Pageable pageable);

	public Project findByProjId(long id);

	@Query(nativeQuery = true, value = "select stage, count(stage) as count from project group by stage")
	public List<StagesCount> stgcnt();

	@Query(nativeQuery = true, value = "select name as projectName, start_date as startDate, end_date as endDate from project")
	public List<projectTimes> timeline();

}
