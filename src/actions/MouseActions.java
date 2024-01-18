package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
		
		WebElement enable = driver.findElement(By.xpath("//a[text()='Enabled']"));
		WebElement dow = driver.findElement(By.xpath("//a[text()='Downloads']"));
		WebElement pdf = driver.findElement(By.xpath("//a[text()='PDF']"));

		
		Actions Act = new Actions(driver);
		
		Act.moveToElement(enable).pause(3000).moveToElement(dow).pause(3000).moveToElement(pdf).click().perform();
		
		driver.quit();
		
		
	}

}
