package com.applause.auto.pageframework.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.device.DeviceUIData;
import com.applause.auto.pageframework.chunks.FoundItemObject;
import com.applause.auto.pageframework.chunks.LocalHelper;
import com.applause.auto.pageframework.locators.Locators;
import com.applause.auto.framework.pageframework.devicecontrols.*;
import com.applause.auto.framework.pageframework.synchronization.*;

public class SearchPage implements DeviceUIData {
	private AppiumDriver _driver = null;

	private Logger logger = LogManager.getLogger(SearchPage.class);
	private SynchronizationHelper _wait = null;

	public SearchPage(AppiumDriver driver) {
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
		TextBox searchFld = new TextBox(Locators.SearchPage.SEARCH_FLD);
		searchFld.enterText(keyWord);
	}

	public void tapSearchBtn() {
		logger.info(String.format("Tapping on [Search] button", ""));
		Button searchBtn = new Button(Locators.SearchPage.SEARCH_BTN);
		searchBtn.tap();
	}

	public List<FoundItemObject> getListOfFoundItems() {
		logger.info("Getting list of found items");

		List<FoundItemObject> foundItems = new ArrayList<FoundItemObject>();
		Boolean newFindings = false;

		//I have tried to use ScrollView object using this selector: "com.wholefoods.wholefoodsmarket:id/recipesSearchResultsGrid" 
		//But this object was useless, methods like getTextElements(), getButtons() returns 0 elements
		//So, I have used native driver's methods to get elements from the list
		
		do {
			newFindings = false;
			
			List<WebElement> elements = _driver.findElements(By
					.xpath(Locators.SearchPage.LIST_OF_ITEMS_Xpath));
			for (WebElement webElement : elements) {
				FoundItemObject foundItem = new FoundItemObject();
				try {
					foundItem
							.setName(LocalHelper.getElementText(webElement.findElement(By
									.id(Locators.SearchPage.FOUND_ITEM_TITLE))));

					int ammountOfVoted = Integer
							.parseInt(LocalHelper.getElementText(webElement.findElement(By
									.id(Locators.SearchPage.FOUND_ITEM_AMOUNT_OF_VOTED))));
					foundItem.setAmountOfVoted(ammountOfVoted);
				} catch (Exception e) {
					continue;
				}

				Boolean isDuplicate = false;
				for (FoundItemObject item : foundItems) {
					if (item.getName().equals(foundItem.getName())) {
						isDuplicate = true;
						break;
					}
				}

				if (isDuplicate == false) {
					foundItems.add(foundItem);
					newFindings = true;
				}
			}

			if (newFindings) {
				TouchAction act = new TouchAction(_driver);
				act.press(elements.get(elements.size() - 1))
						.moveTo(elements.get(0)).release().perform();
			}
		} while (newFindings);

		return foundItems;
	}

	public Boolean isAt() {
		logger.info("Checking if Search Page is loaded");
		String expectedTitle = "search";

		_wait.waitForElementToAppear(Locators.SearchPage.PAGE_TITLE);

		Text pageTitle = new Text(Locators.SearchPage.PAGE_TITLE);
		Boolean result = pageTitle.getStringValue().toLowerCase()
				.equals(expectedTitle);
		if (result)
			logger.info("Search Page is loaded");
		else
			logger.info("Search Page is NOT loaded");

		return result;
	}
}
