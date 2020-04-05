package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginPage {
	
	WebDriver driver;
	
  @BeforeClass
  public void launchBrowser() {
	  
	System.setProperty("webdriver.chrome.driver","D:\\Preethi\\Softwares\\Driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("http://newtours.demoaut.com/");
	 }
  @Test(priority=4)
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
  @Test(priority=1)
 public void logInWithValidUnameInvalidPassword() {
	  driver.findElement(By.name("userName")).sendKeys("preethi27j@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("test1234!");
	  driver.findElement(By.name("login")).click();
	  String Actual=driver.getTitle();
	  String Expected= "Find a Flight:Mercury Tours:";
	  String Message="Test passed";
	  Assert.assertNotEquals(Actual,Expected, Message);
  }
	  
  	  

 
  @Test(priority=2)
  public void logInWithInvalidUnamevalidPassword() {
	  driver.findElement(By.name("userName")).sendKeys("preethi@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("test@1234!");
	  driver.findElement(By.name("login")).click();
	  String Actual=driver.getTitle();
	  String Expected= "Find a Flight:Mercury Tours:";
	  String Message="Test passed";
	  Assert.assertNotEquals(Actual,Expected, Message);
	  
  	  

    }
  @Test(priority=3)
  public void logInWithInvalidUnameInvalidPassword() {
	  driver.findElement(By.name("userName")).sendKeys("preethi@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("test1234!");
	  driver.findElement(By.name("login")).click();
	  String Actual=driver.getTitle();
	  String Expected= "Find a Flight:Mercury Tours:";
	  String Message="Test passed";
	  Assert.assertNotEquals(Actual,Expected, Message);
  	  

    }
    
 @AfterClass
    public void teardownBrowser() {
  	  driver.close();
  	  
    }
  
  
}
