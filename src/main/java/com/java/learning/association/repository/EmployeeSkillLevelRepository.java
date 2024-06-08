package com.java.learning.association.repository;

import com.java.learning.association.entity.EmployeeSkillLevel;
import com.java.learning.association.model.EmployeeSkillKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSkillLevelRepository extends JpaRepository<EmployeeSkillLevel, EmployeeSkillKey> {
}
