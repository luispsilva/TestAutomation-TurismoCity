package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchHotelPage {

	public WebDriver driver;

	private By clickOnHotelTab = By.xpath("//*[@id='PageNavBarSectionList']//a[@title='Hotéis']");
	private By destinyClick1 = By.xpath("(//div[@role='button']/span)[3]/span");
	private By destinyClick2 = By
			.xpath("//*[@id='hotels-tab-container']//input[@placeholder='Destino ou nome do hotel']");

	public SearchHotelPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDestinyClick1() {
		return driver.findElement(destinyClick1);
	}

	public WebElement getDestinyClick2() {
		return driver.findElement(destinyClick2);
	}

	public WebElement getClickOnHotelTab() {
		return driver.findElement(clickOnHotelTab);
	}

	public void getRoundTripDateHotelSearch() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='tc-datepicker hbox']/span)[4]")).click();

		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='td tc-day tc-day-canhover']"));

		for (int i = 0; i < dates.size(); i++) {

			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase("30")) {
				dates.get(i).click();
				break;
			}
		}

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"hotels-tab-container\"]/form/div[2]/div[2]/div/span[2]")).click();

		List<WebElement> datesBack = driver.findElements(By.xpath("//div[@class='td tc-day tc-day-canhover']"));

		for (int j = 0; j < datesBack.size(); j++) {

			String text = datesBack.get(j).getText();
			if (text.equalsIgnoreCase("3")) {
				datesBack.get(j).click();
				break;
			}
		}

	}

	public void getQuantityOfGuests() throws InterruptedException {

		driver.findElement(By.xpath("(//input[@readonly='readonly'])[2]")).click();
		Thread.sleep(2000);

		for (int i = 1; i < 4; i++) {

			driver.findElement(By.xpath("(//div[@class='vbox tc-complex-select-container']//a[2]/i)[1]")).click();
		}

		for (int i = 1; i < 3; i++) {

			driver.findElement(By.xpath("(//div[@class='vbox tc-complex-select-container']//a[2]/i)[2]")).click();
		}

		driver.findElement(By.cssSelector("div.hbox.tc-hide-lnk a")).click();

	}

	public void getClickOnSearchFromHotelSearch() {

		driver.findElement(By.xpath("//*[@id='hotels-tab-container']//input[@value='PESQUISAR']"))
				.click();
	}
}
