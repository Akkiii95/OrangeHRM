package dropDown_listBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown2 {

	public static void main(String[] args) 
	{
	System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("https://demo.guru99.com/test/newtours/reservation.php");
	
	WebElement month = driver.findElement(By.name("fromMonth"));
	
	Select s1 = new Select(month);
	
	s1.selectByIndex(2);

	/// print all options 

	List<WebElement> all = s1.getOptions();
	
	for(int i =0; i<all.size(); i++)
	{
		System.out.println(all.get(i).getText());
	}

	WebElement day = driver.findElement(By.name("fromDay"));
	
	Select s2 = new Select(day);
	s2.selectByVisibleText("16");
	
	/// print all options 

	List<WebElement> all2 = s2.getOptions();
	for (int i =0; i<all2.size(); i++) 
	{
		System.out.println(all2.get(i).getText());
	}
	
	
	driver.findElement(By.cssSelector("input[value='First']")).click();
	
	System.out.println(driver.findElement(By.cssSelector("input[value='First']")).isSelected());

	WebElement pref = driver.findElement(By.name("airline"));
	
	Select s3 = new Select(pref);
	s3.selectByVisibleText("Unified Airlines");
	
	/// print all options 
	
	List<WebElement> all3 = s3.getOptions();
	System.out.println(all3.size());
	
	for (int i=0; i<all3.size(); i++) 
	{
		System.out.println(all3.get(i).getText());
	}
	driver.quit();
	}

}
