package com.Confer.ConferWeb.Services;

import com.Confer.ConferWeb.Model.DTO.BorrowedDTO;
import com.Confer.ConferWeb.Model.Entity.Employee;
import com.Confer.ConferWeb.Model.Entity.Equipment;
import com.Confer.ConferWeb.Model.Entity.EquipmentBorrowed;
import com.Confer.ConferWeb.Model.Entity.StockBorrowed;
import com.Confer.ConferWeb.Repository.BorrowedRepository;
import com.Confer.ConferWeb.Repository.EmployeeRepository;
import com.Confer.ConferWeb.Repository.EquipmentRepository;
import com.Confer.ConferWeb.Repository.StockBorrowedRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowedService {

    private final BorrowedRepository borrowedRepository;
    private final EquipmentRepository equipmentRepository;
    private final EmployeeRepository employeeRepository;
    private final StockBorrowedRepository stockBorrowedRepository;

    @Autowired
    public BorrowedService(BorrowedRepository borrowedRepository, EquipmentRepository equipmentRepository, EmployeeRepository employeeRepository, StockBorrowedRepository stockBorrowedRepository) {
        this.borrowedRepository = borrowedRepository;
        this.equipmentRepository = equipmentRepository;
        this.employeeRepository = employeeRepository;
        this.stockBorrowedRepository = stockBorrowedRepository;
    }

    public void create(BorrowedDTO dto) {
        Equipment equipment = equipmentRepository.findById(dto.getIdEquipment())
                .orElseThrow(() -> new EntityNotFoundException("Equipamento não encontrado"));

        if (equipment.getSupplier().getSupplierId() != dto.getSupplierId()) {
            throw new IllegalStateException("Fornecedor não corresponde ao equipamento");
        }

        EquipmentBorrowed newEntry = new EquipmentBorrowed();
        newEntry.setEquipment(equipment);
        newEntry.setEmployee(new Employee(dto.getEmployeeId()));
        newEntry.setDate(dto.getDate());

        borrowedRepository.save(newEntry);
    }

    @Transactional
    public void delete(Integer idEquip, Integer supplierId) throws SQLException {
        borrowedRepository.deleteByEquipmentIdAndSupplierId(idEquip, supplierId);
    }

    public EquipmentBorrowed read(Integer idEquipment, Integer supplierId) {
        Optional<EquipmentBorrowed> result = borrowedRepository.findByIdEquipmentAndSupplierId(idEquipment, supplierId);
        if (result.isPresent()) {
            return result.get();
        }
        throw new RuntimeException();
    }

    public List<BorrowedDTO> listBorrowed(Integer employeeId) {
        return borrowedRepository.findBorrowedDetailsByEmployee(employeeId);
    }

    public Boolean searchBorrowed(Integer idEquipment, Integer supplierId) {
        Optional<EquipmentBorrowed> result = borrowedRepository.findByIdEquipmentAndSupplierId(idEquipment, supplierId);

        return result.isPresent();
    }

    public void create(StockBorrowed stockBorrowed) {
        stockBorrowedRepository.save(stockBorrowed);
    }

}
