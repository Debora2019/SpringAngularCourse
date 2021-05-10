package tech.project.employeemanage.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.project.employeemanage.model.Employee;
import tech.project.employeemanage.repo.EmployeeRepo;
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo; 

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee (Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployess (){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee (Employee employee){
        Employee existingEmployee = employeeRepo.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setEmployeeCode(employee.getEmployeeCode());
        existingEmployee.setImageUrl(employee.getImageUrl());
        existingEmployee.setJobTitle(employee.getJobTitle());
        existingEmployee.setPhone(employee.getPhone());
        return employeeRepo.save(existingEmployee);


    }
}
