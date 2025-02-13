package google_Youtube_Automation_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	@FindBy(id="items")
	private List<WebElement> items;
	
	@FindBy(name="search_query")
	private WebElement searchbox;

	@FindBy(xpath="//button[@class='ytSearchboxComponentSearchButton']")
	private WebElement searchbtn;
	
	@FindBy(xpath="(//a[@id='video-title'])[1]")
	private WebElement fvideo;
	
	@FindBy(xpath="//div[text()='Skip']")
	private WebElement skip;
	
	
	//initialization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public List<WebElement> getItems() {
		return items;
	}


	public WebElement getSearchbox() {
		return searchbox;
	}


	public WebElement getSearchbtn() {
		return searchbtn;
	}


	public WebElement getFvideo() {
		return fvideo;
	}


	public WebElement getSkip() {
		return skip;
	}
	
	
	
	
}
