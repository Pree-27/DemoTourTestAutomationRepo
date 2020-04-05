package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRadioButtonDropDown {
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
	  @Test(priority=1)
	  public void logInWithValidData() {
		  
		  driver.findElement(By.name("userName")).sendKeys("preethi27j@gmail.com");
		  driver.findElement(By.name("password")).sendKeys("test@1234!");
		  driver.findElement(By.name("login")).click();
		  String Actual=driver.getTitle();
		  String Expected= "Find a Flight: Mercury Tours:";
		  String Message="Test passed";
		  Assert.assertEquals(Actual,Expected, Message);
		  driver.findElement(By.linkText("SIGN-OFF"));
		  
		  
		  
		  
		  
	  }
	  @Test(priority=2)
	  public void radiobuttonTest() {
		  WebElement Radio1 = driver.findElement(By.xpath("//input[@value='roundtrip']"));
		  WebElement Radio2 = driver.findElement(By.xpath("//input[@value='oneway']"));
		  Radio1.click();
		  Radio2.click();
		  System.out.println("Is Radio Button for roundtrip Selected??---->" +Radio1.isSelected());
		  System.out.println("Is Radio Button for oneway Selected??---->" +Radio2.isSelected());
		 
		 
	  }

}
