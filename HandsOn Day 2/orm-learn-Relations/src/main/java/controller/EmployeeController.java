package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Cognizant.ormlearnRelations.model.Employee;
import com.Cognizant.ormlearnRelations.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployees();
	}
	@GetMapping("/")
	@ResponseBody
	public String home()
	{
		return "Home Works";
	}
}
