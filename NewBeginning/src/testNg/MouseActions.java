package testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

	WebDriver driver;
	@Test
	@Parameters(value="browserName")
	public void MouseAction(String BrowserName) throws InterruptedException 
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
		
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
		
		WebElement enable = driver.findElement(By.xpath("//a[text()='Enabled']"));
		WebElement dow = driver.findElement(By.xpath("//a[text()='Downloads']"));
		WebElement pdf = driver.findElement(By.xpath("//a[text()='PDF']"));

		
		Actions Act = new Actions(driver);
		
		Act.moveToElement(enable).pause(3000).moveToElement(dow).pause(3000).moveToElement(pdf).click().perform();
		
		driver.quit();
		
		
	}

}
