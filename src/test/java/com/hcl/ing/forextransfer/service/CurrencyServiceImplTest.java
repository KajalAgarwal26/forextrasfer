package com.hcl.ing.forextransfer.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.hcl.ing.forextransfer.dto.CurrencyDto;
import com.hcl.ing.forextransfer.helper.ExchangeRates;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CurrencyServiceImplTest {
	
	@InjectMocks
	CurrencyServiceImpl currencyServiceImpl;
	
	@Mock
	RestTemplate restTemplate;
	
	String fromCurrency = "INR";
	String toCurrency = "USD";
	Double fromAmount = 100000.00;
	CurrencyDto currencyDto = new CurrencyDto();
	ExchangeRates rates = new ExchangeRates();
	HttpEntity<String> entity = null;
	
	@Before
	public void setUp() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		entity = new HttpEntity<>(headers);
		currencyDto.setCharges(140.00);
		currencyDto.setConvertAmount(280.00);
		
		Map<String, Double> rate = new HashMap<String, Double>();
		rate.put("USD", 1.01);
		rates.setRates(rate);
	}	
	
	@Test
	public void getConvertedCurrencyTest() {
		Mockito.when(restTemplate.exchange("https://api.exchangeratesapi.io/latest?base=" + fromCurrency, HttpMethod.GET, entity, ExchangeRates.class).getBody())
		.thenReturn(rates);
		currencyServiceImpl.getConvertedCurrency(fromCurrency, toCurrency, fromAmount);
	}	
}
