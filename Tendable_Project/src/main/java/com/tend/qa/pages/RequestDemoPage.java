package com.tend.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tend.qa.base.Base;

public class RequestDemoPage extends Base{
	
	@FindBy(id = "form-input-requestType")
	WebElement useTendableDropdown;

	@FindBy(name ="name")
	WebElement nameTextbox;

	@FindBy(name = "email")
	WebElement emailTextbox;

	@FindBy(name = "cellPhone")
	WebElement phoneNumberTextbox;

	@FindBy(id = "form-input-jobRole")
	WebElement jobRoleDropdown;

	@FindBy(name = "organisationName")
	WebElement organisationNameTextbox;

	@FindBy(name = "sector")
	WebElement sectorDropdown;
	
	@FindBy(id = "form-input-howDidYouHearAboutUs")
	WebElement hearAboutUsTextbox;
	
	@FindBy(id = "form-input-consentAgreed-0")
	WebElement agreeButton;
	
	@FindBy(xpath = "//button[@name='form_page_submit'  and contains(text(),'Request')]")
	WebElement requestDemoButton;
	

	public RequestDemoPage() {
		PageFactory.initElements(driver, this);
	}

}
