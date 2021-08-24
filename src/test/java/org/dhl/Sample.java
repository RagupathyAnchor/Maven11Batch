package org.dhl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sample {
	public static void main(String[] args) {
		BaseClass b = new BaseClass();
		WebDriver driver = b.launchBroswer();
		b.launchUrl("https://en-gb.facebook.com");
		System.out.println(b.getPageUrl());
		System.out.println(b.getPageTitle());
		WebElement txtuserName = driver.findElement(By.name("email"));
		b.type(txtuserName, b.getDataFromExcel("C:\\Users\\Usha Rani\\eclipse-workspace\\SeleniumMaven\\ExcelData\\TravellersV2.xlsx",
				"Sheet1",3,0));
	}

}
