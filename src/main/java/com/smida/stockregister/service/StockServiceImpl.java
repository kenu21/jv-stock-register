package com.smida.stockregister.service;

import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.HistoryStock;
import com.smida.stockregister.entity.Stock;
import com.smida.stockregister.repository.HistoryStockRepository;
import com.smida.stockregister.repository.StockRepository;
import com.smida.stockregister.util.Convert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private HistoryStockRepository historyStockRepository;

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateById(Long stockId, StockDto stockDto) {
        Stock stock = getStockById(stockId);
        HistoryStock historyStock = Convert.convertStockToHistoryStock(stock);
        stock.setComment(stockDto.getComment());
        stock.setSizeOfCapital(stockDto.getSizeOfCapital());
        stock.setEdrpou(stockDto.getEdrpou());
        stock.setAmount(stockDto.getAmount());
        stock.setPrice(stockDto.getPrice());
        stock.setDurtyPaid(stockDto.getDurtyPaid());
        stock.setReleaseDate(stockDto.getReleaseDate());
        HistoryStock save = historyStockRepository.save(historyStock);
        stock.getHistoryStock().add(save);
        return saveStock(stock);
    }

    @Override
    public List<Stock> getAll(Pageable pageable) {
        return stockRepository.findAll(pageable).getContent();
    }

    private Stock getStockById(Long stockId) {
        Stock stock = stockRepository.getOne(stockId);
        return stock;
    }
}
