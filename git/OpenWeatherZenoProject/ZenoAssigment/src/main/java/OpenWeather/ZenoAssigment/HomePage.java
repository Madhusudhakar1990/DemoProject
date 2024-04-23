package OpenWeather.ZenoAssigment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import mainUtility.Base;

public class HomePage extends Base {

	public WebDriver driver;
	public  HomePage hp;

	public HomePage(WebDriver driver)

	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[@class='logo']")
	private WebElement mainLogo;

	@FindBy(xpath = "//input[@placeholder='Search city']")
	private WebElement textFieldtwo;

	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[2]/b[2]/i")
	private WebElement weatherStatus;

	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[2]/b[1]/a")
	private WebElement weatheCityName;

	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[2]/p[1]")
	private WebElement weatherStatustwo;

	@FindBy(xpath = "(//div[@class='bold'])[1]")
	private WebElement searchDetails;

	@FindBy(xpath = "//div[@class='current-container mobile-padding']/div[1]/h2")
	private WebElement cityCheck;

	@FindBy(xpath = "//ul[@class='search-dropdown-menu']/li")
	private WebElement dropone;

	@FindBy(xpath = "//ul[@class='weather-items text-container orange-side standard-padding']/li")
	private  List<WebElement> list;

	@FindBy(tagName = "a")
	private WebElement cityNameTest;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement textField;

	@FindBy(xpath = "//div[@class='current-container mobile-padding']/div/h2")
	private WebElement city;

	@FindBy(xpath = "//ul[@class='weather-items text-container orange-side standard-padding']/li/div")
	private  WebElement wpeed;

//	@Test(dataProvider = "getData") 
	public void weatherInYourCity(String city) throws InterruptedException {

		try {
			mainLogo.click();
			textField.sendKeys(city, Keys.ENTER); // here we are testing with top search field
			Thread.sleep(5000);
			String weatherData = weatherStatus.getText();
			String weatherDatatwo = weatherStatustwo.getText();
			String cityname = weatheCityName.getText();

			System.out.println("---------------------------------------------------------------------------");
			System.out.println(cityname);
			System.out.println(weatherData);
			System.out.println(weatherDatatwo);
			System.out.println("---------------------------------------------------------------------------");

		} catch (Exception e) {
			Thread.sleep(1000);
			System.out.println("**************** ");
			System.out.println("**INVALID CITY** ");
			System.out.println("**************** ");

		}

	}

	public void weatherdetail(String city) throws InterruptedException {

		mainLogo.click();
		try {
			textFieldtwo.sendKeys(city, Keys.ENTER); // here we are testing with second search field

			clickElement(dropone);

			String citynameCheck = cityCheck.getText();

			String cityWeatherDetails = searchDetails.getText();

			String citywspeed = wpeed.getText();
			System.out.println("---------------------------------");

			System.out.println("city display :" + citynameCheck);
			System.out.println(cityWeatherDetails);
			System.out.println(citywspeed);
			System.out.println("---------------------------------");

		}

		catch (Exception e) {
			Thread.sleep(1000);
			System.out.println("**************** ");
			System.out.println("**INVALID CITY** ");
			System.out.println("**************** ");

		}
	}

	public void cityDetail() throws InterruptedException {
		hp = new HomePage(driver);

		hp.weatherdetail(prop.getProperty("Validcity"));
	}

	public void cityWeatherDetail() throws InterruptedException, CsvValidationException, IOException {
		hp = new HomePage(driver);

		hp.weatherInYourCity(getData());
	}


	private void weatherInYourCity(Object[] city) // weatherInYourCity
	{

		try {
			mainLogo.click();
			textField.sendKeys((CharSequence[]) city);
			textField.sendKeys(Keys.ENTER); // here we are testing with top search field
			// textField.sendKeys(null);
			Thread.sleep(5000);
			String weatherData = weatherStatus.getText();
			String weatherDatatwo = weatherStatustwo.getText();
			String cityname = weatheCityName.getText();

			System.out.println("---------------------------------------------------------------------------");
			System.out.println(cityname);
			System.out.println(weatherData);
			System.out.println(weatherDatatwo);
			System.out.println("---------------------------------------------------------------------------");

		} catch (Exception e) {
			// Thread.sleep(1000);
			System.out.println("**************** ");
			System.out.println("**INVALID CITY** ");
			System.out.println("**************** ");

		}

	}


	public Object[] getData() throws FileNotFoundException, IOException, CsvValidationException {

		List<String> data = new ArrayList<String>();

		try (FileReader reader = new FileReader(prop.getProperty("csvPath")); CSVReader read = new CSVReader(reader)) {
			String[] LocationData;
			while ((LocationData = read.readNext()) != null) {
				data.add(LocationData[0]);
			}
		}

		Object[] testData = new Object[data.size()];

		System.out.println("size :" + data.size());

		for (int i = 0; i <= data.size() - 1; i++) {
			testData[i] = data.get(i);
		}
		System.out.println(data);
		return testData;
	}

}
