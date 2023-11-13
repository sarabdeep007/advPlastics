package Tests;

import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import Resources.Constants;
import TestComponents.BaseTest;
import AbstractComponents.AbstractComponents;

public class checkPagesVisit extends BaseTest {

	HomePage homePage;
	Logger logger = (Logger) LogManager.getLogger(checkPagesVisit.class);

	@BeforeMethod
	public void methodSetup() {
		homePage = new HomePage(driver);
	}
	
	
	@Test
	public void checkAboutUsPageVisits()
	{
		homePage.getAboutUs();
		Assert.assertEquals(Constants.PAGE_TITLE_ABOUT_US, homePage.verifyPageTitle());
		logger.info("title verfied for "+homePage.verifyPageTitle());
		
	}
	
	@Test
	public void checkLensesPageVisit()
	{
		homePage.getLensesPage();
		Assert.assertEquals(Constants.PAGE_TITLE_LENSES, homePage.verifyPageTitle());
		logger.info("title verfied for "+homePage.verifyPageTitle());
	}
	
	@Test
	public void checkPartsOfSpeedoMeterPageVisit()
	{
		homePage.getPartsOfSpeedoMeterPage();
		Assert.assertEquals(Constants.PAGE_TITLE_PARTSOFSPEEDOMETER, homePage.verifyPageTitle());
		logger.info("title verfied for "+homePage.verifyPageTitle());
	}
	
	@Test
	public void checkEnquiryageVisit()
	{
		homePage.getEnquiryPage();
		Assert.assertEquals(Constants.PAGE_TITLE_ENQUIRY, homePage.verifyPageTitle());
		logger.info("title verfied for "+homePage.verifyPageTitle());
	}
	
		

//
//	@Test(dataProvider = "pages")
//	public void verifyPageHeading(Supplier<AbstractComponents> providePageData, String expectedTitle  ) {
//		String actualTitle = homePage.getLensesPage().verifyPageTitle();
//		String expectedTitle = Constants.PAGE_TITLE_LENSES;
//		Assert.assertEquals(expectedTitle, actualTitle);
//		logger.info("Page Title matches the expected Title");
//
//	}
//
//	@DataProvider(name = "pages")
//	public Object[][] providePageData() {
//
//		return new Object[][] 
//		{ 
//			{ () -> homePage.getLensesPage(), Constants.PAGE_TITLE_LENSES },
//			{ () -> homePage.getAboutUsPage(), Constants.PAGE_TITLE_ABOUT_US },
//				// ... Add other pages and their titles here
//		};
//	}
}
