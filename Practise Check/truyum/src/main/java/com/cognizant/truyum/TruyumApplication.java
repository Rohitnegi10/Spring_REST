package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@SpringBootApplication
public class TruyumApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	private static MenuItemService menuItemService;

	public static void main(String[] args) {
		
		
		LOGGER.info("inside Main");
		ApplicationContext cxt = SpringApplication.run(TruyumApplication.class, args);
		menuItemService = cxt.getBean(MenuItemService.class);
		testGetAllItems();
	}
	
	private static void testGetAllItems() {
		LOGGER.info("Start");
		
		
		  List<MenuItem> menuItemsList = menuItemService.getMenuItemListAdmin();
		  LOGGER.info("Items= {}", menuItemsList.toString());
		 
		
		LOGGER.info("End");
	}

}
