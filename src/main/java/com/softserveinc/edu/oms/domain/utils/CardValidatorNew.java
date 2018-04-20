package com.softserveinc.edu.oms.domain.utils;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Arrays;
import java.util.List;
public class CardValidatorNew {
	
	// private constructor so that Hudson won't complain
	private CardValidatorNew() { }
	
	// check whether or not the card type is valid 
	public static boolean isCardTypeValid(String card, String cardNumber) {
		
		String cardType = card.toLowerCase();
		String[] cardTypes  = {"visa", "mastercard", "americanexpress", "maestro"};
		Arrays.sort(cardTypes);
		List<Integer> firstDigits =  Arrays.asList(3,4,5,6);
		List<Integer> secondDigits = Arrays.asList(0,1,2,3,4,5,6,7);
		int firstDigit = Integer.parseInt(String.valueOf(cardNumber.charAt(0)));
		int secondDigit = Integer.parseInt(String.valueOf(cardNumber.charAt(1)));
		if ( ((Arrays.binarySearch(cardTypes,cardType)) >=0 ) && ( cardNumber.length() == 16) )
			 if ( (firstDigits.contains(firstDigit)) && (secondDigits.contains(secondDigit)) )
				 return true;	 
		return false;
	}
	// Lunh alg
	//
	public static boolean ValidateCardNumber(String cardNumber) {
		return lunh(cardNumber) == 0;
	}
	
	public static int lunh(String cardNumber ) {
		int sum = 0;
		boolean isDouble = true;
		for (int i = cardNumber.length() - 1; i >= 0; i--) {
			int j = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
			sum += sumDigits((j * (isDouble ? 2 : 1)));
			isDouble = !isDouble;
		}
		return ( sum % 10) ;
	}
	private static int sumDigits(int k) {
		if (k < 10)
			return k;
		return sumDigits(k / 10) + (k % 10);
	}
	/////
	// check if expire date has not passed
	public static boolean isExpireDateValid(String expireMonth, 
					String expireYear) {
		int oneHundred = 100;
		
		Calendar calendar = new GregorianCalendar();
		Date time = new Date();
		calendar.setTime(time);
		
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		int currentYear = calendar.get(Calendar.YEAR) % oneHundred;
		
		int expireMonthInt = Integer.parseInt(expireMonth);
		int expireYearInt = Integer.parseInt(expireYear);
		
		
		if (currentYear > expireYearInt) {
			return false;
		}
		else if (currentYear == expireYearInt) {
			if (currentMonth > expireMonthInt) {
				return false;
			}
		}
		
		return true;
	}
}
