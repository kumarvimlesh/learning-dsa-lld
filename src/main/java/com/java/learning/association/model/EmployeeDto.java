package com.java.learning.association.model;

import com.java.learning.association.entity.Skill;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {
    private String name;
    private String email;
    List<SkillDto> skills;
}
