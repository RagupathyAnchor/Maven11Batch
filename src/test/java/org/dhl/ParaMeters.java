package org.dhl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParaMeters {
	@Parameters({"userName","passWord"})
	@Test
private void tc1(String s1, String s2) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	

}
}





//https://adactinhotelapp.com/index.php