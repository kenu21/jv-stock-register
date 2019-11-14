package com.smida.stockregister.service;

import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.Stock;

public interface StockService {
    Stock saveStock(Stock stock);

    Stock updateById(Long stockId, StockDto stockDto);
}
