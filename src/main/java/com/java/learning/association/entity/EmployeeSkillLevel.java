package com.java.learning.association.entity;

import com.java.learning.association.enums.SkillLevel;
import com.java.learning.association.model.EmployeeSkillKey;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_skill_mapping")
public class EmployeeSkillLevel {
    @EmbeddedId
    private EmployeeSkillKey id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Enumerated(EnumType.STRING)
    private SkillLevel level;
}
