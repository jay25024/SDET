
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QAUnitTest {
		
	WebDriver driver;
	
	GenericTable table;
	
	@BeforeTest
	private void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		table = new GenericTableImpl(driver);
		
	}
	//Testing functions implemented.
	
	@Test
	private void testGetHeaders() {
		driver.get("https://the-internet.herokuapp.com/tables");
		List<String> table1Headers = table.getHeaders("table1");
		assertTrue(table1Headers.contains("Last Name"),"Should contain column for Last Name");
		assertTrue(table1Headers.contains("First Name"),"Should contain column for First Name");
		assertTrue(table1Headers.contains("Email"),"Should contain column for Email");
		assertTrue(table1Headers.contains("Due"),"Should contain column for Due");
		assertTrue(table1Headers.contains("Web Site"),"Should contain column for Web Site");
	}
	
	@Test
	private void testGetHeadersRow() {
		TableData header = new TableData("Last Name","First Name","Email","Due","Web Site");
		driver.get("https://the-internet.herokuapp.com/tables");
		TableData headerWeb = table.getHeadersRow("table1");
		assertEquals(header, headerWeb,"Header Row is different");
	}
	
	@Test
	private void testGetRows() {
		TableData test1 = new TableData("Smith","John","jsmith@gmail.com","$50.00","http://www.jsmith.com");
		TableData test2 = new TableData("Bach","Frank","fbach@yahoo.com","$51.00","http://www.frank.com");
		TableData test3 = new TableData("Doe","Jason","jdoe@hotmail.com","$100.00","http://www.jdoe.com");
		TableData test4 = new TableData("Conway","Tim","tconway@earthlink.net","$50.00","http://www.timconway.com");
		
		List<TableData> data = table.getRows("table1");
		assertTrue(data.contains(test1),"Should contain "+test1.toString());
		assertTrue(data.contains(test2),"Should contain "+test2.toString());
		assertTrue(data.contains(test3),"Should contain "+test3.toString());
		assertTrue(data.contains(test4),"Should contain "+test4.toString());
	}
	
	@Test
	private void testGetRow() {
		TableData test1 = new TableData("Smith","John","jsmith@gmail.com","$50.00","http://www.jsmith.com");
		TableData fromWeb = table.getRow(0, "table1");
		
		assertEquals(test1,fromWeb,"Content for rows is not same");
	}
	/*@Test
	private void compareContentAndRows() {
		//Fetch table data rows from table 1
		List<String> table1 = qa.contentTable1();
		// Fetch table data rows from table 2
		List<String> table2 = qa.contentTable2();
		
		for(String s : table1) {
			
			 assertTrue(table2.contains(s),"Content from Tables is not the same");
		}
		
		assertEquals(table1.size(), table2.size(),"Number of rows in content is not the same for 2 tables");
		
	}
	
	@Test
	private void compareHeaderOrderAndColumnNumber() {
		//Fetch header row from table 1
		List<String> table1 = qa.headerTable1();
		//Fetch header row form table 2
		List<String> table2 = qa.headerTable2();
	
    	assertEquals(table1.get(0),table2.get(0),"Header order or content is not the same");
    	assertEquals(table1.size(),table2.size(),"Number of header rows for 2 tables is not the same");
			
	}
	*/
	

}
