package OpenWeather.ZenoAssigment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapPage {

	public WebDriver driver;


	public MapPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='weather-layer-container'][1]")
	private WebElement temperature;
	@FindBy(xpath = "//div[@class='weather-layer-container'][2]")
	private WebElement pressure;
	@FindBy(xpath = "//div[@class='weather-layer-container'][3]")
	private WebElement windSpeed;
	@FindBy(xpath = "//div[@class='weather-layer-container'][4]")
	private WebElement clouds;
	@FindBy(xpath = "//div[@class='weather-layer-container'][5]")
	private WebElement globalPresipitation;
	@FindBy(xpath = "//li[@id='desktop-menu']/ul/li[6]")
	private WebElement map;

	public void clickMapIcon() {
		map.click();

	}

	public void temp() {
		temperature.click();

	}

	public void press() {
		pressure.click();

	}

	public void windspe() {
		windSpeed.click();

	}

	public void cloud() {
		clouds.click();

	}

	public void gPresp() {
		globalPresipitation.click();

	}
}
