package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelData;

public class ProjectSpecificMethods {

	public RemoteWebDriver driver;

	public String excelFileName;

	public Properties prop;

	@Parameters({ "browser", "language" })
	@BeforeMethod
	public void preCondition(String browser, String lang) throws IOException {

		// Properties file setup
		FileInputStream fis = new FileInputStream("./src/main/resources/" + lang + ".properties");
		prop = new Properties();
		prop.load(fis);

		// driver initialization
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		} else if (browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
		} else if (browser.equalsIgnoreCase("Edge"))

		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();

	}

	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		ReadExcelData red = new utils.ReadExcelData();
		String[][] data = red.readExcel(excelFileName);
		return data;
	}

}
