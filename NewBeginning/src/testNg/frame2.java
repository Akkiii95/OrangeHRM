package testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frame2 
{
	WebDriver driver;
	@BeforeMethod
	@Parameters(value="BrowserName")
	public void Launch(String bname) throws InterruptedException 
	{
		if(bname.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		}
		else if(bname.equals("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	@Test	
	public void Frame2()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame("frame-top");
		
		driver.switchTo().frame("frame-left");
		System.out.println("text is "+driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText());
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		System.out.println("text is "+driver.findElement(By.id("content")).getText());

		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-right");
		System.out.println("text is "+driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText());
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		System.out.println("text is "+driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText());
		driver.switchTo().defaultContent();

		driver.quit();
		
}
}