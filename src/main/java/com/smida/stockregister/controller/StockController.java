package com.smida.stockregister.controller;

import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.service.StockService;
import com.smida.stockregister.util.ConvertDtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/add")
    public void create(@RequestBody StockDto stockDto) {
        stockService.createStock(ConvertDtoToEntity.convertStockDtoToStock(stockDto));
    }
}
