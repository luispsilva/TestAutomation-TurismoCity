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
import pages.SearchAirTicketsPage;

@RunWith(Cucumber.class)
public class SearchAirTickestStep extends BasePage {

	public WebDriver driver;
	public WebDriverWait wait;

	@Given("^The browser is initialized$")
	public void the_browser_is_initialized() throws Throwable {

		driver = initializeBrowser();
	}

	@When("^User go to \"([^\"]*)\" site$")
	public void user_go_to_site(String arg1) throws Throwable {

		driver.get(arg1);
	}
	
	@When("^Choose one way option$")
	public void choose_one_way_option() throws Throwable {
	   
		SearchAirTicketsPage oneWay = new SearchAirTicketsPage(driver);
		oneWay.getOneWayOption().click();
	}


	@When("^Choose source and destination$")
	public void choose_source_and_destination() throws Throwable {

		SearchAirTicketsPage source = new SearchAirTicketsPage(driver);
		source.getSourceClick1().click();
		source.getSourceClick2().sendKeys("Sal");
		Thread.sleep(2000);
		source.getSourceClick2().sendKeys(Keys.ARROW_DOWN);
		source.getSourceClick2().sendKeys(Keys.ENTER);

		SearchAirTicketsPage destiny = new SearchAirTicketsPage(driver);
		destiny.getDestinyClick1().click();
		destiny.getDestinyClick2().sendKeys("Rio");
		Thread.sleep(2000);
		destiny.getDestinyClick2().sendKeys(Keys.ARROW_DOWN);
		source.getDestinyClick2().sendKeys(Keys.ENTER);
	}
	
	@When("^Choose multiple destinations$")
	public void choose_multiple_destinations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


	@When("^Choose round trip date$")
	public void choose_round_trip_date() throws Throwable {

		SearchAirTicketsPage date = new SearchAirTicketsPage(driver);

		date.getRoundTripDate();

	}
	
	@When("^Choose depart trip date$")
	public void choose_depart_trip_date() throws Throwable {
		SearchAirTicketsPage departDate = new SearchAirTicketsPage(driver);
		departDate.getDepartTripDate();
	}


	@When("^Choose quantity of passangers$")
	public void choose_quantity_of_passangers() throws Throwable {

		SearchAirTicketsPage passangers = new SearchAirTicketsPage(driver);
		passangers.getQuantityPassangers();
	}

	@When("^Choose kind of class$")
	public void choose_kind_of_class() throws Throwable {

		SearchAirTicketsPage travelClass = new SearchAirTicketsPage(driver);
		travelClass.getTravelClass();
	}

	@When("^Click on Search button$")
	public void click_on_Search_button() throws Throwable {

		SearchAirTicketsPage clickOnSearchButton = new SearchAirTicketsPage(driver);
		clickOnSearchButton.getClickOnSearch().click();
	}

	@Then("^The options of air tickets are shown$")
	public void the_options_of_air_tickets_are_shown() throws Throwable {
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button.variation1")));
		
		Assert.assertTrue(driver.findElement(By.cssSelector("a.button.variation1")).isDisplayed());
	}

}
