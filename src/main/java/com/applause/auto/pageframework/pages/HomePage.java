package com.applause.auto.pageframework.pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applause.auto.framework.pageframework.device.DeviceUIData;
import com.applause.auto.pageframework.chunks.LocalHelper;
import com.applause.auto.pageframework.locators.Locators;
import com.applause.auto.pageframework.testdata.TestConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage implements DeviceUIData {
	private AppiumDriver _driver = null;

	private Logger logger = LogManager.getLogger(HomePage.class);
	private WebDriverWait _wait = null;

	public HomePage(AppiumDriver driver) {
		_driver = driver;
		_wait = new WebDriverWait(_driver, TestConstants.TestData.WAIT_TIME_SEC);
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
		WebElement searchFld = _driver.findElement(Locators.HomePage.SEARCH_FLD);
		searchFld.sendKeys(keyWord);
	}

	public void tapSearchBtn() throws InterruptedException {
		logger.info(String.format("Tapping on [Search] button", ""));
		WebElement searchBtn = _driver
				.findElement(Locators.HomePage.SEARCH_BTN);
		searchBtn.click();
	}
	
	public Boolean isAt() {
		logger.info("Checking if Home Page is loaded");

		_wait.until(ExpectedConditions.visibilityOfElementLocated(
				Locators.HomePage.PAGE_LOGO));
		
		Boolean result = _driver.findElement(Locators.HomePage.PAGE_LOGO).isDisplayed();
		if (result)
			logger.info("Home Page is loaded");
		else
			logger.info("Home Page is NOT loaded");

		return result;
	}
}
