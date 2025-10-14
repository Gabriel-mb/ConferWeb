package com.Confer.ConferWeb.Services;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import com.Confer.ConferWeb.Model.DTO.EmployeeDTO;
import com.Confer.ConferWeb.Model.Entity.Employee;
import com.Confer.ConferWeb.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    public EmployeeDTO readId(Integer id) {
        Optional<EmployeeDTO> result = employeeRepository.findDtoById(id);

        return result.orElse(null);
    }

    @Transactional
    public void updateName(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void delete(EmployeeDTO employee) {
        employeeRepository.deleteById(employee.getEmployeeId());
    }

    public List<EmployeeDTO> listEmployees() {
        return employeeRepository.findAllAsDto();
    }

    @Transactional
    public void deleteByIdList(List<Integer> ids) {
        employeeRepository.deleteByIdList(ids);
    }
}

