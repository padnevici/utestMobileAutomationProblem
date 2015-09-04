package com.applause.auto.test;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.applause.auto.framework.test.BaseAppiumTest;
import com.applause.auto.pageframework.chunks.FoundItem;
import com.applause.auto.pageframework.chunks.LocalHelper;
import com.applause.auto.pageframework.pages.Pages;
import com.applause.auto.pageframework.testdata.TestConstants;

public class TestSample extends BaseAppiumTest {
	private static AppiumDriver _dr = BaseAppiumTest.driver;
	private final static Logger logger = LogManager.getLogger(Pages.class);

	@BeforeSuite(alwaysRun = true)
	public static void init() {
		LocalHelper.configureLog4jXML();
	}

	@Test
	@BeforeTest(alwaysRun = true)
	public static void testSetup() {
	}

	@Test(groups = { TestConstants.TestNGGroups.REG }, description = "test_1")
	public static void test_1() throws InterruptedException {
		// Check if app is opened
		Assert.assertTrue(Pages.getHomePage(_dr).isAt());

		// Enter coffee and tap on search
		Pages.getHomePage(_dr).enterSearchKeyWord(
				TestConstants.TestData.TEST_1_SEARCH_KWD);
		Pages.getHomePage(_dr).tapSearchBtn();

		// Check if multiple results are displayed
		Assert.assertTrue(Pages.getSearchPage(_dr).isAt());
		List<FoundItem> foundItems = Pages.getSearchPage(_dr)
				.getListOfFoundItems();
		logger.info("Checking if multiple items were found");
		Assert.assertNotSame(foundItems.size(), 1,
				"None or just one item(s) was/were found");
	}

	@AfterClass
	public void tearDown() {
		BaseAppiumTest.driver.quit();
	}
}
