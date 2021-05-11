package tech.project.employeemanage;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.project.employeemanage.model.Employee;
import tech.project.employeemanage.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    //constructor
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //ok
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployess();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    //ok
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
      Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    //ok
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee) {
       Employee newEmployee = employeeService.addEmployee(employee); 
       return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    //ok
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee) {
       Employee updateEmployee = employeeService.updateEmployee(employee); 
       return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    //ok
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
       employeeService.deleteEmployee(id); 
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
