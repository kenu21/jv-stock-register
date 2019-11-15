package com.smida.stockregister.service;

import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.Stock;

import java.util.List;

public interface StockService {
    Stock saveStock(Stock stock);

    Stock updateById(Long stockId, StockDto stockDto);

    List<Stock> getPublicData();

    List<Stock> getPrivateData();
}
