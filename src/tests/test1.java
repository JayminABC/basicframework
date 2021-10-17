package tests;

import org.testng.annotations.Test;

import pages.test1page;
import utilities.Xls_Reader;

import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
public class test1 {
	test1page tp = new test1page();
	Xls_Reader rd = new Xls_Reader("C:\\Testing\\Test1Data.xlsx");
	
	String wrongemail = rd.getCellData("Sheet1","Username", 2);
	String wrongpassword = rd.getCellData("Sheet1","Password", 2);
	String wrongemail1 = rd.getCellData("Sheet1","Username", 3);
	String wrongpassword1 = rd.getCellData("Sheet1","Password", 3);
	
	
  @Test
  public void LoginwithwrongEmailandPassword() throws InterruptedException {
	  
	  tp.login(wrongemail,wrongpassword);
	  tp.error();
	  
  }
  
	  @Test
	  public void LoginwithEmptyEmail() throws InterruptedException {
		  
		  tp.login("",wrongpassword1);	 
		  tp.error();
  }  
		@Test
		  public void LoginwithEmptyPassword() throws InterruptedException {
			  
	tp.login(wrongemail1,"");
	tp.error();
  }
		
  @BeforeMethod
  public void beforeMethod() throws IOException {
	 tp.openbrowser();
	 tp.openurl();
  }
  
  @AfterMethod
  public void afterMethod() {
	  tp.close();
  }
}
