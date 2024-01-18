package webTableRead;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WBt2 {

	public static void main(String[] args) 
	{
		System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/tables");
		
		List<WebElement> totRows = driver.findElements(By.xpath("//table[@id='table2']//tr"));
		System.out.println("total Rows "+totRows.size());
		
		List<WebElement> totCols = driver.findElements(By.xpath("//table[@id='table2']//tr[1]/td"));
		System.out.println("total Cols "+ totCols.size());
		
		// read all table data...
		
		for(int i=1; i<totRows.size(); i++)
		{
			for(int j=1; j<=totCols.size(); j++)
			{
				String All = driver.findElement(By.xpath("//table[@id='table2']//tr["+i+"]/td["+j+"]")).getText();
				System.out.println("rows: " +i+ " cols: " +j+ " text: "+ All);
				
			}
		}
		System.out.println("...............for each loop..............................");

		//...........for each loop....................................................................
		List<WebElement> totRows1 = driver.findElements(By.xpath("//table[@id='table2']//tr"));

		for(WebElement w : totRows1)
		{
			System.out.print(w.getText());
			System.out.println();
		}
		System.out.println("...............by iterator loop.............................");

		//...........by iterator loop........................................
		List<WebElement> totRows2 = driver.findElements(By.xpath("//table[@id='table2']//td"));

		java.util.Iterator<WebElement> it = totRows2.iterator();
		
		while (it.hasNext())
		{
			System.out.println(it.next().getText()+ "  ");
			//System.out.println();
		}
		
		driver.quit();
	}

}
