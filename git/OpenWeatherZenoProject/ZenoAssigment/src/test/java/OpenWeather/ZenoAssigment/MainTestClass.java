package OpenWeather.ZenoAssigment;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import mainUtility.Base;

public class MainTestClass extends Base {

	public MapPage mp;
	public HomePage hp;
	public GuidePage gp;

	@BeforeTest

	public void engine() throws IOException {
		Base.property();
		Base.report();
	}

	@BeforeMethod
	public void start() throws InterruptedException, IOException {
		Base.launchBrowser();
	}

	@Test(enabled = false) // (dataProvider = "getData")
	public void cityWeather() throws InterruptedException {

		hp = new HomePage(driver);
		hp.cityDetail();
	}

	@Test(dataProvider = "getDataOne")
	public void weatherDetails(String city) throws InterruptedException {
		HomePage hp = new HomePage(driver); // Handle Stale Element Exception

		hp.weatherdetail(city);

	}

	@Test(dataProvider = "getDataOne")
	public void weatherInYourCity(String city) throws InterruptedException, CsvValidationException, IOException {

		hp = new HomePage(driver);

		hp.weatherInYourCity(city);

	}

	@Test(enabled = false)
	public void mapLayer() throws InterruptedException {

		mp = new MapPage(driver);

		mp.clickMapIcon();

		mp.temp();

		mp.press();

		mp.cloud();

		mp.gPresp();

		mp.windspe();
	}

	
	@Test
	public void guidePage()
	{
		gp = new GuidePage(driver);
		
		gp.clickGuideIcon();
		
		System.out.println("click on guide link");
	}
	
	
	
	@DataProvider
	public static Object[] getDataOne() throws CsvValidationException, IOException {

		HomePage hp1 = new HomePage(driver);

		return hp1.getData();

	}

	@AfterMethod
	public void stop() {
		driver.close();
	}

}
