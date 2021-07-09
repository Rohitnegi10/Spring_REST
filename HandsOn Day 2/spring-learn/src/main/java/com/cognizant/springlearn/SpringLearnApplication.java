package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class); 
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
	
		//displayDate();
		//displayCountry();
	}
	
	
	public static void displayCountry() {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>)cxt.getBean("countryList");
		LOGGER.info(countries.toString());
		
		/*
		 * Country country = (Country)cxt.getBean("country",Country.class); Country
		 * anotherCountry = (Country)cxt.getBean("country",Country.class);
		 * LOGGER.debug("Country : {}", country.toString());
		 */
		
	}
	
	public static void displayDate() {
		LOGGER.info("START");
		ApplicationContext cxt = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = cxt.getBean("dateFormat", SimpleDateFormat.class);
		
		String dateString = "31/12/2018";
		
		try {
			Date date = format.parse(dateString);
			System.out.println("Parsing Successful");
			LOGGER.debug(format.format(date));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured");
		}
		LOGGER.info("end");
	}
}	
