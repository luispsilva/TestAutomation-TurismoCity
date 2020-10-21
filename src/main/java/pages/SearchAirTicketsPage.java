package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchAirTicketsPage {

	public WebDriver driver;

	private By sourceclick1 = By.xpath("(//span[@class='select2-chosen tc-text-ellipsis tc-placeholder'])[1]");
	private By sourceclick2 = By.xpath("(//div[@id='flights-tab-container']//span/input)[1]");
	private By destinyclick1 = By.xpath("(//span[@class='select2-chosen tc-text-ellipsis tc-placeholder'])[1]");
	private By destinyclick2 = By.xpath("(//div[@id='flights-tab-container']//span/input)[2]");
	private By clickOnSearch = By.cssSelector("input.btn.btn-block.btn-large.btn-lg.tc-btn-main.tc-btn-flight-main.TCBrasilSearchButton");
	private By clickOnOneWayOption = By.xpath("//div[@class='form-group tripTypeContainer']//ul/li[2]/label");

	public SearchAirTicketsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSourceClick1() {
		return driver.findElement(sourceclick1);
	}

	public WebElement getSourceClick2() {
		return driver.findElement(sourceclick2);
	}

	public WebElement getDestinyClick1() {
		return driver.findElement(destinyclick1);
	}

	public WebElement getDestinyClick2() {
		return driver.findElement(destinyclick2);
	}
	
	public WebElement getClickOnSearch() {
		return driver.findElement(clickOnSearch);
	}
	
	public WebElement getOneWayOption() {
		return driver.findElement(clickOnOneWayOption);
	}

	public void getRoundTripDate() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='tc-datepicker hbox e2e-outbound-datepicker']/span[2]")).click();

		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='td tc-day tc-day-canhover']"));

		for (int i = 0; i < dates.size(); i++) {

			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase("22")) {
				dates.get(i).click();
				break;
			}
		}

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='flights-tab-container']/form/div[2]/div/div[4]/div/div[2]/div")).click();
		List<WebElement> datesBack = driver.findElements(By.xpath("//div[@class='td tc-day tc-day-canhover']"));

		for (int j = 0; j < datesBack.size(); j++) {

			String text = datesBack.get(j).getText();
			if (text.equalsIgnoreCase("24")) {
				datesBack.get(j).click();
				break;
			}
		}
	}

	public void getQuantityPassangers() throws InterruptedException {

		driver.findElement(By.cssSelector("input[value='1 Passageiro']")).click();
		Thread.sleep(2000);

		for (int i = 1; i < 4; i++) {

			driver.findElement(By.xpath(
					"(//div[@class='vbox tc-complex-select-container']//a[2]/i)[1]"))
					.click();
		}

		for (int i = 1; i < 3; i++) {

			driver.findElement(By.xpath(
					"(//div[@class='vbox tc-complex-select-container']//a[2]/i)[2]"))
					.click();
		}
		
		driver.findElement(By.xpath("(//div[@class='vbox tc-complex-select-container']//a[2]/i)[3]")).click();

		driver.findElement(By.cssSelector("div.hbox.tc-hide-lnk a")).click();

	}
	
	public void getTravelClass() {

		Select s = new Select(driver.findElement(By.xpath("//select[@name='cabinClass']")));
		s.selectByValue("Business");
		
		}
	
	public void getDepartTripDate() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='tc-datepicker hbox e2e-outbound-datepicker']/span[2]")).click();

		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='td tc-day tc-day-canhover']"));

		for (int i = 0; i < dates.size(); i++) {

			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase("28")) {
				dates.get(i).click();
				break;
			}
		}
	}
}
