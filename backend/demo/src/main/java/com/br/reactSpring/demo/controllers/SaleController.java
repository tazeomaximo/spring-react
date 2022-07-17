package com.br.reactSpring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.reactSpring.demo.entities.Sale;
import com.br.reactSpring.demo.services.SaleService;
import com.br.reactSpring.demo.services.SmsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/sales")
@Slf4j
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(name = "minDate",defaultValue = "") String minDate, 
			@RequestParam(name = "maxDate",defaultValue = "") String maxDate, 
			Pageable pageable){
		return saleService.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void findSales(@RequestBody Sale sale){
		log.info("Sale={}",sale);
	}

}
