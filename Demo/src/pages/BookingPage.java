package pages;

import ConfigReader.ConfigFileReader;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage {

	WebDriver driver;
	ConfigFileReader config = new ConfigFileReader();
	
	@FindBy(xpath = "//a//span[@title='Cleartrip ']")
	public WebElement lblTitle;

	@FindBy(id = "RoundTrip")
	public WebElement rbtnRound;

	@FindBy(id = "FromTag")
	public WebElement txtFrom;

	@FindBy(id = "ToTag")
	public WebElement txtTo;

	@FindBy(id = "ui-id-1")
	public WebElement ddSource;

	@FindBy(id = "ui-id-2")
	public WebElement ddDestination;

	@FindBy(id = "DepartDate")
	public WebElement txtDepDate;

	@FindBy(id = "ReturnDate")
	public WebElement txtRetDate;

	@FindBy(xpath = "//*[@id='Adults']")
	public WebElement ddAdults;

	@FindBy(xpath = "//*[@id='Childrens']")
	public WebElement ddChildren;

	@FindBy(xpath = "//*[@id='Infants']")
	public WebElement ddInfants;

	@FindBy(id = "SearchBtn")
	public WebElement btnSearch;

	public BookingPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void loadURL()
	{
		String URL = config.getURL();
		driver.get(URL);
	}

		public void clickRoundTrip()
		{
			rbtnRound.click();
		}
	
		public void clickSearchButton()
		{
			btnSearch.click();
		}

	public void setSource(String strFrom) 
	{
		txtFrom.sendKeys(strFrom);
	}

	public void setDestination(String strTo) 
	{
		txtTo.sendKeys(strTo);

	}

	public void fromDate(String date)
	{
		txtDepDate.sendKeys(date);
	}
	
	public void toDate(String date)
	{
		txtRetDate.sendKeys(date);
	}
	
	public void verifyLabel()
	{
		this.waitForElement(lblTitle);
	}
	
	//Methods:
	public void submitFlightDetails() 
	{
		String fromCity = config.getFromCity();
		String toCity = config.getToCity();
		this.clickRoundTrip();
		this.setSource(fromCity);
		List<WebElement>sourceOptions =driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		sourceOptions.get(0).click();
		this.setDestination(toCity);
		List<WebElement>destinationOptions =driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

	}
	
	public void enterDates()
	{
		String depDate = config.getDepDate();
		String retDate = config.getRetDate();
		txtDepDate.clear();
		this.fromDate(depDate);
		txtRetDate.clear();
		this.toDate(retDate);
	}
	
	public void waitForMiliseconds(int miliseconds) throws InterruptedException
	{
		Thread.sleep(miliseconds);
	}
	
	 public void waitForElement(WebElement Element)
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
	    	wait.until(ExpectedConditions.visibilityOf(Element));
	    }

}