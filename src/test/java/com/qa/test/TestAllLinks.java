package com.qa.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.NetworkUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAllLinks {
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
	  @Test
	  public void brokenLinkTest() throws MalformedURLException, IOException {
		List<WebElement> LinkList =driver.findElements(By.tagName("a")); 
		LinkList.addAll(driver.findElements(By.tagName("Img")));
		System.out.println("Total ActiveLinks and Images"+LinkList.size());
	    List<WebElement> ActiveLinks= new ArrayList<WebElement>();
	    for(int i=0;i<LinkList.size();i++) {
	    if (LinkList.get(i).getAttribute("href")!=null)
	    {
	    	ActiveLinks.add(LinkList.get(i));
	    }
	    }	
	    System.out.println("Total ActiveLinks and Images"+ActiveLinks.size());
	    for(int j=0;j<ActiveLinks.size();j++)
	    {
	    HttpURLConnection connection =	(HttpURLConnection)new URL(ActiveLinks.get(j).getAttribute("href")).openConnection();
	    connection.connect();
	    String response=connection.getResponseMessage();
	    connection.disconnect();
	    System.out.println(ActiveLinks.get(j).getAttribute("href")+"------->" +response);
	    }
	    
	    
	    
		  
		  
	  }
	  @AfterClass
	    public void teardownBrowser() {
	  	  driver.close();
	  	  
	    }
	  
	  

}
