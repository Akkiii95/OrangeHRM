package multiTabHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildBrwPopUp_multiTabshandling {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		// getting main pg id
		
		String MainPgID = driver.getWindowHandle();
		System.out.println(MainPgID);
		
		// click on buses tab
		driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
		

		// getting all windows ID
		
		Set<String> Allid = driver.getWindowHandles();
		System.out.println(Allid);
		// traverse by all ids
		
		Iterator<String> it = Allid.iterator();
		
		String MainID = it.next();
		String ChildId = it.next();
		
		// change focus from main to child pg
		driver.switchTo().window(ChildId);
		
		// input source city 
		driver.findElement(By.id("departFrom")).sendKeys("Nashik");
		driver.close();
		// chnge focus back to main pg
		
		driver.switchTo().window(MainID);
		Thread.sleep(3000);
		driver.findElement(By.id("journeyClass")).click();
		driver.findElement(By.xpath("//span[text()='Second Sitting (2S)']")).click();
		
		driver.quit();
		

	}

}
