package com.tend.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tend.qa.base.Base;
import com.tend.qa.pages.ContactUsPage;
import com.tend.qa.pages.LandingPage;

public class ContactPageTest extends Base {
	
	LandingPage landing;
	ContactUsPage contact;

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initilization();
		landing = new LandingPage();
		landing.verifyContactUsButtonIsEnabledAndClickable();
		contact = new ContactUsPage();

	}
	
	@Test(priority = 1)
	public void verify_Error_Message_On_Form_Details_For_Contact_Page_For_Marketing_Section() {
		contact.clickOnContactButtonOnMarketingSection();
		contact.enterFullName(pr.getProperty("name"));
		contact.enterOrganisationName(pr.getProperty("org"));
		contact.enterEmail(pr.getProperty("email"));
		contact.enterPhoneNumber(pr.getProperty("phoneNumber"));
		contact.selectJobRole(pr.getProperty("jobRole"));
		contact.checkAgreeOption();
		contact.submitDetails();
		String actualError =contact.getErrorMessage();
		Assert.assertEquals(actualError, pr.getProperty("errorMessage"), "Error Message is not displayed correctly");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
