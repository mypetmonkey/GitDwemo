package google_Youtube_Automation_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShortsPage {
	
	@FindBy(xpath="//span[text()='Shorts']")
	private WebElement shorts;
	@FindBy(xpath="//button[@aria-label='Next video']")
	private WebElement nextshort;
	@FindBy(xpath="//button[@aria-label='Previous video']")
	private WebElement previousVideo;
//	@FindBy()
//	private WebElement 
	
	
	public ShortsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getShorts() {
		return shorts;
	}


	public WebElement getNextshort() {
		return nextshort;
	}


	public WebElement getPreviousVideo() {
		return previousVideo;
	}
	
	

}
