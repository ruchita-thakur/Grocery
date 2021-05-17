package com.cg.grocerydeliveryapplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class GrocerydeliveryapplicationApplication extends SpringBootServletInitializer {

	private static final Logger logger = LogManager.getLogger(GrocerydeliveryapplicationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GrocerydeliveryapplicationApplication.class, args);

		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
	}

}
