package com.Cognizant.ormlearnRelations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cognizant.ormlearnRelations.model.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

}
