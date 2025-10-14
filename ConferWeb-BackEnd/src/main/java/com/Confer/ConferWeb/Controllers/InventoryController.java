package com.Confer.ConferWeb.Controllers;

import com.Confer.ConferWeb.Model.DTO.EquipmentDTO;
import com.Confer.ConferWeb.Model.Entity.Equipment;
import com.Confer.ConferWeb.Services.EquipmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private EquipmentsService equipmentsService;

    @GetMapping
    public ResponseEntity<List<EquipmentDTO>> getEquipmentList() {
        try {
            return ResponseEntity.ok(equipmentsService.listEquipmentsStatus());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addOrUpdateEquipment(@RequestBody Equipment equipment) {
        try {
            equipmentsService.create(equipment);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> removeEquipment(@RequestBody EquipmentDTO equipment) {
        try {
            equipmentsService.delete(equipment.getIdEquipment(), equipment.getSupplierId());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}