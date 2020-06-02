package com.chahatg.day12;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*2.) Create an insurance policy checker app where if the customer enters his policy 
 * number should fetch all related information like policy duration, terms completed, 
 * maturity date etc.. use any database for records saving, and retrieval*/


public class PolicyCheck {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your 6 digit policy number: ");
		Integer policyNo = in.nextInt();
		//max policy start year = 10 years back
		//
		LocalDate startDate = LocalDate.now().minusYears((int)(0 + Math.random()*(10-0) + 1)).minusMonths((int) (0 + Math.random()*(11-0)+1)).plusDays((int) (0 + Math.random()*(30-0)+1));
		Integer duration = (int) ( 5 + Math.random()*(10 - 5) + 1);
		LocalDate maturityDate = startDate.plusYears(duration).minusDays(1);
		Integer completedTerms = (int) (0 + Math.random()*(duration - 0 ) + 1);
		
		System.out.println("Policy start date: " + startDate.format(DateTimeFormatter.ISO_DATE));
		System.out.println("Duration: " + duration);
		System.out.println("Policy maturity date: " + maturityDate.format(DateTimeFormatter.ISO_DATE));
		System.out.println("Terms completed: " + completedTerms);

	}
}
