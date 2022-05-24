package com.rob.springbootdemorest.springbootdemorest.dao;

import com.rob.springbootdemorest.springbootdemorest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{

}
