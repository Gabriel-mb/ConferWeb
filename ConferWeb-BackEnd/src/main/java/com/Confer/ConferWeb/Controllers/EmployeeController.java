package com.Confer.ConferWeb.Controllers;

import com.Confer.ConferWeb.Model.DTO.EmployeeDTO;
import com.Confer.ConferWeb.Model.Entity.Employee;
import com.Confer.ConferWeb.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployeeList() {
        try {
            return ResponseEntity.ok(employeeService.listEmployees());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> removeEmployee(@RequestBody List<Integer> employeeIds) {
        try {
            if (employeeIds.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            employeeService.deleteByIdList(employeeIds);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addOrUpdateEmployee(@RequestBody Employee employee) {
        try {
            if (employee == null) {
                return ResponseEntity.badRequest().build();
            }

            employeeService.create(employee);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}