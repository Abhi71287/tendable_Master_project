package com.tend.qa.util;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static void clickOn(WebDriver driver, WebElement locator, Duration seconds) {
		new WebDriverWait(driver, seconds).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}
	
	public static void scrollToElement(WebDriver driver, WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void waitUntilClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	

}
