package org.dhl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AxesXpath {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Usha Rani\\eclipse-workspace\\Selenium28june\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//driver.manage().window().maximize();
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("Iphone");
		searchBox.submit();
		WebElement productC = driver.findElement(By.xpath("//span[contains(text(),'(64GB) - Purple')]"));
		productC.click();
		WebElement productVal = driver.findElement(By.id("//span[@class='a-size-medium a-color-price priceBlockBuyingPriceString']//parent::td"));
		String amtValue = productVal.getText();
		System.out.println(amtValue);
	}
}






