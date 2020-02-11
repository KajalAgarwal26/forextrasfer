package com.hcl.ing.forextransfer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.forextransfer.dto.CurrencyDto;
import com.hcl.ing.forextransfer.service.CurrencyService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CurrencyControllerTest {
	
	@InjectMocks
	CurrencyController currencyController;
	
	@Mock
	CurrencyService currencyService;
	
	String fromCurrency = "INR";
	String toCurrency = "USD";
	Double fromAmount = 100000.00;
	CurrencyDto currencyDto = new CurrencyDto();
	
	@Before
	public void setUp() {
		currencyDto.setCharges(140.00);
		currencyDto.setConvertAmount(280.00);
	}	
	
	@Test
	public void getConvertedCurrencyTest() {
		Mockito.when(currencyService.getConvertedCurrency(fromCurrency, toCurrency, fromAmount)).thenReturn(currencyDto);
		currencyController.getConvertedCurrency(fromCurrency, toCurrency, fromAmount);
		assertEquals(140, currencyDto.getCharges());
	}
}
