package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Commonutility;

public class Complainlist extends Testbase {
	//@FindBy(xpath ="//h3[text()='Appointment Details']")WebElement tabletext;//
	@FindBy(css="div.box-tools>a")WebElement addcomplain;
	@FindBy(xpath="//h3[text()='Complain List']")WebElement screentitle;
	@FindBy(xpath="//h4[text()='Add Complain']")WebElement boxtitle;
	
	@FindBy(css="form#formadd select[name='complaint']")WebElement cmp;
	@FindBy(css="form#formadd select[name='source']")WebElement src;
	@FindBy(css="form#formadd input[name='name']")WebElement cmpbyname;
	@FindBy(css="form#formadd input[name='contact']")WebElement cont;
	@FindBy(css="form#formadd input[name='date']")WebElement date;
	@FindBy(css="form#formadd textarea[name='description']")WebElement des;
	@FindBy(css="form#formadd input[name='action_taken']")WebElement act;
	@FindBy(css="form#formadd input[name='assigned']")WebElement ass;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement upfile;
	
	public Complainlist()
	{
		PageFactory.initElements(driver, this);
	}
	public void clickaddcomplain()
	{
		Commonutility.waitforelement(addcomplain);
		addcomplain.click();
	}
	public String getScreentitle()
	{
		Commonutility.waitforelement(screentitle);
		return screentitle.getText();
	}
	public void addcomplaindetails(String data[])
	{
		date.sendKeys(data[4]);
		Select drp=new Select(cmp);
		drp.selectByVisibleText(data[0]);
		
		src.sendKeys(data[1]);
		cmpbyname.sendKeys(data[2]);
		cont.sendKeys(data[3]);
		des.sendKeys(data[5]);
		act.sendKeys(data[6]);
		ass.sendKeys(data[7]);
		note.sendKeys(data[8]);	
	}
}
