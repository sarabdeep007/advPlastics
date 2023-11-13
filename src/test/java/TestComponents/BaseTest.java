package TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.HomePage;

public class BaseTest {
	
	
	public WebDriver driver;
	private String configFilePath = System.getProperty("user.dir")+"/src/main/java/Resources/Config.properties";
	private FileInputStream fileInputStream;
	private Properties properties;
	
	
	public WebDriver initSetup()
	{
		properties = new Properties();
		try {
			fileInputStream = new FileInputStream(configFilePath);
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//String browserName = (System.getProperty("browser")==null) ? properties.getProperty("browser") : System.getProperty("browser");
		
		String browserName = properties.getProperty("browser");
		
		switch(browserName)
		{
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable --notifications");
				
				if("true".equals(System.getProperty("headless")))
				{
					chromeOptions.addArguments("--headless");
				}
				
				driver = new ChromeDriver(chromeOptions);
				
		}
		
		//driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(properties.getProperty("implicitWait"))));
		
		return driver;
		
	}
	
	public String getScreenShot(String testName, WebDriver driver) throws IOException {
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyy_HHmmSS");

		String dateTime = dt.format(dtf);

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				System.getProperty("user.dir") + "/Screenshots/" + testName + "_" + dateTime + ".png");

		FileUtils.copyFile(source, destination);

		return System.getProperty("user.dir") + "/Screenshots/" + testName + "_" + dateTime + ".png";

	}
	
	
	
	@BeforeMethod
	public HomePage launchApp()
	{
		driver = initSetup();
		driver.get(properties.getProperty("url"));
		
		HomePage homePage = new HomePage(driver);
		
		return homePage;
				
	}
	
	

	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
			driver.close();
	}
	

}
