package Tests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import TestComponents.BaseTest;

public class FirstTest extends BaseTest{
	
	
	private HomePage homePage;
	private Logger logger = (Logger) LogManager.getLogger(FirstTest.class);
	
	@BeforeMethod
	public void methodSetup()
	{
		homePage = new HomePage(driver);
	}
	
	
	
	
	
	@Test
	public void verifyLinksOnThePage() throws MalformedURLException, IOException
	{
		
		homePage.checkLinks();
		System.out.println("hello to");
		System.out.println(driver.getTitle());
	}

	
}
