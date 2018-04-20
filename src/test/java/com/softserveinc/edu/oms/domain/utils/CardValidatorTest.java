package com.softserveinc.edu.oms.domain.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardValidatorTest {

	
	
	@Test
	public void testIsCardTypeValidVisa() {
	
		String card = "visa";
		String cardNumber = "4001000200030004";
		assertTrue(CardValidator.isCardTypeValid(card , cardNumber));
		
	}
	@Test
	public void testIsCardTypeValidMaestro() {

		String card = "maestro";
		String cardNumber = "5001000200030004";
		assertTrue(CardValidator.isCardTypeValid(card , cardNumber));
		
	}
	@Test
	public void testIsCardTypeValidAmericanexpress() {

		String card = "americanexpress";
		String cardNumber = "3401000200030004";
		assertTrue(CardValidator.isCardTypeValid(card , cardNumber));
		
	}
	// 4001000200030005 should retunr False.
	@Test
	public void testIsCardNumberValid() {
		
		String cardNumber = "4001000200030001";
		assertFalse(CardValidator.isCardNumberValid(cardNumber));
	
	}
	
	@Test
	public void testIsExpireDateValid() {
	
		String expireMonth= "09";
		String expireYear = "16";
		assertTrue(CardValidator.isExpireDateValid(expireMonth, expireYear));
	
	}

}
