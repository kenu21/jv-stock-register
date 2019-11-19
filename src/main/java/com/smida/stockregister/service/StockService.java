package com.smida.stockregister.service;

import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.Stock;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface StockService {
    Stock saveStock(Stock stock);

    Stock updateById(Long stockId, StockDto stockDto);

    List<Stock> getAll(Pageable pageable);
}
