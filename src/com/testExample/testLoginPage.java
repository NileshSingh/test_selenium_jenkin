package com.testExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;



public class testLoginPage {
	public WebDriver driver;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/testJDBC";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   String Module,Path,Description,Exp_output,act_output,priority,Status,Executed_by;
 

  @Test
  public void testLoginPage() {
   
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
    Status="Fail";
    InsertData();
  }

  private void InsertData() {
	// TODO Auto-generated method stub
	  
	  Connection conn = null;
	   PreparedStatement statement = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      
	      
	      
	      
	      Module = "Login Screen";
	      Path= "http://10.129.50.4/login";
	      Description= "Varify and validate userId and Password for login in IITBombayX";
	      Exp_output= "user should validate while login and access their account ";
	      act_output = "As Expected";
	      priority= "Low";
	      Executed_by="Deepak Shinde";
	      Status="Pass";
	      
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Inserting records into the table...");
	            
	      //String sql = "INSERT INTO test2 (Date, Module, Test_Case, Description, Expected_output, Actual_output, Executed_By, prority, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	      statement = conn.prepareStatement("INSERT INTO test2 (Date, Module, Path, Test_Case_Description, Expected_output, Actual_output, Executed_By, priority, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
	      
	      statement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
	      statement.setString(2, Module);
	      statement.setString(3, Path);
	      statement.setString(4, Description);
	      statement.setString(5, Exp_output);
	      statement.setString(6, act_output);
	      statement.setString(7, Executed_by);
	      statement.setString(8, priority);
	      statement.setString(9, Status);
	      
	      statement.executeUpdate();
	      
	      System.out.println("Inserted records into the table...");

	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(statement!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	


@BeforeMethod
  public void beforeMethod() {
	  
	  // Create a new instance of the Firefox driver

      driver = new FirefoxDriver();

      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      //Launch the Online Store Website

      driver.get("http://10.129.50.4/");

  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }
}
