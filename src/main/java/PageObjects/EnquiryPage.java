package PageObjects;

import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponents;

public class EnquiryPage extends AbstractComponents{
	
	WebDriver driver;

	public EnquiryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


}
