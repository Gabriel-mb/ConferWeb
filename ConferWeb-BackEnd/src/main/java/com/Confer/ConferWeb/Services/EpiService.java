package com.Confer.ConferWeb.Services;

import com.Confer.ConferWeb.Model.DTO.EpiDTO;
import com.Confer.ConferWeb.Model.Entity.Employee;
import com.Confer.ConferWeb.Model.Entity.Epi;
import com.Confer.ConferWeb.Model.Entity.EpiBorrowed;
import com.Confer.ConferWeb.Model.Entity.EpiId;
import com.Confer.ConferWeb.Repository.EmployeeRepository;
import com.Confer.ConferWeb.Repository.EpiBorrowedRepository;
import com.Confer.ConferWeb.Repository.EpiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpiService {

    private final EpiRepository epiRepository;
    private final EpiBorrowedRepository epiBorrowedRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EpiService(EpiRepository epiRepository, EpiBorrowedRepository epiBorrowedRepository, EmployeeRepository employeeRepository) {
        this.epiRepository = epiRepository;
        this.epiBorrowedRepository = epiBorrowedRepository;
        this.employeeRepository = employeeRepository;
    }

    public void update(EpiDTO epiDTO) {
        if (epiDTO.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        epiRepository.addToStock(epiDTO.getEpiName(), epiDTO.getNumCa(), epiDTO.getQuantity());
    }

    public void remove(String epiName, Integer numCa, Integer quantity) {
        epiRepository.decreaseStock(epiName, numCa, quantity);
    }


    public List<EpiDTO> listStock() {
        List<Epi> epiList = epiRepository.findAll();

        List<EpiDTO> epiDTOList = epiList.stream()
                .map(epi -> new EpiDTO(
                        epi.getEpiId().getEpiName(),
                        epi.getEpiId().getNumCa(),
                        epi.getQuantity()
                ))
                .collect(Collectors.toList());

         return epiDTOList;
    }

    public List<EpiDTO> episListBorrowed(Integer id) {
        List<EpiBorrowed> epiBorrowedList = epiBorrowedRepository.findByIdEmployee(id);
        List<EpiDTO> epiDTOList = epiBorrowedList.stream()
                .map(epi -> new EpiDTO(
                        epi.getId().getEpiName(),
                        epi.getId().getNumCa(),
                        epi.getQuantity(),
                        epi.getDate(),
                        epi.getEmployee().getIdEmployee()
                ))
                .collect(Collectors.toList());

        return epiDTOList;
    }

    public void updateBorrowedEpi(Integer quantity, Integer numCa, Integer employeeId) {
        epiBorrowedRepository.updateQuantityByNumCaAndIdEmployee(quantity, numCa, employeeId);
    }

    // No EpiService.java

    public void create(EpiDTO epiDTO) {
        EpiBorrowed epiBorrowed = new EpiBorrowed();
        epiBorrowed.setId(new EpiId(epiDTO.getEpiName(), epiDTO.getNumCa()));
        epiBorrowed.setEmployee(new Employee(epiDTO.getEmployeeId()));
        epiBorrowed.setQuantity(epiDTO.getQuantity());
        epiBorrowed.setDate(epiDTO.getDate());

        epiBorrowedRepository.save(epiBorrowed);
    }

    public boolean checkDate(String epiName, Integer numCa, Date date) {
        EpiBorrowed result = epiBorrowedRepository.findByEpiNameNumCaAndDate(epiName, numCa, date);
        return result != null;
    }

    public Epi searchEpi(String epiName, Integer numCa) {
        return epiRepository.searchEpi(epiName, numCa);
    }

    public void removeBorrowed(EpiDTO epiDTO) {
        epiBorrowedRepository.removeBorrowed(
                epiDTO.getEpiName(),
                epiDTO.getNumCa(),
                epiDTO.getDate()
        );
    }

    public void addToStock(String epiName, Integer numCa, Integer quantity) {
        epiRepository.addToStock(epiName, numCa, quantity);
    }
}