package com.smida.stockregister.service;

import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.HistoryStock;
import com.smida.stockregister.entity.Stock;
import com.smida.stockregister.repository.HistoryStockRepository;
import com.smida.stockregister.repository.StockRepository;
import com.smida.stockregister.util.Convert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Stock> getPublicData() {
        List<Stock> all = stockRepository.findAll();
        for (int i = 0; i < all.size(); i++) {
            all.get(i).setComment(null);
            all.get(i).setDurtyPaid(null);
            all.get(i).setEdrpou(null);
            all.get(i).setSizeOfCapital(null);
            all.get(i).setHistoryStock(null);
        }
        return all;
    }

    @Override
    public List<Stock> getPrivateData() {
        return stockRepository.findAll();
    }

    private Stock getStockById(Long stockId) {
        Stock stock = stockRepository.getOne(stockId);
        return stock;
    }
}
