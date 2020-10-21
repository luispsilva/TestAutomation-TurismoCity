Feature: Search Air Tickets

Scenario: Search Multiple Destinations Air Tickets
Given The browser is initialized
When User go to "https://www.turismocity.com.br/" site
And  Choose multiple destinations
And  Choose trip date multiple destinations
And  Choose quantity of passangers from multiple destinations
And  Choose kind of class from multiple destinations
And  Click on Search button from multiple destinations
Then The options of air tickets are shown
Then The browser is closed