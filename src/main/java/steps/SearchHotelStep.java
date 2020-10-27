package steps;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pages.BasePage;
import pages.SearchHotelPage;

@RunWith(Cucumber.class)
public class SearchHotelStep extends BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@Given("^The browser is initialized to SearchHotel Feature$")
	public void the_browser_is_initialized_for_SearchHotel_Feature() throws Throwable {
	    
		driver = initializeBrowser();
	}
	
	@When("^User go to \"([^\"]*)\" site to Search Hotel$")
	public void user_go_to_site_to_Search_Hotel(String arg1) throws Throwable {
		
		driver.get(arg1);
	}
	
	@When("^Choose destiny or hotel name$")
	public void choose_destiny_or_hotel_name() throws Throwable {
	    
		SearchHotelPage destinyClick = new SearchHotelPage(driver);
		destinyClick.getClickOnHotelTab().click();
		Thread.sleep(2000);
		destinyClick.getDestinyClick1().click();
		destinyClick.getDestinyClick2().sendKeys("rio");
		Thread.sleep(2000);
		destinyClick.getDestinyClick2().sendKeys(Keys.ENTER);
	}
	
	@When("^Choose round trip date to hotel search$")
	public void choose_round_trip_date_to_hotel_search() throws Throwable {
		
		SearchHotelPage tripDate = new SearchHotelPage(driver);
		tripDate.getRoundTripDateHotelSearch();
	}


	@When("^Choose quantity of guests$")
	public void choose_quantity_of_guests() throws Throwable {
		
		SearchHotelPage guests = new SearchHotelPage(driver);
		guests.getQuantityOfGuests();
	}

	@When("^Click on search button from hotels search$")
	public void click_on_search_button_from_hotels_search() throws Throwable {
	    
		SearchHotelPage searchClick = new SearchHotelPage(driver);
		searchClick.getClickOnSearchFromHotelSearch();
	}

	@Then("^The options of hotel are shown$")
	public void the_options_of_hotel_are_shown() throws Throwable {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.hotel__provider-list__item__btn")));
		
		
		Assert.assertTrue(driver.findElement(By.xpath("div.hotel__provider-list__item__btn")).isDisplayed());
	}


}
