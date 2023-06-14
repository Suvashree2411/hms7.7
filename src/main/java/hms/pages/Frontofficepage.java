package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class Frontofficepage extends Testbase {
	@FindBy(css="ul.sidebar-menu>li")WebElement frontofficemenu;
	@FindBy(css="h3.box-title")WebElement tabletitle;
	@FindBy(css="div.box-tools>a:nth-child(2)")WebElement visitorbook;
	
	public Frontofficepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonfrontoffice()
	{
		frontofficemenu.click();
	}
	
	public String gettabletitle()
	{
		return tabletitle.getText();
		
	}
	
	public void clickonvisitorbook()
	{
		visitorbook.click();
	}

}
