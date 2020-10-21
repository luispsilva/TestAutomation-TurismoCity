Feature: Search Air Tickets

Scenario: Search Multiple Destinations Air Tickets
Given The browser is initialized
When User go to "https://www.turismocity.com.br/" site
And  Choose multiple destinations
And  Choose round trip date
And  Choose quantity of passangers
And  Choose kind of class
And  Click on Search button
Then The options of air tickets are shown