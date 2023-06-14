package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Commonutility;
import hms.utility.Datepicker;

public class VisitorPage extends Testbase {
	@FindBy(css="h3.box-title")WebElement tabletxt;
	@FindBy(css="div.box-tools>a")WebElement addvisitor;
	@FindBy(xpath="//h4[text()=' Add Visitor']")WebElement screentitle;
	
	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement pname;
	@FindBy(css="form#formadd input[name='contact']")WebElement phno;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement idpro;
    @FindBy(css="form#formadd input[name='pepples']")WebElement noper;
    @FindBy(css="form#formadd input[name='date']")WebElement datepicker;
    @FindBy(css="form#formadd textarea[name='note']")WebElement note;
    @FindBy(css="form#formadd input[name='file']")WebElement upfile;
    
    @FindBy(css="button.close123")WebElement closescreen;

public VisitorPage()
{
PageFactory.initElements(driver, this);
}
public String gettabletitle()
{
	return tabletxt.getText();
}
public void clickonaddvisitor()
{
	addvisitor.click();
}
public String getscreentitle()
{
	Commonutility.waitforelement(screentitle);
	return screentitle.getText();
}
public void addvisitordetails(String data[])
{
	Select drp=new Select(purpose);
	drp.selectByVisibleText(data[0]);
	
	pname.sendKeys(data[1]);
	phno.sendKeys(data[2]);
	idpro.sendKeys(data[3]);
	noper.sendKeys(data[5]);
	note.sendKeys(data[6]);
	
	datepicker.click();
	Datepicker dt=new Datepicker();
	Commonutility.clickonwebelement(datepicker);
	dt.datpicker(data[4]);
	
	Commonutility.clickonwebelement(upfile);
	
	Commonutility.uploadfile(data[7]);	
	
	closescreen.click();
}
}
    
    
    
