package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Commonutility;

public class Appointmentpage extends Testbase {
	 //@FindBy(xpath ="//h3[text()='Appointment Details']")WebElement tabletxt;
	 @FindBy(css="div.pull-right>a")WebElement addappointment;
	 @FindBy(xpath="//h4[text()='Add Appointment']")WebElement screentitle;
	 
	 @FindBy(css="form#formadd input[name='date']")WebElement date;
	 @FindBy(css="form#formadd input[name='patient_id']")WebElement pid ;
	 @FindBy(css="form#formadd input[name='patient_name']")WebElement pname;
	 @FindBy(css="form#formadd select[name='gender']")WebElement pgender;
	 @FindBy(css="form#formadd input[name='email']")WebElement pemail;
	 @FindBy(css="form#formadd input[name='mobileno']")WebElement phno; 
	 @FindBy(css="form#formadd textarea[name='message']")WebElement pmes;
	 @FindBy(css="form#formadd select[name='appointment_status']")WebElement pstatus;
	 @FindBy(css="form#formadd select[name='doctor']")WebElement doctor;
	 
	 //@FindBy(css="button.btn")WebElement save;//
	 
	 public Appointmentpage()
	 {
		 PageFactory.initElements(driver, this);	 
	 }
	 
	
	 public void clickaddapp() {
		 Commonutility.waitforelement(addappointment);
		 addappointment.click();
	 }
	 
	 public String getscreentitle()
	 {
		 Commonutility.waitforelement(screentitle);
		 return screentitle.getText();
	 }
	 public void addappointmentdetails(String data[])

	 {
		 date.sendKeys(data[0]);
		 Select drp=new Select(pgender);
		 drp.selectByVisibleText(data[3]);
		 
		 pid.sendKeys(data[1]);
		 pname.sendKeys(data[2]);
		 pemail.sendKeys(data[4]);
		 phno.sendKeys(data[5]);
		 doctor.sendKeys(data[6]);
		 pmes.sendKeys(data[7]);
		 pstatus.sendKeys(data[8]);	 
	 }
	
	}

