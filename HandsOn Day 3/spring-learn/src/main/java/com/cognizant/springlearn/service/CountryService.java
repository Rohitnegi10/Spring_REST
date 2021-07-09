package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry(String code) throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = context.getBean("countryList", java.util.ArrayList.class);
		for (Country c : countries) {
			if (c.getCode().equalsIgnoreCase(code))
				return c;
		}
		throw new CountryNotFoundException();
	}
	
	public Country updateCountry(Country country) throws CountryNotFoundException{
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country old=null;
			try{
				old= (Country)context.getBean(country.getCode().toLowerCase());
			}catch (Exception e) {
				throw new CountryNotFoundException();
			}	
			old.setName(country.getName());
			return old;
			
			}
}
