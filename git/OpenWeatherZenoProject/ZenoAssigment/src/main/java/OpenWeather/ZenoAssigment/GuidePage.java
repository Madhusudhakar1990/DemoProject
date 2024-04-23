package OpenWeather.ZenoAssigment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mainUtility.Base;

public class GuidePage extends Base
{
	public WebDriver driver;
	
	
	public GuidePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	@FindBy(xpath = "//li[@id='desktop-menu']/ul/li[1]")
	private WebElement guideLink;
	
//	WebElement guideLink = driver.findElement(By.xpath("//li[@id='desktop-menu']/ul/li[1]"));
	
	public void clickGuideIcon()
	{
		guideLink.click();
	}

}
