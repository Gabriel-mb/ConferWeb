package com.Confer.ConferWeb.Services;

import com.Confer.ConferWeb.Model.Entity.Supplier;
import com.Confer.ConferWeb.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void create(Supplier supplier) throws SQLException {
        supplierRepository.save(supplier);
    }

    public Supplier readById(Integer id) throws SQLException {
        Optional<Supplier> result = supplierRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new RuntimeException();
    }

    public void update(Supplier supplier) throws SQLException {
        supplierRepository.save(supplier);
    }

    public void delete(int supplierId) throws SQLException {
        supplierRepository.deleteById(supplierId);
    }

    public List<String> selectSupplier() throws SQLException {
        return supplierRepository.findAllSupplierNames();
    }

    public Integer findIdByName(String name) {
        Integer result = supplierRepository.findSupplierIdBySupplierName(name);
        if (result != null) {
            return result;
        }
        throw new RuntimeException();
    }

}
