package com.tend.qa.pages;

import java.time.Duration;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tend.qa.base.Base;
import com.tend.qa.util.Utils;

public class ContactUsPage extends Base {

	@FindBy(xpath = "//div[contains(text(),'Marketing')]/following-sibling::div/button[text()='Contact']")
	WebElement marketingContactButton;

	@FindBy(name = "fullName")
	WebElement fullNameTextbox;

	@FindBy(name = "organisationName")
	WebElement organisationNameTextbox;

	@FindBy(name = "cellPhone")
	WebElement phoneNumberTextbox;

	@FindBy(name = "email")
	WebElement emailTextbox;

	@FindBy(id = "form-input-jobRole")
	WebElement jobRoleDropdown;

	@FindBy(id = "form-input-message")
	WebElement messageTextBox;

	@FindBy(id = "form-input-consentAgreed-0")
	WebElement agreeButton;

	@FindBy(xpath = "//button[@data-loading-text='Loading...' and (contains(text(),'Submit'))]")
	WebElement submitButton;

	@FindBy(xpath = "//div[@class=\"ff-form-errors\"]/p")
	WebElement errorMessage;

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnContactButtonOnMarketingSection() {
		marketingContactButton.click();
	}

	public void enterFullName(String name) {
		fullNameTextbox.sendKeys(name);
	}

	public void enterOrganisationName(String orgName) {
		organisationNameTextbox.sendKeys(orgName);
	}

	public void enterPhoneNumber(String number) {
		phoneNumberTextbox.sendKeys(number);
	}

	public void enterEmail(String email) {
		emailTextbox.sendKeys(email);
	}

	public void selectJobRole(String jobRole) {
		Select select = new Select(jobRoleDropdown);
		select.selectByVisibleText(jobRole);
	}

	public void enterMessage(String message) {
		messageTextBox.sendKeys(message);
	}

	public void checkAgreeOption() {
		Utils.scrollToElement(driver, agreeButton);
		Utils.waitUntilClickable(driver, agreeButton);
		agreeButton.click();
	}

	public void submitDetails() {
		Utils.scrollToElement(driver, submitButton);
		submitButton.click();
	}

	public String getErrorMessage() {
		String actualError = errorMessage.getText();
		return actualError;
	}

}
