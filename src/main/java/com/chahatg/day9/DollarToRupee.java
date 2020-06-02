package com.chahatg.day9;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*3.) Write a java application to convert currency from dollar to rupee,
 *  with loggers of all levels having logs written in console and file*/

public class DollarToRupee {
	public static final Logger LOGGER = Logger.getLogger(DollarToRupee.class.getName());
	public static void main(String[] args){
		LOGGER.entering(DollarToRupee.class.getName(), "main");
		LOGGER.info("Logger name:" + LOGGER.getName());
		List<String> currencies = Arrays.asList("$23.0", "€90.0", "$46.99", "£7", "¥100.50", "¥150.12", "£2.99", "$9.99", "€3.50","$120");
		System.out.println(currencies);
		String regex = "\\$\\d+(?:\\.\\d+)?";
		Pattern p = Pattern.compile(regex);
		LOGGER.warning("Entering loop: could throw out of bounds exception"); //i know it wont but i am
																				//making things up to use all 
																			//logger levels
		for(int i = 0; i < currencies.size(); i++) {
			Matcher m = p.matcher(currencies.get(i));
			
			if(m.matches())  {
				LOGGER.config("Currency "+ currencies.get(i) + " will change to ₹");
				currencies.set(i,"₹"+ currencies.get(i).substring(1));
				if(p.matcher(currencies.get(i)).matches()) {
					LOGGER.severe("Currency did not update for some reason");
				}
			}
			
		}
		
		System.out.println(currencies);
	}
}
