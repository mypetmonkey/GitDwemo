package Google_Youtube_Automation_GenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebdriverUtility wlib=new WebdriverUtility();
	JavaUtility jlib=new JavaUtility();
	FileUtility flib=new FileUtility();
	
	
public	 WebDriver driver;
public static WebDriver sdriver;
	
//	@BeforeSuite(alwaysRun = true)
//	public void connectdb() throws Throwable {
//		
//		dlib.connectTodb();
//		
//	}
//	
	
    @Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowser(@Optional ("chrome") String browser) throws Throwable {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			 WebDriverManager.edgedriver().setup();
			    driver=new EdgeDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		sdriver = driver;
		wlib.maximixeWindow(driver);
		String url=flib.getPropertyFileData("url");
		driver.get(url);
		driver.manage().deleteAllCookies();
		wlib.handleNotification();
		wlib.waitForPageLoad(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}
	//@BeforeMethod
	//@AfterMethod
	 
	
	@AfterClass(alwaysRun = true)
	public void closebrowser() {
		//driver.quit();
	}
	
	
//	@AfterSuite(alwaysRun = true)
//	public void closedb() throws Throwable {
//		dlib.closedb();
//	}
	

}
