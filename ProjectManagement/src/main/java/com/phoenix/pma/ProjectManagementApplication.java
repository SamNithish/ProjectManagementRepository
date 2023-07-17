package com.phoenix.pma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.phoenix.pma", "com.phoenix.utils" })
public class ProjectManagementApplication {

//	@Autowired
//	EmployeeRepository empRepo;
//	@Autowired
//	ProjectRepository proRepo;


	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner() {
//
//		return args -> {
//			Employee emp1 = new Employee("John", "warton@gmail.com");
//			Employee emp2 = new Employee("Mike", "lanister@gmail.com");
//			Employee emp3 = new Employee("Steve", "Reeves@gmail.com");
//
//			Employee emp4 = new Employee("Ronald", "connor@gmail.com");
//			Employee emp5 = new Employee("Jim", "Sal@gmail.com");
//			Employee emp6 = new Employee("Peter", "henley@gmail.com");
//
//			Employee emp7 = new Employee("Richard", "carson@gmail.com");
//			Employee emp8 = new Employee("Honor", "miles@gmail.com");
//			Employee emp9 = new Employee("Tony", "roggers@gmail.com");
//
//			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED");
//			Project pro2 = new Project("New Employee Budget", "COMPLETED");
//			Project pro3 = new Project("Office Reconstruction", "INPROGRESS");
//			Project pro4 = new Project("Improve Intranet Security", "INPROGRESS");
//
//			pro1.addEmployee(emp1);
//			pro1.addEmployee(emp2);
//			pro2.addEmployee(emp3);
//			pro3.addEmployee(emp1);
//			pro4.addEmployee(emp1);
//			pro4.addEmployee(emp3);
//
//			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
//			emp2.setProjects(Arrays.asList(pro1));
//			emp3.setProjects(Arrays.asList(pro2, pro4));
//
//			empRepo.save(emp1);
//			empRepo.save(emp2);
//			empRepo.save(emp3);
//			empRepo.save(emp4);
//			empRepo.save(emp5);
//			empRepo.save(emp6);
//			empRepo.save(emp7);
//			empRepo.save(emp8);
//			empRepo.save(emp9);
//			proRepo.save(pro1);
//			proRepo.save(pro2);
//			proRepo.save(pro3);
//			proRepo.save(pro4);
//
//		};
//	}

}
