package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Google_Youtube_Automation_GenericUtility.ListenerImplementation.class)
public class Demo {
	
	
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		List<WebElement> items = driver.findElements(By.id("items"));
		int count = items.size();
		System.out.println("==>"+count);
		for(int i=0;i<count-1;i++) {
			String text = items.get(i).getText();
			System.out.println(text);
		}
		Assert.assertEquals(count, 12);
		driver.findElement(By.name("search_query")).sendKeys("pawan singh");
		driver.findElement(By.xpath("//button[@class='ytSearchboxComponentSearchButton']")).click();
		driver.findElement(By.xpath("(//a[@id='video-title'])[3]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[text()='Skip']")).click();
				
	}

}
