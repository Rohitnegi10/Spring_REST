package com.Cognizant.ormlearnRelations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cognizant.ormlearnRelations.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
