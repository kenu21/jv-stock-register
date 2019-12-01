package com.smida.stockregister.controller;

import com.smida.stockregister.dto.PrivateDataStockResponseDto;
import com.smida.stockregister.dto.PublicDataStockResponseDto;
import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.Stock;
import com.smida.stockregister.service.StockService;
import com.smida.stockregister.util.Convert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/add")
    public void create(@RequestBody StockDto stockDto) {
        stockService.saveStock(Convert.convertStockDtoToStock(stockDto));
    }

    @PutMapping("/{StockId}")
    public void update(@PathVariable("StockId") Long stockId, @RequestBody StockDto stockDto) {
        stockService.updateById(stockId, stockDto);
    }

    @GetMapping("/getPublicData")
    public List<PublicDataStockResponseDto> getPublicData(
            @RequestParam(value = "page", required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "limit", required = false,
                    defaultValue = "10") Integer limit,
            @RequestParam(value = "sortBy", required = false,
                    defaultValue = "id") String sortBy,
            @RequestParam(value = "sortOrder", required = false,
                    defaultValue = "asc") String sortOrder) {
        return Convert.convertStockToPublicStock(getAll(page, limit, sortBy, sortOrder));
    }

    @GetMapping("/getPrivateData")
    public List<PrivateDataStockResponseDto> getPrivateData(
            @RequestParam(value = "page", required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "limit", required = false,
                    defaultValue = "10") Integer limit,
            @RequestParam(value = "sortBy", required = false,
                    defaultValue = "id") String sortBy,
            @RequestParam(value = "sortOrder", required = false,
                    defaultValue = "asc") String sortOrder) {
        return Convert.convertStockToPrivateStock(getAll(page, limit, sortBy, sortOrder));
    }

    @GetMapping("/getPrivateDataByEdrpou")
    public List<PrivateDataStockResponseDto> getPrivateDataByEdrpou(
            @PathVariable("edrpou") Integer edrpou) {
        return Convert.convertStockToPrivateStock(stockService.findAllByEdrpou(edrpou));
    }

    @GetMapping("/getPublicDataByEdrpou")
    public List<PublicDataStockResponseDto> getPublicDataByEdrpou(
            @PathVariable("edrpou") Integer edrpou) {
        return Convert.convertStockToPublicStock(stockService.findAllByEdrpou(edrpou));
    }

    private List<Stock> getAll(Integer page, Integer limit, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(direction, sortBy));
        return stockService.getAll(pageRequest);
    }
}
