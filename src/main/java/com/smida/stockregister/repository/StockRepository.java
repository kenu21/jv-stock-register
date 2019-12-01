package com.smida.stockregister.repository;

import com.smida.stockregister.entity.Stock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findAllByEdrpou(Integer edrpou);
}
