package com.softserveinc.edu.oms.domain.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardValidatorNewTest {

	@Test
	public void testIsCardTypeValidVisa() {
		String card = "visa";
		String cardNumber = "4000100020003003";
		assertTrue(CardValidatorNew.isCardTypeValid(card , cardNumber));
	}
	@Test
	public void testIsCardTypeValidMasterCard() {
		String card = "mastercard";
		String cardNumber = "4200100020003003";
		assertTrue(CardValidatorNew.isCardTypeValid(card , cardNumber));
	}
	@Test
	public void testIsCardTypeValidMaestro() {
		String card = "maestro";
		String cardNumber = "4200100020003003";
		assertTrue(CardValidatorNew.isCardTypeValid(card , cardNumber));
	}
	@Test
	public void testIsCardTypeValidAmericanexpress() {
		String card = "americanexpress";
		String cardNumber = "4200100020003003";
		assertTrue(CardValidatorNew.isCardTypeValid(card , cardNumber));
	}
	@Test
	public void testIsCardTypeValidUnknowCard() {
		String card = "abrakadabra";
		String cardNumber = "4200100020003003";
		assertFalse(CardValidatorNew.isCardTypeValid(card , cardNumber));
	}
	@Test
	public void testValidateCardNumber() {
		
		String cardNumber = "4200100020003003";
		assertTrue(CardValidatorNew.ValidateCardNumber(cardNumber));
	}
}
