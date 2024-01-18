package dropDown_listBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown1 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
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
