package AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjects.AboutUsPage;
import PageObjects.EnquiryPage;
import PageObjects.HomePage;
import PageObjects.LensesPage;
import PageObjects.PartsOfSpeedoMeterPage;

public class AbstractComponents {
	
	WebDriver driver;
	Actions actions;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='HOME']")
	private WebElement homePageButton;
	
	@FindBy(xpath = "//a[normalize-space()='ABOUT US']")
	private WebElement aboutUsButton;
	
	@FindBy(xpath = "//a[normalize-space()='GALLERY']")
	private WebElement galleryButton;
	
	@FindBy(xpath = "//a[normalize-space()='CARRIER']")
	private WebElement carrierButton;
	
	@FindBy(xpath = "//a[normalize-space()='INDUSTRIAL']")
	private WebElement industrialButton;
	
	@FindBy(xpath = "//a[normalize-space()='AUTOMOTIVE']")
	private WebElement industrialAutomotiveButton;
	
	@FindBy(xpath = "//a[normalize-space()='PARTS OF SPEEDOMETER']")
	private WebElement industrialAutomotivePartsOfSpeedoMeterButton;
	
	@FindBy(xpath = "//a[normalize-space()='LENSES']")
	private WebElement lensesIndustrialAutomotiveButton;
	
	@FindBy(xpath = "//a[normalize-space()='ENQUIRY']")
	private WebElement enquiryPageButton;
	
	@FindBy(xpath = "//h1")
	private WebElement pageHeading;
	
	
	
	
	//methods
	
	public HomePage getHomePage()
	{
		homePageButton.click();
		return new HomePage(driver);
	}
	public AboutUsPage getAboutUs()
	{
		aboutUsButton.isDisplayed();
		aboutUsButton.click();
		return new AboutUsPage(driver);
	}
	
	public LensesPage getLensesPage()
	{
		actions.moveToElement(industrialButton).build().perform();
		actions.moveToElement(industrialAutomotiveButton).build().perform();
		lensesIndustrialAutomotiveButton.click();
		return new LensesPage(driver);
		
		
	}
	
	public PartsOfSpeedoMeterPage getPartsOfSpeedoMeterPage()
	{
		actions.moveToElement(industrialButton).build().perform();
		actions.moveToElement(industrialAutomotiveButton).build().perform();
		industrialAutomotivePartsOfSpeedoMeterButton.click();
		return new PartsOfSpeedoMeterPage(driver);
		
		
	}
	
	public EnquiryPage getEnquiryPage()
	{
		enquiryPageButton.click();
		return new EnquiryPage(driver);
		
	}
	public String verifyPageTitle()
	{
		String actualHeading = pageHeading.getText();
		return actualHeading;
	}
	
	
	

}
