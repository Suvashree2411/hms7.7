package hms.admintest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Appointmentpage;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;
import hms.utility.ReadExcel;

public class Addappointment extends Testbase {
	Loginpage objlog;
	Frontofficepage objff;
	Addappointment objdet;
	Appointmentpage objapp;
	
	
	public Addappointment()
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
	objff.clickonfrontoffice();
	objff.gettabletitle();
	objapp=new Appointmentpage();
	}
	
	@DataProvider
	public Object[][] addappointmentdetails()
	{
		Object[][]data=ReadExcel.getTestData("data1.0");
		return data;
	}
	
	@Test(dataProvider="addappointmentdetails")
	public void Addappointment(String app[])
	{
		objapp.clickaddapp();
		
		//objdet.addappointmentdetails(det);
		
		String Expectedboxtitle="Add Appointment";
		String Actualboxtitle=objapp.getscreentitle();
		
		Assert.assertEquals(Actualboxtitle, Expectedboxtitle);
		System.out.println("hai");
		objapp.addappointmentdetails(app);
	}
	
	}
	
	
	

