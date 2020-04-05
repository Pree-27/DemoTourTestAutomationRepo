package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRegistrationPage {
	WebDriver driver;
	
	  @BeforeClass
	  public void launchBrowser() {
		  
		System.setProperty("webdriver.chrome.driver","D:\\Preethi\\Softwares\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com/");
		 }
	  @Test
	  public void registerUser() {
		  
		  driver.findElement(By.linkText("Register here")).click();
		  driver.findElement(By.name("firstName")).sendKeys("Tester");
		  driver.findElement(By.name("lastName")).sendKeys("Test");
		  driver.findElement(By.name("phone")).sendKeys("+91 9741484382");
		  driver.findElement(By.id("userName")).sendKeys("crowdtest101@gmail.com");
		  driver.findElement(By.name("address1")).sendKeys("#401 Pearl Tower");
		  driver.findElement(By.name("address2")).sendKeys("NY,Newyork");
		  driver.findElement(By.name("city")).sendKeys("Newark");
		  driver.findElement(By.name("state")).sendKeys("NewYork");
		  driver.findElement(By.name("postalCode")).sendKeys("90001");
		  Select select =new Select(driver.findElement(By.name("country")));
		  select.selectByVisibleText("UNITED STATES");
		  driver.findElement(By.name("email")).sendKeys("preethi27j@gmail.com");
		  driver.findElement(By.name("password")).sendKeys("test@1234!");
		  driver.findElement(By.name("confirmPassword")).sendKeys("test@1234!");
		  
		  driver.findElement(By.name("register")).click();
		  
		  
		  
		  
	  }
	  @AfterClass
	    public void teardownBrowser() {
	  	  driver.close();
	  	  
	    }
	  

}
