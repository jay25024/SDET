import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class GenericTableImpl implements GenericTable{
	
    WebDriver driver;
    public GenericTableImpl(WebDriver driver) {
    	this.driver = driver;
    }

    public List<String> webToString(List<WebElement> temp){
    	List<String> result = new ArrayList<>();
    	for(WebElement w: temp) {	
    		result.add(w.getText());
    	}
    	return result;
    }

	@Override
	public List<String> getHeaders(String tableId) {
		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='"+tableId+"']/thead/tr/th"));
		return this.webToString(headers);
	}

	@Override
	public TableData getHeadersRow(String tableId) {
		TableData table = new TableData();
		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='"+tableId+"']/thead/tr/th"));
		List<String> headersText = this.webToString(headers);
		table.withLastName(headersText.get(0));
		table.withFirstName(headersText.get(1));
		table.withEmail(headersText.get(2));
		table.withDue(headersText.get(3));
	    table.withWebsite(headersText.get(4));
		return table;
		
	}

	@Override
	public TableData getRow(int index, String tableId) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='"+tableId+"']/tbody/tr"));
		List<String> rowsString = this.webToString(rows);
		String data = rowsString.get(index);
		String [] splitted = data.split(" ");
		return new TableData(splitted[0],splitted[1],splitted[2],splitted[3],splitted[4]);
	}

	@Override
	public List<TableData> getRows(String tableId) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='"+tableId+"']/tbody/tr"));
		List<String> rowsString = this.webToString(rows);
		List<TableData> data = new ArrayList<>();
		for(String s: rowsString) {
			String [] splitted = s.split(" ");
			data.add(new TableData(splitted[0],splitted[1],splitted[2],splitted[3],splitted[4]));
		}
		return data;
	}
	
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		// initialize driver as chrome driver
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		GenericTableImpl g = new GenericTableImpl(driver);
		System.out.println(g.getHeadersRow("table1"));
	}


}
