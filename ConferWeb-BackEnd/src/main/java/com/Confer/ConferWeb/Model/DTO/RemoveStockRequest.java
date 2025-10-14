package com.Confer.ConferWeb.Model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveStockRequest {
    private StockDTO stockDTO;
    private Integer quantity;
}
