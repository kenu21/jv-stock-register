package com.smida.stockregister.repository;

import com.smida.stockregister.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {}
