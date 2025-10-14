package com.Confer.ConferWeb.Controllers;

import com.Confer.ConferWeb.Model.DTO.RemoveStockRequest;
import com.Confer.ConferWeb.Model.DTO.StockDTO;
import com.Confer.ConferWeb.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockDTO>> getStock() {
        try {
            return ResponseEntity.ok(stockService.findAllAsDTO());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addStock(@RequestBody StockDTO stockDTO) {
        try {
            stockService.updateOrCreateStock(stockDTO.getEquipmentName(), stockDTO.getSupplierId(), stockDTO.getQuantity());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> removeStock(@RequestBody RemoveStockRequest request) {
        try {
            stockService.removeStock(
                    request.getStockDTO().getEquipmentName(),
                    request.getStockDTO().getSupplierId(),
                    request.getQuantity()
            );
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}