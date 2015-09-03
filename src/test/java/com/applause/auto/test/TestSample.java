package com.applause.auto.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.applause.auto.framework.pageframework.util.DeviceControl;
import com.applause.auto.framework.test.*;
import com.applause.auto.pageframework.pages.Pages;
import com.applause.auto.pageframework.testdata.TestConstants;

public class TestSample extends BaseAppiumTest {
	private static AppiumDriver _dr = BaseAppiumTest.driver;
	private static final Logger logger = LogManager.getLogger(Pages.class);

	private static void configureLog4jXML() {
		String content = null;
		File file = new File("src/main/resources/log4j2Tmp.xml");

		try {
			FileReader reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();

			File newTextFile = new File("src/main/resources/log4j2.xml");

			FileWriter fw = new FileWriter(newTextFile);
			fw.write(content.replace("%EPOCHTIME%",
					(System.currentTimeMillis() / 1000) + ""));
			fw.close();

		} catch (IOException e) {
			System.err.println(e);
		}
	}

	@BeforeSuite(alwaysRun = true)
	public static void init() {
		configureLog4jXML();
	}

	@Test
	@BeforeTest(alwaysRun = true)
	public static void testSetup() {
	}

	@Test(groups = { TestConstants.TestNGGroups.REG}, description = "")
	public static void test_1() throws InterruptedException {

		Pages.getHomePage(_dr).enterSearchKeyWord(TestConstants.TestData.COFFEE_SEARCH_KWD);
		Pages.getHomePage(_dr).tapSearchBtn();
		Assert.assertTrue(Pages.getSearchPage(_dr).isAt());
		Pages.getSearchPage(_dr).getListOfFoundItems();
		
	}

	@AfterClass
	public void tearDown() {
		BaseAppiumTest.driver.quit();
	}
}
