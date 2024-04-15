package com.centroxy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centroxy.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
