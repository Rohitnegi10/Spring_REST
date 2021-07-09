package controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Cognizant.ormlearnRelations.exception.EmployeeNotFoundException;
import com.Cognizant.ormlearnRelations.model.Employee;
import com.Cognizant.ormlearnRelations.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	private Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
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
	
	@PutMapping("/updateEmployee")
    public void updateEmployee(@Validated @RequestBody Employee employee) throws EmployeeNotFoundException{
        LOGGER.info("START: updateEmployee");
        employeeService.updateEmployee(employee);
        LOGGER.debug("Employee = {}", employee);
        LOGGER.info("END; updateEmployee");
    }

    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(@Validated @RequestBody Employee employee) throws EmployeeNotFoundException{
        LOGGER.info("START: deleteEmployee");
        employeeService.deleteEmployee(employee);
        LOGGER.debug("Employee = {}", employee);
        LOGGER.info("END; deleteemployee");
    }
}
