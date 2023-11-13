package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.util.Assert;

import AbstractComponents.AbstractComponents;
import Resources.Constants;

public class AboutUsPage extends AbstractComponents {

	WebDriver driver;

	public AboutUsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


}
