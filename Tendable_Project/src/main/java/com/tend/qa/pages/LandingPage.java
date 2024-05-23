package com.tend.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tend.qa.base.Base;
import com.tend.qa.util.Utils;

public class LandingPage extends Base {


	@FindBy(xpath = "//img[contains(@alt,'Tendable Logo')]")
	WebElement tendableLogo;

	@FindBy(xpath = "//a[@class='menu-item' and contains(text(),'Our Story ')]")
	WebElement ourStoryMenuItem;

	@FindBy(xpath = "//a[@class='menu-item' and contains(text(),'Our Solution ')]")
	WebElement ourSolutionMenuItem;

	@FindBy(xpath = "//a[@class='menu-item' and contains(text(),'Why Tendable? ')]")
	WebElement whyTendableMenuItem;

	@FindBy(xpath = "//a[@class='menu-item' and contains(text(),'About Us ')]")
	WebElement aboutUsMenuItem;

	@FindBy(xpath = "//a[@class ='button inverted' and contains(text(),'Contact Us')]")
	WebElement contactUsButton;

	@FindBy(xpath = "//a[contains(text(),'Request A Demo')]")
	WebElement requestDemoButton;


	public LandingPage() {
		PageFactory.initElements(driver, this);
	}



	public boolean validateTendableLogo() {
		return tendableLogo.isDisplayed();
	}
	
	public void clickOnHomeMenuItem() {
		tendableLogo.click();
	}

	public boolean verifyOurStoryMenuItem() {
		boolean flag = ourStoryMenuItem.isDisplayed();
		return flag;
	}

	public void clickOnOurStoryMenuItem() {
		ourStoryMenuItem.click();
	}

	public boolean verifyOurSolutionMenuItem() {
		boolean flag = ourSolutionMenuItem.isDisplayed();
		return flag;
	}
	
	public void MouseHoverOnOurSolutionMenuItem() {
		Utils.waitUntilClickable(driver, ourSolutionMenuItem);
		Actions action = new Actions(driver);
		action.moveToElement(ourSolutionMenuItem).build().perform();
//		driver.switchTo().defaultContent();
	}

	public boolean verifyContactUsButton() {
		boolean flag = contactUsButton.isDisplayed();
		return flag;
	}

	public void verifyContactUsButtonIsEnabledAndClickable() {
		Utils.waitUntilClickable(driver, contactUsButton);
		contactUsButton.isEnabled();
		contactUsButton.click();
	}

	public boolean verifyWhyTendableMenuItem() {
		boolean ourStory = whyTendableMenuItem.isDisplayed();
		return ourStory;
	}
	
	public void clickOnWhyTendableMenuItem() {
		Utils.waitUntilClickable(driver, whyTendableMenuItem);
		whyTendableMenuItem.click();
	}
	
	
	public boolean verifyRequestDemoButton() {
		boolean flag = requestDemoButton.isDisplayed();
		return flag;
	}
	
	public void verifyRequestDemoButtonIsEnabledAndClickable() {
		Utils.waitUntilClickable(driver, requestDemoButton);
		Utils.clickOn(driver, requestDemoButton, Duration.ofSeconds(20));
	}
	
}
