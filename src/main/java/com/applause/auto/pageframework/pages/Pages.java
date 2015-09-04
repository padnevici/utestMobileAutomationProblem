package com.applause.auto.pageframework.pages;

import io.appium.java_client.AppiumDriver;

public class Pages {
	public static HomePage getHomePage(AppiumDriver driver) {
		HomePage page = new HomePage(driver);
		return page;
	}

	public static SearchPage getSearchPage(AppiumDriver driver) {
		SearchPage page = new SearchPage(driver);
		return page;
	}
}
