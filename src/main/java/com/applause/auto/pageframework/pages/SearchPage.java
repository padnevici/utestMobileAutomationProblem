package com.applause.auto.pageframework.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applause.auto.framework.pageframework.device.DeviceUIData;
import com.applause.auto.pageframework.chunks.FoundItem;
import com.applause.auto.pageframework.chunks.LocalHelper;
import com.applause.auto.pageframework.locators.Locators;
import com.applause.auto.pageframework.testdata.TestConstants;

public class SearchPage implements DeviceUIData {
	private AppiumDriver _driver = null;

	private Logger logger = LogManager.getLogger(SearchPage.class);
	private WebDriverWait _wait = null;

	public SearchPage(AppiumDriver driver) {
		_driver = driver;
		_wait = new WebDriverWait(_driver, TestConstants.Settings.WAIT_TIME_SEC);
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
		WebElement searchFld = _driver
				.findElement(Locators.SearchPage.SEARCH_FLD);
		searchFld.sendKeys(keyWord);
	}

	public void tapSearchBtn() {
		logger.info(String.format("Tapping on [Search] button", ""));
		WebElement searchBtn = _driver
				.findElement(Locators.SearchPage.SEARCH_BTN);
		searchBtn.click();
	}

	public List<FoundItem> getListOfFoundItems() {
		logger.info("Getting list of found items");

		List<FoundItem> foundItems = new ArrayList<FoundItem>();
		Boolean newFindings = false;

		do {
			newFindings = false;
			List<WebElement> elements = _driver
					.findElements(Locators.SearchPage.LIST_OF_ITEMS);
			for (WebElement webElement : elements) {
				FoundItem foundItem = new FoundItem();
				try {
					foundItem
							.setName(LocalHelper.getElementText(webElement
									.findElement(Locators.SearchPage.FOUND_ITEM_TITLE)));

					int ammountOfVoted = Integer
							.parseInt(LocalHelper.getElementText(webElement
									.findElement(Locators.SearchPage.FOUND_ITEM_AMOUNT_OF_VOTED)));
					foundItem.setAmountOfVoted(ammountOfVoted);
				} catch (Exception e) {
					continue;
				}

				Boolean isDuplicate = false;
				for (FoundItem item : foundItems) {
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

		_wait.until(ExpectedConditions.textToBePresentInElementLocated(
				Locators.SearchPage.PAGE_TITLE, expectedTitle.toUpperCase()));

		String actualTitle = LocalHelper.getElementText(
				_driver.findElement(Locators.SearchPage.PAGE_TITLE))
				.toLowerCase();
		Boolean result = actualTitle.equals(expectedTitle);
		if (result)
			logger.info("Search Page is loaded");
		else
			logger.info("Search Page is NOT loaded");

		return result;
	}
}
