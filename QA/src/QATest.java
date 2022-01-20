import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QATest {
		
	WebDriver driver;
	QA qa;
	
	@BeforeTest
	private void initializeDriver() {
		qa = new QA();
		
	}
	
	@Test
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
	
	

}
