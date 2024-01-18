package testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frame1 {

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
	public void Frame1() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		WebElement text = driver.findElement(By.className("tox-edit-area__iframe"));
		
		driver.switchTo().frame(text);
		System.out.println(driver.findElement(By.xpath("//p[text()='Your content goes here.']")).getText());
		
		driver.findElement(By.id("tinymce")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("tinymce")).sendKeys("hiiiiiiiiiiiiiiiiiiiiii");

		driver.switchTo().defaultContent();
		
		System.out.println(driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText());
		
		driver.quit();
	}

}
