package testNg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	WebDriver driver;
	@Test
	@Parameters(value="browserName")
	public void DropDown1(String BrowserName) throws InterruptedException 
	{
		if (BrowserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
					
		else if (BrowserName.equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/newtours/reservation.php");
		WebElement drop = driver.findElement(By.name("fromPort"));
		//drop.click();
		
		Select s = new Select(drop);
		
		Thread.sleep(2000);
		s.selectByVisibleText("Paris");
		Thread.sleep(2000);

		s.selectByIndex(2);
		Thread.sleep(2000);

		s.selectByValue("Zurich");

		//////   to print all options in drop down...
		
		List<WebElement> All = s.getOptions();
		
		for (int i=0; i<All.size(); i++) 
		{
			System.out.println(All.get(i).getText());
		}
		List<WebElement> allopt = s.getOptions();
		System.out.println(allopt.size());
		
		for(int i=0; i<allopt.size(); i++) 
		{
			System.out.println(allopt.get(i).getText());
		}		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
