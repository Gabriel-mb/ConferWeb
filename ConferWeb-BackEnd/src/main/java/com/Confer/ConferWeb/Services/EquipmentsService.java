package com.Confer.ConferWeb.Services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.Confer.ConferWeb.Model.DTO.EquipmentDTO;
import com.Confer.ConferWeb.Model.Entity.Equipment;
import com.Confer.ConferWeb.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentsService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public EquipmentsService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public void create(Equipment equipment) throws SQLException {
       equipmentRepository.save(equipment);
    }

    public List<EquipmentDTO> listEquipmentsStatus() throws SQLException {
        List<EquipmentDTO> stored = equipmentRepository.findStoredEquipment();
        List<EquipmentDTO> borrowed = equipmentRepository.findBorrowedEquipment();

        List<EquipmentDTO> all = new ArrayList<>();
        all.addAll(stored);
        all.addAll(borrowed);
        all.sort(Comparator.comparing(EquipmentDTO::getIdEquipment));

        return all;
    }

    public List<EquipmentDTO> readId(Integer id) {
        return equipmentRepository.findEquipmentWithSupplierById(id);
    }

    public void delete(Integer idEquip, Integer supplierId) throws SQLException {
        equipmentRepository.deleteByIdEquipmentAndSupplierId(idEquip, supplierId);
    }

    public Boolean searchEquipment(Integer id, Integer supplierId) {
        Optional<Equipment> result = equipmentRepository.findByIdEquipmentAndSupplierId(id, supplierId);

        return result.isPresent();
    }

}
