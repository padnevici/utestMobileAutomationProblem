package com.applause.auto.pageframework.chunks;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.applause.auto.pageframework.testdata.TestConstants;

public final class LocalHelper {
	public static String getElementText(WebElement webElement) {
		return webElement.getText().trim();
	}
	
	public static void configureLog4jXML() {
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
}
