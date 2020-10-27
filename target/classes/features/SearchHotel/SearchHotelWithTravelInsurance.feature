Feature: Search Hotel

Scenario: Search Hotel With Travel Insurance
Given The browser is initialized to SearchHotel Feature
When User go to "https://www.turismocity.com.br/" site to Search Hotel
And  Choose destiny or hotel name
And  Choose round trip date to hotel search
And  Choose quantity of guests
When Click on search button from hotels search
Then The options of hotel are shown
Then The browser is closed