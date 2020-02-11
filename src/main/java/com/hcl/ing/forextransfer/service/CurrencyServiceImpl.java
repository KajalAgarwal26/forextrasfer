package com.hcl.ing.forextransfer.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.ing.forextransfer.dto.CurrencyDto;
import com.hcl.ing.forextransfer.helper.ExchangeRates;

/**
 * Currency service to handle currency conversion implementation.
*/
@Service
public class CurrencyServiceImpl implements CurrencyService {

	Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);
	
	@Autowired(required=true)
	RestTemplate restTemplate;

	/**
	 * Service method to get the converted currency, It returns converted currency amount and charges. 
	 */
	@Override
	public CurrencyDto getConvertedCurrency(String fromCurrency, String toCurrency, Double fromAmount) {
		
		logger.debug("Inside CurrencyServiceImpl :: getConvertedCurrency");
		
		//get latest currency values from external API.
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ExchangeRates exc = restTemplate.exchange("https://api.exchangeratesapi.io/latest?base=" + fromCurrency,
				HttpMethod.GET, entity, ExchangeRates.class).getBody();
		Double unitPrice = exc.getRates().get(toCurrency);
		
		//set converted amount.
		CurrencyDto currencyDto = new CurrencyDto();
		currencyDto.setCharges((fromAmount * 1.5)/100);
		currencyDto.setConvertAmount(unitPrice * fromAmount);
		return currencyDto;
	}
}
