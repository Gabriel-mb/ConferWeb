package com.Confer.ConferWeb.Controllers;

import com.Confer.ConferWeb.Model.DTO.BorrowedDTO;
import com.Confer.ConferWeb.Model.DTO.EmployeeDTO;
import com.Confer.ConferWeb.Model.DTO.EquipmentDTO;
import com.Confer.ConferWeb.Services.BorrowedService;
import com.Confer.ConferWeb.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/card")
@CrossOrigin("*")
public class CardController {

    private final EmployeeService employeeService;
    private final BorrowedService borrowedService;

    @Autowired
    public CardController(EmployeeService employeeService, BorrowedService borrowedService) {
        this.employeeService = employeeService;
        this.borrowedService = borrowedService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCard(@PathVariable String id) {
        try {
            EmployeeDTO employeeDTO = employeeService.readId(Integer.valueOf(id));
            if (employeeDTO != null) {
                List<BorrowedDTO> borrowedItems = borrowedService.listBorrowed(Integer.valueOf(id));

                Map<String, Object> response = new HashMap<>();
                response.put("employee", employeeDTO);
                response.put("borrowedItems", borrowedItems);

                return ResponseEntity.ok(response);
            }
            throw new Exception("Id Not Found");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<HttpStatus> addBorrowedItem(@RequestBody EquipmentDTO equipmentDTO) {
        try {
            borrowedService.delete(equipmentDTO.getIdEquipment(), equipmentDTO.getSupplierId());
            return ResponseEntity.status(200).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeBorrowedItem(@RequestBody EquipmentDTO equipmentDTO) {
        try {
            borrowedService.delete(equipmentDTO.getIdEquipment(), equipmentDTO.getSupplierId());
            return ResponseEntity.status(200).build();
        } catch (SQLException e) {
           e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }



}