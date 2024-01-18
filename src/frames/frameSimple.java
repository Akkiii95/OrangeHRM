package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameSimple {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("Webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
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
		
		//driver.quit();
	}

}
