package pages;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItineraryPage {

	 WebDriver driver;

	 @FindBy(xpath = "//button[contains(text(), 'Continue')]")
		public WebElement btnContinue;   
	 
	 @FindBy(xpath = "//div[@class='bg-white br-4']//div[@class='row col-24 flex px-0 mx-0']/child::div[1]//button")
		public WebElement btnStandardSelect; 
	 
	  public ItineraryPage(WebDriver driver)
	    {
	        this.driver = driver;
	    }   
	  
	  public void button(WebElement Element)
	  {
		  Element.click();
	  }
	  
	  public void flexiPlan(WebElement Element)
	  {
		  Element.click();
	  }
	  
	  public void SwitchToTab()
	  {
		  ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(newTab.get(1));
	  }
	  
	  
	  //Methods
	  
	  public void ClickOnButton()
	  {
		  this.waitForElement(btnStandardSelect);
		  this.button(btnStandardSelect);
	  }
	  
	  public void SelectFlexiPlan()
	  {
		  this.waitForElement(btnStandardSelect);
		  this.flexiPlan(btnStandardSelect);
	  }
	  
	  public void waitForElement(WebElement Element)
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
	    	wait.until(ExpectedConditions.visibilityOf(Element));
	    }
	  
	  
}
