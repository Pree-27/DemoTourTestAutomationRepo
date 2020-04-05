package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class OneWayFowTest {
	WebDriver driver;
	
	  @BeforeClass
	  public void launchBrowser() {
		  
		System.setProperty("webdriver.chrome.driver","D:\\Preethi\\Softwares\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com/");
		 }
	  
}
