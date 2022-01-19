//Author Jay Barot

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;


import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class QA {
	
	
	public static List<String> rowContentTable1Text ;
	public static List<String> rowContentTable2Text ;
	public static List<String> headerOrderTable1Text ;
	public static List<String> headerOrderTable2Text ;
	public static List<String> headerRowNumberTable1Text;
	public static List<String> headerRowNumberTable2Text;
	WebDriver driver;
	
	@BeforeTest
	private void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		rowContentTable1Text = new ArrayList<>();
		rowContentTable2Text =  new ArrayList<>();
		headerOrderTable1Text =  new ArrayList<>();
		headerOrderTable2Text =  new ArrayList<>();
		headerRowNumberTable1Text =  new ArrayList<>();
	    headerRowNumberTable2Text =  new ArrayList<>();
	}
	
	
	@Test
	public void compareContent() {
		boolean result = true;
		List<WebElement> rowContentTable1 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<WebElement> rowContentTable2 = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		
		for(WebElement temp: rowContentTable1) {
			rowContentTable1Text.add(temp.getText());
		}
		for(WebElement temp: rowContentTable2) {
			rowContentTable2Text.add(temp.getText());
		}
		
		for(String temp: rowContentTable1Text) {
			if(!rowContentTable2Text.contains(temp)) {
				result = false;
				break;
			}
		}
		assertTrue(result,"The data of Table is not same for the 2 tables");
	}
	
	@Test
	public void compareHeaderOrderAndContent() {
		driver.get("https://the-internet.herokuapp.com/tables");
		List<WebElement> headerRowNumberTable1 = driver.findElements(By.xpath("//table[@id='table1']/thead/tr"));
		List<WebElement> headerRowNumberTable2 = driver.findElements(By.xpath("//table[@id='table1']/thead/tr"));
	    
		for(WebElement temp: headerRowNumberTable1) {
			headerRowNumberTable1Text.add(temp.getText());
		}
		for(WebElement temp: headerRowNumberTable2) {
			headerRowNumberTable2Text.add(temp.getText());
		}
		
		boolean result = true;
		for(int i = 0; i< headerOrderTable1Text.size(); i++) {
			if(!headerOrderTable1Text.get(i).equals(headerOrderTable2Text.get(i))) {
				result = false;
				break;
			}
		}
		assertTrue(result,"The order or content for the headings is not the same");
	}
	
	@Test
	public void compareHeaderNumber() {
		driver.get("https://the-internet.herokuapp.com/tables");
		List<WebElement> headerRowNumberTable1 = driver.findElements(By.xpath("//table[@id='table1']/thead/tr"));
		List<WebElement> headerRowNumberTable2 = driver.findElements(By.xpath("//table[@id='table1']/thead/tr"));
		
		for(WebElement temp: headerRowNumberTable1) {
			headerRowNumberTable1Text.add(temp.getText());
		}
		for(WebElement temp: headerRowNumberTable2) {
			headerRowNumberTable2Text.add(temp.getText());
		}
				
		assertEquals(headerRowNumberTable1Text.size(),headerRowNumberTable2Text.size(),"Number of header rows for 2 tables is not the same");
	}
	
	@Test
	public void compareDataRowNumber() {
		driver.get("https://the-internet.herokuapp.com/tables");
		List<WebElement> rowContentTable1 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<WebElement> rowContentTable2 = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
	    
		for(WebElement temp: rowContentTable1) {
			rowContentTable1Text.add(temp.getText());
		}
		for(WebElement temp: rowContentTable2) {
			rowContentTable2Text.add(temp.getText());
		}
						
		assertEquals(rowContentTable1Text,rowContentTable2Text,"Number of data rows in 2 tables is not the same");
	}
	/*public void readDatafromWEB()
	{
		
		driver.get("https://the-internet.herokuapp.com/tables");
		//Extract rows from 2 tables		
		List<WebElement> rowContentTable1 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<WebElement> rowContentTable2 = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		//Extract headers from 2 rows in order
		List<WebElement> headerOrderTable1 = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		List<WebElement> headerOrderTable2 = driver.findElements(By.xpath("//table[@id='table2']/thead/tr/th"));
		//Extract number of headers
		List<WebElement> headerRowNumberTable1 = driver.findElements(By.xpath("//table[@id='table1']/thead/tr"));
		List<WebElement> headerRowNumberTable2 = driver.findElements(By.xpath("//table[@id='table1']/thead/tr"));
		
		
		for(WebElement temp: rowContentTable1) {
			rowContentTable1Text.add(temp.getText());
		}
		for(WebElement temp: rowContentTable2) {
			rowContentTable2Text.add(temp.getText());
		}
		for(WebElement temp: headerOrderTable1) {
			headerOrderTable1Text.add(temp.getText());
		}
		for(WebElement temp: headerOrderTable2) {
			headerOrderTable2Text.add(temp.getText());
		}
		for(WebElement temp: headerRowNumberTable1) {
			headerRowNumberTable1Text.add(temp.getText());
		}
		for(WebElement temp: headerRowNumberTable2) {
			headerRowNumberTable2Text.add(temp.getText());
		}
	}
	*/
}
