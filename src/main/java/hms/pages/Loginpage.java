package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.javac.jvm.Profile;

import hms.base.Testbase;

public class Loginpage extends Testbase 
{
  @FindBy(css="img[src='http://triotend.com/tts/backend/images/s_logo.png']")WebElement logo;
  @FindBy(css="h3.font-white")WebElement screentitle;
  @FindBy(css="input#email")WebElement usertxt;
  @FindBy(css="input#password")WebElement passtxt;
  @FindBy(css="button.btn")WebElement signin;
  @FindBy(css="img.topuser-image")WebElement profile;
  @FindBy(css="div.sspass>a:nth-child(3)")WebElement logout;
  
  public Loginpage()
  {
	  PageFactory.initElements(driver, this);
  }
  //to get page title
  public String getpagetitle()
  {
	  return driver.getTitle();
  }
  
  //Is logo displayed
  public boolean logocheck() 
  {
	  return logo.isDisplayed();
  }
  
  //To get the screen title
  public String getscreentitle()
  {
	return screentitle.getText();
  }
  //Login method
  public void loginhms(String uname,String upass)
  {
	  usertxt.sendKeys(uname);
	  passtxt.sendKeys(upass);
	  signin.click();
  }
  //Logout page
  public void logouthms()
  {
	  profile.click();
	  logout.click();
  }
  
  
  
}

