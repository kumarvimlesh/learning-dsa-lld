package com.java.learning.association.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    private String name;
    private String email;

    /**
     * This example illustrate the Many-to-Many Mapping between Employee and Skill Entity
     * One Employee can have multiple Skills and There can be multiple Employees with same Skill
     * To keep the references from both these tables we would require an additional join table
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_skill_mapping",
            joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<EmployeeSkillLevel> level;
}
