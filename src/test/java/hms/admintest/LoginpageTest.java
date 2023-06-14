package hms.admintest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpage;

public class LoginpageTest extends Testbase {
	
	Loginpage objlog;
	 public LoginpageTest()
	 {
		 super();
	 }

	 @BeforeMethod
	 public void setup()
	 {
		 initialization();
		 objlog=new Loginpage();
	 }
	 
	 @Test
	 public void hmsadmintest()
	 {
		 String Expectedpagetitle="Smart Hospital : Hospital Management System";
		 String Actualpagetitle=objlog.getpagetitle();
		 
		 Assert.assertEquals(Actualpagetitle, Expectedpagetitle);
		 Assert.assertTrue(objlog.logocheck());
		 
		 String ExpectedScreentitle="Admin Login";
		 String ActualScreentitle=objlog.getscreentitle();
		 
		 Assert.assertEquals(ActualScreentitle, ExpectedScreentitle);
		 objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		 
		 objlog.logouthms();
	 }
	 @AfterMethod
	 public void teardown()
	 {
		 driver.close();
	 }
}


