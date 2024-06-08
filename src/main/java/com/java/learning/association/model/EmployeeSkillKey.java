package com.java.learning.association.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EmployeeSkillKey implements Serializable {
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "skill_id")
    private String skillId;
}
