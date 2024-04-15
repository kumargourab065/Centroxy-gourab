package com.centroxy.controller;

import com.centroxy.model.Employee;
import com.centroxy.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class LeaveController {

    @Autowired
    private EmployeeRepo empRepo;

    @GetMapping("/employee")
    public String getEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeHR";
    }

    @GetMapping("/hr")
    public String getHr() {
        return "hr";
    }

    @MessageMapping("/sendLeaveRequest")
    @SendTo("/topic/leaveRequest")
    public List<Employee> SendLeaveRequest(Employee employee) {

         empRepo.save(employee);
        List<Employee> allEmployee =  empRepo.findAll();

        return allEmployee;
    }


    @MessageMapping("/approveLeaveRequest/{id}")
    @SendTo("/topic/result/{id}")
    public Employee ApproveLeaveRequest(@DestinationVariable String id, Employee employee) {
        Employee savedEmploye = empRepo.save(employee);

        return savedEmploye;
    }

}
