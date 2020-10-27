package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", 
				features = "src/main/resources/features/SearchAirTickets", 
				glue = "steps",
				monochrome = true)

public class SearchAirTicketsRunner{
	
}
