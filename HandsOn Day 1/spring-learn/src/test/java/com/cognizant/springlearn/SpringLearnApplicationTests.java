package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.springlearn.controller.CountryController;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
	@Autowired
	private CountryController countryController;
	@Autowired
	private MockMvc mvc;
	
	private ResultActions actions;

	@Test
	void contextLoads() {
		assertNotNull(countryController);
	}

	
	  @Test public void testGetCountry() throws Exception { 
	  actions = mvc.perform(get("/country/in")); 
	  actions.andExpect(status().isOk());
	  actions.andExpect(jsonPath("$.code").exists());
	  actions.andExpect(jsonPath("$.code").value("IN"));
	  actions.andExpect(jsonPath("$.name").value("India")); }
	 
	@Test
	public void testGetCountryException() throws Exception
	{
		 mvc.perform(get("/country/innn"))
		 .andExpect(status().isBadRequest())
		 .andExpect(status().reason("Country not found"));
		 //actions.andExpect(status().reason("Country Not found"));
	}
}
