package hms.admintest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;

public class FrontofficeTest extends Testbase {
	
	Loginpage objlog;
	Frontofficepage objff;
	
	public FrontofficeTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new Loginpage();
		objff=new Frontofficepage();
		
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	@Test
	public void frontofficetest()
	{
		objff.clickonfrontoffice();
		String Expectedtabletitle="Appointment Details";
		String Actualtabletitle=objff.gettabletitle();
		
		Assert.assertEquals(Expectedtabletitle, Actualtabletitle);
		
		objff.clickonvisitorbook();
	}
}
