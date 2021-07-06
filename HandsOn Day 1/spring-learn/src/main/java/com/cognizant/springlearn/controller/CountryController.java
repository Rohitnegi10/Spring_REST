package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;


@RestController
public class CountryController {
	
	@GetMapping("/hello")
	@ResponseBody
	public String sayHello()
	{
		return "Hello World!!";
	}
	@GetMapping("/country")
	@ResponseBody
	public Country getCountry()
	{
		ApplicationContext cxt = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country)cxt.getBean("in");
		return country;
	}
	
	
	@GetMapping("/countries")
	@ResponseBody
	public List<Country> getAllCountries()
	{
		ApplicationContext cxt = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>)cxt.getBean("countryList");
		return countries;
	}
	@GetMapping("/country/{code}")
	@ResponseBody
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException
	{
		ApplicationContext cxt = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>)cxt.getBean("countryList");
		Country resultCountry = null;
		
		for(Country country : countries)
		{
			if(country.getCode().equalsIgnoreCase(code))
			{
				resultCountry = country;
			}
		}
		
		if (resultCountry == null)
			throw new CountryNotFoundException();
		
		
		return resultCountry;
	}
	
}
