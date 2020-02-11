package com.hcl.ing.forextransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.forextransfer.dto.CurrencyDto;
import com.hcl.ing.forextransfer.service.CurrencyService;

@RestController
@RequestMapping("/currency")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CurrencyController {

	@Autowired
	CurrencyService currencyService; 
	
	/**
	 * API to get converted currency for the base currency. 
	 * 
	 * @param fromCurrency		Base currency value.
	 * @param toCurrency		To be converted currency value.
	 * @param fromAmount		Amount to be converted for the to currency value.
	 * @return
	 */
	@GetMapping("/{fromCurrency}/{toCurrency}/{fromAmount}")
	public ResponseEntity<CurrencyDto> getConvertedCurrency(@PathVariable("fromCurrency") String fromCurrency, @PathVariable("toCurrency") String toCurrency, @PathVariable("fromAmount") Double fromAmount) {
		CurrencyDto currencyDto = currencyService.getConvertedCurrency(fromCurrency, toCurrency, fromAmount);
		return ResponseEntity.ok().body(currencyDto);
	}	
}
