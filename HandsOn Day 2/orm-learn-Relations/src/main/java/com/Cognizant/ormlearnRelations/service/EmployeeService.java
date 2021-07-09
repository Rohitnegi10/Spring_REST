package com.Cognizant.ormlearnRelations.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.Cognizant.ormlearnRelations.model.Employee;
import com.Cognizant.ormlearnRelations.repository.EmployeeRepository;



@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");
		return employeeRepository.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");

	}
	@Transactional
	public List<Employee> getAllPermanentEmployees()
	{
		return employeeRepository.getAllPermanentEmployees();
	}
	public BigDecimal getAverageSalary()
	{
		return employeeRepository.getAverageSalary();
	}
	public List<Employee> getAllEmployeesNative()
	{
		return employeeRepository.getAllEmployeesNative();
	}
	public List<Employee> getAllEmployees()
	{
		ApplicationContext cxt = new ClassPathXmlApplicationContext("employee.xml");
		List<Employee> employeeList = (List<Employee>)cxt.getBean("employeeList");
		return employeeList;
	}
	
	
}
