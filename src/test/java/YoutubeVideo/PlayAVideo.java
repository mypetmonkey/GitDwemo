package YoutubeVideo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Google_Youtube_Automation_GenericUtility.BaseClass;
import google_Youtube_Automation_POM.HomePage;

@Listeners(Google_Youtube_Automation_GenericUtility.ListenerImplementation.class)
public class PlayAVideo extends BaseClass{
	

	@Test
	public void PlayAVideo_test() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		
		List<WebElement> items = hp.getItems();
		int count = items.size();
		
		for(int i=0;i<count-1;i++) {
			String text = items.get(i).getText();
			System.out.println(text);
		}
		Assert.assertEquals(count, 12);
		
	    hp.getSearchbox().sendKeys("pawan singh");
	    hp.getSearchbtn().click();
	    hp.getFvideo().click();
		Thread.sleep(8000);
		hp.getSkip().click();
		Thread.sleep(3000);
	}
	
}


	

	

	



