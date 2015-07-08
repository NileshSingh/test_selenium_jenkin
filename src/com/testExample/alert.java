package com.testExample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alert {

	
	WebDriver driver;
	
	String baseuel = "http://10.129.50.4/";
	
	@Test
	public void testAlert() throws IOException 
	{
		driver.get(baseuel);
		
		driver.findElement(By.linkText("LANGUAGE")).click();
		
		Alert a1 = driver.switchTo().alert();
		String s1 = a1.getText();
		a1.accept();
		
		System.out.println("hiiii"+s1);
	}

	@BeforeMethod
	public void before() throws IOException
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void after() throws IOException
	{
		driver.quit();
	}
}

