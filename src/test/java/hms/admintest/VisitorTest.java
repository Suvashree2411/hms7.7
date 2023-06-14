package hms.admintest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;
import hms.pages.VisitorPage;
import hms.utility.ReadExcel;

public class VisitorTest extends Testbase {
	
	Loginpage objlog;
	Frontofficepage objff;
	VisitorPage objvis;
	
	public VisitorTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new Loginpage();
		objlog.loginhms(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	
		objff=new Frontofficepage();
		objff.clickonfrontoffice();
		objff.clickonvisitorbook();
		
		objvis =new VisitorPage();	
	}
	@DataProvider
	public Object[][] getvisitordata()
	{
		Object[][]data=ReadExcel.getTestData("testdata");
		return data;
	}
	@Test(dataProvider="getvisitordata")
	public void visitordetailstest(String vis[])
	{
		String Expectedtabletitle="Visitor List";
		String Actualtabletitle=objvis.gettabletitle();
		
		Assert.assertEquals(Expectedtabletitle, Actualtabletitle);
		
		objvis.clickonaddvisitor();
		
		String Expectedscreentitle="Add Visitor";
		String Actualscreentitle=objvis.getscreentitle();
		
		Assert.assertEquals(Actualscreentitle, Expectedscreentitle);
		objvis.addvisitordetails(vis);
	}
}
