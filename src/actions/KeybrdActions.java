package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeybrdActions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");

		driver.findElement(By.xpath("//input[@type='text']"));
		
		Actions act = new Actions(driver);
		
		act.sendKeys("virat kohli").perform();
		
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		driver.findElement(By.name("q")).click();
		Thread.sleep(3000);
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).perform();
		Thread.sleep(3000);
		act.keyDown(Keys.SHIFT).sendKeys("virat wife").keyDown(Keys.ENTER).perform();
		Thread.sleep(3000);
		driver.quit();
	}

}
