package com.smida.stockregister.repository;

import com.smida.stockregister.entity.HistoryStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryStockRepository extends JpaRepository<HistoryStock, Long> {}
