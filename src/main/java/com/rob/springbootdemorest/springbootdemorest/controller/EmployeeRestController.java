package com.rob.springbootdemorest.springbootdemorest.controller;

import com.rob.springbootdemorest.springbootdemorest.entity.Employee;
import com.rob.springbootdemorest.springbootdemorest.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeServiceImp employeeService;

    @Autowired
    public EmployeeRestController(EmployeeServiceImp theEmployeeService){
        employeeService = theEmployeeService;
    }
 /*
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>>list(){
        List<Employee> listEmployees = employeeService.findAll();
        return new ResponseEntity<>(listEmployees, HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        return new ResponseEntity<>(theEmployee, HttpStatus.OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<Employee>  save(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return new ResponseEntity<>(theEmployee, HttpStatus.CREATED);
    }
    @PutMapping("/employees")
    public ResponseEntity<Employee>  updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return new ResponseEntity<>(theEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") int empId) {

        Employee tempEmployee = employeeService.findById(empId);

        // throw exception if null

        if(tempEmployee == null) {
            throw new RuntimeException("Employee id not found - "+ empId);
        }
        employeeService.deleteById(empId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    */
    @GetMapping("/employees")
    public List<Employee> list(){
        List<Employee> listEmployees;
        listEmployees = employeeService.findAll();
        return listEmployees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);//
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){

        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int empId) {

        Employee tempEmployee = employeeService.findById(empId);

        // throw exception if null

        if(tempEmployee == null) {
            throw new RuntimeException("Employee id not found - "+ empId);
        }

        employeeService.deleteById(empId);

        return "Deleted employee id - " + empId;
    }


}
