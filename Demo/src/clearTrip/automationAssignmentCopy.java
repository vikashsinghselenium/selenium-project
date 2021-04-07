package clearTrip;

import pages.BookingPage;
import pages.FlightSelectionPage;
import pages.ItineraryPage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class automationAssignmentCopy{
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs); driver = new
		ChromeDriver(options); driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS); 
		driver.manage().window().maximize();
    	
		//Creating objects
    	BookingPage booking = PageFactory.initElements(driver, BookingPage.class);;
    	FlightSelectionPage selection = PageFactory.initElements(driver, FlightSelectionPage.class);
    	ItineraryPage itinerary = PageFactory.initElements(driver, ItineraryPage.class);
    	
    	//Booking Page:
    	booking.loadURL();
    	booking.verifyLabel();
    	booking.waitForMiliseconds(10000);
    	booking.submitFlightDetails();
    	booking.enterDates();
    	booking.clickSearchButton();
    	
    	//Flight selection Page:
    	selection.selectNonStop();
    	selection.selectFlightFromTo();
    	selection.clickOnButton();
    	String firstTab = selection.firstTab(); 
    	
    	//Payment Page:
    	itinerary.SwitchToTab();
    	itinerary.ClickOnButton();
    	itinerary.SelectFlexiPlan();
    	
    	
    	
    	

	  

	   

	   
	}
	}
