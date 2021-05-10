package tech.project.employeemanage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.project.employeemanage.model.Employee;

public interface EmployeeRepo extends JpaRepository <Employee, Long> {
    
}
