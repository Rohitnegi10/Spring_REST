package com.cognizant.truyum;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

@SpringBootApplication
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	private static MenuItemService menuItemService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		menuItemService = context.getBean(MenuItemService.class);

		LOGGER.info("Main Started");

		 testGetAllItems();

		// testGetCustomerList();
		// testModifyMenuItem();
	}

	private static void testGetAllItems() {
		LOGGER.info("Start");
		List<MenuItem> menuItemsList = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Items= {}", menuItemsList);
		LOGGER.info("End");
	}

	/*private static void testGetCustomerList() {
		LOGGER.info("Start");
		List<MenuItem> menuItemsList = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Items= {}", menuItemsList);
		LOGGER.info("End");

	}

	private static void testModifyMenuItem() {
		LOGGER.info("Start");
		MenuItem newItem = new MenuItem(4, "Cheese Pizza", new BigDecimal(188.00), true,
				DateUtil.convertToDate("2019/11/06"), "Main Course", true);
		menuItemService.modifyMenuItem(newItem);
		LOGGER.debug("Item= {}", newItem);
		LOGGER.info("End");

	}*/
}