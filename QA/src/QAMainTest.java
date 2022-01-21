



import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QAMainTest {

	WebDriver driver;
	
	GenericTable table;
	
	@BeforeTest
	private void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		table = new GenericTableImpl(driver);
		
	}
	//Testing content from two tables
	@Test
	private void testRowContentAndNumber() {
		driver.get("https://the-internet.herokuapp.com/tables");
		List<TableData> table1 = table.getRows("table1");
		List<TableData> table2 = table.getRows("table2");
		
		for(TableData td: table1) {
			assertTrue(table2.contains(td),"Table 2 should contain row "+ td.toString());
		}
		
		assertEquals(table1.size(),table2.size(),"Size for two tables is not the same");
		
	}
	
	@Test
	private void testHeaderOrderAndNumber() {
		driver.get("https://the-internet.herokuapp.com/tables");
		TableData table1 = table.getHeadersRow("table1");
		TableData table2 = table.getHeadersRow("table2");
				
		assertEquals(table1,table2,"Header row is not the same");
		
	    List<String> table1Headers = table.getHeaders("table1");
	    List<String> table2Headers = table.getHeaders("table2");
	    
	    assertEquals(table1Headers.size(),table2Headers.size(),"Number of header columns is not the same");
	    
	    for(int i = 0; i< table1Headers.size();i++) {
	    	assertEquals(table1Headers.get(i),table2Headers.get(i),"Header order is not the same");
	    }
		
	}
}
