package com.applause.auto.pageframework.pages;

import io.appium.java_client.AppiumDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.applause.auto.framework.pageframework.device.DeviceUIData;
import com.applause.auto.pageframework.locators.Locators;
import com.applause.auto.framework.pageframework.devicecontrols.*;
import com.applause.auto.framework.pageframework.synchronization.*;

public class HomePage implements DeviceUIData {
	private AppiumDriver _driver = null;

	private Logger logger = LogManager.getLogger(HomePage.class);
	private SynchronizationHelper _wait = null;

	public HomePage(AppiumDriver driver) {
		_driver = driver;
		_wait = new SynchronizationHelper(_driver);
	}

	public AppiumDriver getDriver() {
		// TODO Auto-generated method stub
		return _driver;
	}

	public String getSelector() {
		// TODO Auto-generated method stub
		return null;
	}

	public void enterSearchKeyWord(String keyWord) {
		logger.info(String.format("Entering following search keyword: %s",
				keyWord));
		TextBox searchFld = new TextBox(Locators.HomePage.SEARCH_FLD);
		searchFld.enterText(keyWord);
	}

	public void tapSearchBtn() throws InterruptedException {
		logger.info(String.format("Tapping on [Search] button", ""));
		Button searchBtn = new Button(Locators.HomePage.SEARCH_BTN);
		searchBtn.tap();
	}

	public Boolean isAt() {
		logger.info("Checking if Home Page is loaded");

		_wait.waitForElementToAppear(Locators.HomePage.PAGE_LOGO);

		Boolean result = _wait.isElementDisplayed(Locators.HomePage.PAGE_LOGO);
		if (result)
			logger.info("Home Page is loaded");
		else
			logger.info("Home Page is NOT loaded");

		return result;
	}
}
