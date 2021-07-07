package com.Cognizant.ormlearnRelations.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Cognizant.ormlearnRelations.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// @Query(value = "SELECT e FROM Employee e WHERE e.permanent = 1")
	// @Query(value="SELECT e FROM Employee e left join e.department d left join
	// e.skillList WHERE e.permanent = 1")
	@Query(value = "SELECT e FROM Employee e left join e.department d left join e.skillList WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();

	@Query(value = "SELECT AVG(e.salary) FROM Employee e")
	BigDecimal getAverageSalary();

	@Query(value = "SELECT * FROM employee", nativeQuery = true)
	List<Employee> getAllEmployeesNative();

}
