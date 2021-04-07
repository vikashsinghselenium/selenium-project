package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSelectionPage{
	
	
	 WebDriver driver;

	 @FindBy(xpath = "//a//span[@title='Cleartrip ']")
		public WebElement lblTitle;   
	 
	 @FindBy(xpath = "//div[@data-test-attrib='onward-view']//div[@class='ba bc-neutral-100 br-4 px-3 rt-tuple-container tp-box-shadow td-200 hover:elevation-3 c-pointer rt-tuple-container--selected']")
		public WebElement flightFrom; 
	 
	 @FindBy(xpath = "//div[@data-test-attrib='return-view']//div[@class='ba bc-neutral-100 br-4 px-3 rt-tuple-container tp-box-shadow td-200 hover:elevation-3 c-pointer rt-tuple-container--selected']")
		public WebElement flightTo;   
	 
	 @FindBy(xpath = "//label//div//p[contains(text(), 'Non-stop')]")
		public WebElement cbNonStop;   
	 
	 @FindBy(xpath = "//div/*[contains (text(), 'Book')]")
		public WebElement btnBook;  
	 
	 
	    public FlightSelectionPage(WebDriver driver)
	    {
	        this.driver = driver;
	    }   

	    public void Flight(WebElement Element)
	    {
	    	Element.click();
	    }
	    
	    public void Button(WebElement Element)
	    {
	    	Element.click();
	    }
	    
	    public void CheckBox(WebElement Element)
	    {
	    	Element.click();
	    }
			

		 //Flight selection page Methods:
	    
	    public void waitForElement(WebElement Element)
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
	    	wait.until(ExpectedConditions.visibilityOf(Element));
	    }

	    public void selectNonStop()
	    {
	    	this.waitForElement(cbNonStop);
	    	this.CheckBox(cbNonStop);
	    }
	    
	    public void selectFlightFromTo()
	    {
	    	this.waitForElement(flightFrom);
	    	this.Flight(flightFrom);
	    	this.Flight(flightTo);
	    }
	    
	    public void clickOnButton()
	    {
	    	this.waitForElement(btnBook);
	    	this.Button(btnBook);
	    }
	    
	    public String firstTab()
	    {
	    	String oldTab = driver.getWindowHandle();
	    	return oldTab;
	    }
	    
	 
}
