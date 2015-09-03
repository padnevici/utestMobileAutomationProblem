package com.applause.auto.pageframework.pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.device.DeviceUIData;
import com.applause.auto.pageframework.chunks.LocalHelper;
import com.applause.auto.pageframework.testdata.TestConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage implements DeviceUIData {
	private AppiumDriver _driver = null;

	private static final Logger logger = LogManager.getLogger(HomePage.class);

	public HomePage(AppiumDriver driver) {
		// super();
		this._driver = driver;
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
		WebElement searchFld = _driver.findElement(By
				.id("com.wholefoods.wholefoodsmarket:id/etHomeSearch"));
		searchFld.sendKeys(keyWord);
	}

	public void tapSearchBtn() throws InterruptedException {
		logger.info(String.format("Tapping on [Search] button", ""));
		WebElement searchBtn = _driver
				.findElementById("com.wholefoods.wholefoodsmarket:id/imgSearch");
		searchBtn.click();
		LocalHelper.implicitWait();
	}
}
