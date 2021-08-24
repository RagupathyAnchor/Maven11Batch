package org.hcl;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit {
	@BeforeClass
public static void beforeClass() {
	System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\Usha Rani\\eclipse-workspace\\SeleniumMaven\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://en-gb.facebook.com/");
}
	@Before
	public void beforeMethod() {
		Date d = new Date();
		System.out.println(d);
	}
	@Test
	public void currentUrlGet() {
		WebDriver driver = new ChromeDriver();
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	@After
	public void afterMethod() {
		Date d = new Date();
		System.out.println(d);
}
	@AfterClass
	public static void afterClass() {
		System.out.println("Quit Browser");
	}
}