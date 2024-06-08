package com.java.learning.association.model;

import com.java.learning.association.enums.SkillCategory;
import com.java.learning.association.enums.SkillLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class SkillDto {
    private String name;

    @Enumerated(EnumType.STRING)
    private SkillCategory category;

    @Enumerated(EnumType.STRING)
    private SkillLevel level;
}
