package hms.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import hms.utility.Activitycapture;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eve;
	public static Activitycapture acp;

	public Testbase() {
		try {
			FileInputStream ipconfig = new FileInputStream("./src/main/java/hms/config/appconfig.properties");
			prop = new Properties();
			prop.load(ipconfig);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization()
	  {
		  String browsername=prop.getProperty("BROWSER");
		  if(browsername.equals("chrome"))
		  {
			  if(prop.getProperty("HEADLESS").equals("true"))
			  {
				  ChromeOptions opt=new ChromeOptions();
				  opt.addArguments("--headless--");
				  
			      driver=new ChromeDriver(opt);
			  }
			  else
			  {
			  driver=new ChromeDriver();
			  }
		  }   
			  else if(browsername.equals("firefox"))
		           {
			         driver=new FirefoxDriver();  
		           }
		        else if(browsername.equals("edge"))
		           {
		             driver=new EdgeDriver();
		           }
		  else
		  {
			  System.out.println("Invalid Browser name");
		  }	   
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		  driver.manage().deleteAllCookies();
		  driver.manage().window().maximize(); 
		  driver.get(prop.getProperty("URL"));
		  
		  acp=new Activitycapture();
		  eve=new EventFiringWebDriver(driver);
		  eve.register(acp);
		  driver=eve;
		  }
}
