package com.tend.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tend.qa.base.Base;
import com.tend.qa.pages.LandingPage;

public class LandingPageTest extends Base{
	
	LandingPage landing;

	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initilization();
		landing = new LandingPage();

	}

	@Test(priority = 1)
	public void verify_Top_Menu_Item_Is_Displayed_And_Accessibile() {
		boolean flag = landing.validateTendableLogo();
		Assert.assertTrue(flag, "Tendable Logo is not displayed");
		boolean flag1 =landing.verifyOurStoryMenuItem();
		Assert.assertTrue(flag1, "Our Story Menu Item is not displayed");
		boolean flag2 =landing.verifyOurSolutionMenuItem();
		Assert.assertTrue(flag2, "Our Solution Menu Item is not displayed");
		boolean flag3 =landing.verifyWhyTendableMenuItem();
		Assert.assertTrue(flag3, "Why Tendable Menu Item is not displayed");
		landing.clickOnHomeMenuItem();
		landing.clickOnOurStoryMenuItem();
		landing.MouseHoverOnOurSolutionMenuItem();
		landing.clickOnWhyTendableMenuItem();
		landing.verifyRequestDemoButtonIsEnabledAndClickable();
	}
	
	@Test(priority = 2)
	public void verify_Request_Demo_Button_Is_Enable_And_Clickable_On_Each_Of_The_Aforementioned_Top_Level_Menu_pages(){
		landing.clickOnHomeMenuItem();
		landing.verifyRequestDemoButton();
		landing.verifyRequestDemoButtonIsEnabledAndClickable();
		landing.clickOnOurStoryMenuItem();
		landing.verifyRequestDemoButton();
		landing.verifyRequestDemoButtonIsEnabledAndClickable();
		landing.MouseHoverOnOurSolutionMenuItem();
		landing.verifyRequestDemoButton();
		landing.clickOnWhyTendableMenuItem();
		landing.verifyRequestDemoButton();
		landing.verifyRequestDemoButtonIsEnabledAndClickable();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
