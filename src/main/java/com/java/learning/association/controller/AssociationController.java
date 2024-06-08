package com.java.learning.association.controller;

import com.java.learning.association.entity.Employee;
import com.java.learning.association.entity.EmployeeSkillLevel;
import com.java.learning.association.entity.Skill;
import com.java.learning.association.model.EmployeeDto;
import com.java.learning.association.repository.EmployeeRepository;
import com.java.learning.association.repository.EmployeeSkillLevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/associations")
public class AssociationController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeSkillLevelRepository employeeSkillLevelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto){
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        Employee savedEmp = employeeRepository.save(employee);
        List<EmployeeSkillLevel> empSkillsLevel = employee.getSkills().stream().map(skill->{
            EmployeeSkillLevel employeeSkillLevel = new EmployeeSkillLevel();
            employeeSkillLevel.setEmployee(employee);
            employeeSkillLevel.setSkill(skill);
            employeeSkillLevel.setLevel(employeeDto.getSkills().stream().filter(r->r.getName().equals(skill.getName())).findFirst().get().getLevel());
            return employeeSkillLevel;
        }).collect(Collectors.toList());
        employeeSkillLevelRepository.saveAll(empSkillsLevel);
        return savedEmp;
    }

    @GetMapping("/employee")
    public List<EmployeeDto> getAllEmployee(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream().map(r -> modelMapper.map(r,EmployeeDto.class)).collect(Collectors.toList());
        return employeeDtos;
    }
}
