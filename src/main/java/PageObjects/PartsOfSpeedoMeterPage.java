package PageObjects;

import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponents;

public class PartsOfSpeedoMeterPage extends AbstractComponents{
	
	WebDriver driver;

	public PartsOfSpeedoMeterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


}
