package com.applause.auto.pageframework.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.device.DeviceUIData;
import com.applause.auto.framework.pageframework.util.DeviceControl;
import com.applause.auto.pageframework.chunks.FoundItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchPage implements DeviceUIData {
	private AppiumDriver _driver = null;

	private static final Logger logger = LogManager.getLogger(SearchPage.class);

	public SearchPage(AppiumDriver driver) {
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
				.id("com.wholefoods.wholefoodsmarket:id/recipeSearchEditBox"));
		searchFld.sendKeys(keyWord);
	}

	public void tapSearchBtn() {
		logger.info(String.format("Tapping on [Search] button", ""));
		WebElement searchBtn = _driver
				.findElementById("com.wholefoods.wholefoodsmarket:id/recipeFilterBtn");
		searchBtn.click();
	}

	public List<FoundItem> getListOfFoundItems() {
		List<FoundItem> foundItems = new ArrayList<FoundItem>();
		List<WebElement> elements = _driver
				.findElements(By
						.xpath("//*[@resource-id='com.wholefoods.wholefoodsmarket:id/recipesSearchResultsGrid']/*[@class='android.widget.RelativeLayout']"));
		logger.info("--------->>>>" + elements.size());
		return foundItems;
	}

	public Boolean isAt() {
		String title = _driver
				.findElement(
						By.id("com.wholefoods.wholefoodsmarket:id/header_title"))
				.getText().toLowerCase().trim();
		return title.equals("search");
	}
}
