package com.applause.auto.pageframework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.appium.java_client.AppiumDriver;

public class Pages {
	private static final Logger logger = LogManager.getLogger(Pages.class);
	
	public static HomePage getHomePage(AppiumDriver driver) {
		HomePage page = new HomePage(driver);
		return page;
	}

	public static SearchPage getSearchPage(AppiumDriver driver) {
		SearchPage page = new SearchPage(driver);
		return page;
	}
}
