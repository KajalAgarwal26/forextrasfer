package com.hcl.ing.forextransfer.service;

import org.springframework.stereotype.Service;

import com.hcl.ing.forextransfer.dto.CurrencyDto;

/**
 * Currency service to hanlde currency conversion API.
 */
@Service
public interface CurrencyService {

	public CurrencyDto getConvertedCurrency(String fromCurrency, String toCurrency, Double fromAmount);
}
