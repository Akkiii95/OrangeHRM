package webTableRead;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WBT1 {

	public static void main(String[] args) 
	{
		System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/tables");
		
		List<WebElement> totRows = driver.findElements(By.xpath("//table[@id='table1']//tr")); // rows
		
		List<WebElement> totCols = driver.findElements(By.xpath("//table[@id='table1']//tr[1]//td"));  // columns
		
		System.out.println("Rows are "+ totRows.size());
		System.out.println("col are "+ totCols.size());
		
		// reading whole WTB data
		
		for (int i=1; i<totRows.size(); i++)
		{
			for (int j=1; j<totCols.size(); j++)
			{
				String Alldata = driver.findElement(By.xpath("//table[@id='table1']//tr["+ i +"]/td["+ j +"]")).getText();
				
				System.out.println("rows:"+ i +" cols:"+ j +" "+ Alldata);
			}
		}
		driver.quit();
	}

}
