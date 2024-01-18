package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameSimple2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
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