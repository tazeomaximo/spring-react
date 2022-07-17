package com.br.reactSpring.demo.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.reactSpring.demo.entities.Sale;
import com.br.reactSpring.demo.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals(Strings.EMPTY) ? today.minusDays(365) :  LocalDate.parse(minDate);
		LocalDate max = maxDate.equals(Strings.EMPTY) ? today :  LocalDate.parse(maxDate);
		
		return saleRepository.findSales(min, max, pageable);
	}

}
