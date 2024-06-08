package com.java.learning.association.entity;

import com.java.learning.association.enums.SkillCategory;
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
@Table(name = "skills")
public class Skill {
    @Id
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SkillCategory category;

    @ManyToMany
    @JoinTable(name = "employee_skill_mapping",
            joinColumns = @JoinColumn(name = "skill_id"),inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;
}
