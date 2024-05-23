package com.tend.qa.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public static WebDriver driver;
	public static Properties pr;

	public Base() {
		File f = new File("../Tendable_Project/src/main/java/com/tend/qa/config/config.properties");
		try {
			FileReader fr = new FileReader(f);
			pr = new Properties();
			pr.load(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initilization() {
		String browserName = pr.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pr.getProperty("url"));

	}

}
