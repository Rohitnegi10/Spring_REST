package com.Cognizant.ormlearnRelations;

import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Cognizant.ormlearnRelations.model.Department;
import com.Cognizant.ormlearnRelations.model.Employee;
import com.Cognizant.ormlearnRelations.model.Skill;
import com.Cognizant.ormlearnRelations.service.DepartmentService;
import com.Cognizant.ormlearnRelations.service.EmployeeService;
import com.Cognizant.ormlearnRelations.service.SkillService;

@SpringBootApplication
public class OrmLearnRelationsApplication {
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnRelationsApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		// testGetEmployee();
		// testAddEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		// testAddSkillToEmployee();
		// testGetAllPermanentEmployees();
		// testGetAverageSalary();
		//testGetAllEmployeesNative();
	
		
		/*
		 * ApplicationContext cxt = new ClassPathXmlApplicationContext("employee.xml");
		 * List<Employee> employeeList = (List<Employee>)cxt.getBean("employeeList");
		 * LOGGER.info(employeeList.toString());
		 */
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}

	private static void testAddEmployee() {
		Employee employee = new Employee();
		// setting values
		Date date = new Date(100, 01, 27);
		employee.setDateOfBirth(date);
		employee.setName("Rohit");
		employee.setPermanent(true);
		employee.setSalary(new BigDecimal(500000));

		// setting department from employee 1
		Employee employee1 = employeeService.get(1);
		employee.setDepartment(employee1.getDepartment());

		employeeService.save(employee);
	}

	private static void testUpdateEmployee() {
		Employee employee = employeeService.get(2);
		Department department = departmentService.get(3);
		employee.setDepartment(department);
		employeeService.save(employee);
	}

	private static void testGetDepartment() {
		Department department = departmentService.get(3);
		Set<Employee> employees = department.getEmployeeList();
		// System.out.println(employees.toString());

	}

	private static void testAddSkillToEmployee() {
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(3);
		Set<Skill> skillListSet = employee.getSkillList();
		skillListSet.add(skill);
		employeeService.save(employee);
	}

	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}

	public static void testGetAverageSalary() {
		LOGGER.info("Start");
		BigDecimal result = employeeService.getAverageSalary();
		LOGGER.info(result.toString());
		LOGGER.info("End");
	}

	public static void testGetAllEmployeesNative() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllEmployeesNative();
		LOGGER.info("Employees:{}", employees);
		LOGGER.info("End");
	}

}
