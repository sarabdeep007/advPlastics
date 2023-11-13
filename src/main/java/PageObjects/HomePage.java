package PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents{
	
	WebDriver driver;
	private Logger logger = (Logger) LogManager.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//locators
	@FindBy(xpath="//a[@href]")
	private List<WebElement> allPageLinks;
	
	
	
	public void checkLinks()
	{
		ArrayList<String> failedLinks = new ArrayList<String>();
		
		int goodLinks = 0;
		int averageLinks=0;
		int badLinks = 0; 
		
		for(int i=0; i<allPageLinks.size(); i++)
		{
			
			
			String url = allPageLinks.get(i).getAttribute("href");
			int responseCode=0;
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setRequestMethod("HEAD");
				 responseCode = connection.getResponseCode();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(responseCode>200 && responseCode < 400)
			{
				failedLinks.add(url + " : " + responseCode);
				goodLinks++;
				
			}
			else if(responseCode<200)
			{
				failedLinks.add(url + " : " + responseCode);
				averageLinks++;
			}
			
			else if(responseCode>400)
			{
				badLinks++;
			}
			
			System.out.println(allPageLinks.get(i).getAttribute("href") + " - the response is: "+responseCode);
			System.out.println(allPageLinks.get(i).getAttribute("class"));
			logger.info("The Total Links are: "+allPageLinks.size());
			logger.info("The good Links are: "+goodLinks);
			logger.info("The Average Links are: "+averageLinks);
			logger.info("Total Bad Links are: "+badLinks);
			
			
		}
		
		System.out.println("The above 200 codes links are: " + failedLinks);
		
		System.out.println("the size is: "+allPageLinks.size());
		System.out.println("hello in checklinks");
		System.out.println(driver.getTitle());
	}
	
	
	
}
