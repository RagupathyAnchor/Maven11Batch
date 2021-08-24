package org.dhl;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
	import java.util.Set;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	public class BaseClass {

		static WebDriver driver;
		public static void getDriver() {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Usha Rani\\eclipse-workspace\\SeleniumMaven\\Driver\\chromedriver.exe");
			 driver=new ChromeDriver();

		}
	public static void loadUrl(String url) {
		driver.get(url);
	}
	public static WebElement findElementById(String id) {
		WebElement element=driver.findElement(By.id(id));
		return element;
	}
	public static void fill(WebElement e,String value) {
	e.sendKeys(value);
	}
	public static void btnClick(WebElement e) {
		e.click();
	}
	public static String getUrl() {
		String url=driver.getCurrentUrl();
		return url;
		}	

	public static String getTitle() {
		String title=driver.getTitle();
		return title;
	}
	//Actions
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}
	public static void dragDrop(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}

	public static void doubleClick(WebElement dc) {
		Actions a=new Actions(driver);
		a.moveToElement(dc).doubleClick().perform();

	}
	public static void contextClick(WebElement cc) {
		Actions a=new Actions(driver);
		a.moveToElement(cc).doubleClick().perform();

	}
	public static void dropAndDrop(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
	//DropDown
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByVisibleText(value);
	}
	public Object getDataFromExcel;
	private void getOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> allOptions=s.getOptions();
		for(int i=0;i<allOptions.size();i++)
		{
			WebElement ele=allOptions.get(i);
			String text=ele.getText();
			System.out.println(text);
		}

	}
	public static void deselectByVisibleText(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByVisibleText(value);
	}
	public static void deselectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
	public static void deselectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
	} 
	//JavaScriptExecutor
	public static void scrollDown(WebElement e) {
	JavascriptExecutor jk=(JavascriptExecutor)driver;
	jk.executeScript("arguments[0].ScrollIntoView(true)", e);
	}
	public static void ScrollUp(WebElement e) {
		JavascriptExecutor jk=(JavascriptExecutor)driver;
		jk.executeScript("arguments[0].ScrollIntoView(false)", e);

	}
	public static void setAtrribute(String str,WebElement e) {
		JavascriptExecutor jk=(JavascriptExecutor)driver;
		jk.executeScript("arguments[0].setAttribute('value','"+str+"')", e);

	}
	public static String getAttribute(String str,WebElement e) {
		JavascriptExecutor jk=(JavascriptExecutor)driver;
		String txt=(String)jk.executeScript("arguments[0].getAttribute('value',"+str+")", e);
		return str;
	}

	public static void click(WebElement btnlogin) {
		JavascriptExecutor jk=(JavascriptExecutor)driver;
		jk.executeScript("arguments[0].click()", btnlogin);
	}

	//Screenshots
	public static void takeScreenShots(String filename) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver; 
		File src=tk.getScreenshotAs(OutputType.FILE);
		File des=new File("E:\\\\Facebook.png");
		//FileUtils.copyFile(src, des);
	}
	//Alerts
	public static void simpleAlert() {
		Alert a=driver.switchTo().alert();
	    a.accept();
	}
	public static void confirmAlert() {
		Alert a=driver.switchTo().alert();
	    a.dismiss();
	}

	public static void promptAlert(String str) {
		Alert a=driver.switchTo().alert();
		a.sendKeys(str);
		a.accept();
	}
	//Frames
	public static int checkFrameCount(String frame) {
		List<WebElement> allframes=driver.findElements(By.tagName(frame));
		int count=allframes.size();
		return count;
	}
	public static void framebyIndex(int index) {
	driver.switchTo().frame(index);
	}
	//WindowsHandling
	public static void windowsByIndex(int Windowindex) {
		Set<String> allId=driver.getWindowHandles();
		List<String> li=new ArrayList<String>();
		li.addAll(allId);
		driver.switchTo().window(li.get(Windowindex));

	}
	//Excel
	public static String excelReadData(int rowNo,int cellNo) throws IOException {
	File f=new File("C:\\Users\\Bindu\\eclipse-workspace\\Frameworks\\Read\\fileData");
	FileInputStream fin=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(fin);
	Sheet s=w.getSheet("sheet1");
	Row r=s.getRow(rowNo);
	Cell c=r.getCell(cellNo);
	int cellType=c.getCellType();
	String value=" ";
	if(cellType==1)
	{
		value=c.getStringCellValue();
	}
	else if(DateUtil.isCellDateFormatted(c))
	{
		Date d=c.getDateCellValue();
		SimpleDateFormat sim=new SimpleDateFormat("MM-dd-yyyy");
		value=sim.format(d);
		}
	else
	{
		double dd=c.getNumericCellValue();
		long l=(long)dd;
		value=String.valueOf(l);
	}
	return value;
	}
	public WebDriver launchBroswer() {
		// TODO Auto-generated method stub
		return null;
	}
	public void launchUrl(String string) {
		// TODO Auto-generated method stub
		
	}
	public char[] getPageUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	public char[] getPageTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getDataFromExcel(String string, String string2, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	public void type(WebElement txtuserName, Object dataFromExcel) {
		// TODO Auto-generated method stub
		
	}
}