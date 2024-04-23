package mainUtility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.collections.FactoryUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVReader;

public class Base extends Action {

	public static WebDriver driver;
	public static Properties prop;
	public static FileReader reader;
	public static ExtentReports reprt;
	public static CSVReader read;

	public static void property() throws IOException {
		prop = new Properties();
		String filePath = "C:\\Users\\ymadh\\git\\OpenWeatherZenoProject\\ZenoAssigment\\src\\main\\java\\TestFile\\data.properties";
		FileReader readerProp = new FileReader(filePath);
		prop.load(readerProp);
	}

	public static void report() {
		String path = prop.getProperty("ReportPath");
//		StringBuffer

		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("ExtentReport");
		report.config().setReportName("TestIng NG report");

		reprt = new ExtentReports();
		reprt.attachReporter(report);
		reprt.setSystemInfo("Tester", "Madhu");
	}

	public static void launchBrowser() throws InterruptedException

	{

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

	}
	
}	


