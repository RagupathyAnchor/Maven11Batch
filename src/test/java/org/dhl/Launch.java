package org.dhl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Usha Rani\\eclipse-workspace\\Selenium28june\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://en-gb.facebook.com/");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
	}

}
