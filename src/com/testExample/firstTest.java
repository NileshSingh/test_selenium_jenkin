package com.testExample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class firstTest {

	WebDriver driver;
	String baseURL;
	
	@Test
	public void testAction() throws IOException 
	{
		 driver.findElement(By.linkText("Log in")).click();
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("raj88.007@gmail.com");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("design12345");
		    driver.findElement(By.id("remember-yes")).click();
		    driver.findElement(By.id("submit")).click();
		    driver.findElement(By.linkText("edit")).click();
		    driver.findElement(By.id("new_name_field")).clear();
		    driver.findElement(By.id("new_name_field")).sendKeys("Shivaji");
		    driver.findElement(By.id("name_rationale_field")).clear();
		    driver.findElement(By.id("name_rationale_field")).sendKeys("Real name");
		    driver.findElement(By.cssSelector("fieldset > div.submit > #submit")).click();
		    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
		    driver.findElement(By.xpath("html/body/div[1]/header/nav/ol[2]/li[2]/a")).click();
        
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("firefox")){
			 
	        //create firefox instance
	 
	            driver = new FirefoxDriver();
	 
	        }
	 
	        //Check if parameter passed as 'chrome'
	 
	        else if(browser.equalsIgnoreCase("chrome")){
	 
	            //set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver
	 
	            System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	 
	            //create chrome instance
	 
	            driver = new ChromeDriver();
	 
	        }
	        else{
	 
	            //If no browser passed throw exception
	 
	            throw new Exception("Browser is not correct");
	 
	        }
	 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.129.50.4/");
		
		
	}
	@AfterMethod
	public void aftermethod()
	{
		driver.quit();
	}
	
	
}
