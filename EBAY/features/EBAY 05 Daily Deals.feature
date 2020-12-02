Feature: Daily Deals

@DailyDeals
Scenario: User can access Daily Deals Page
	Given User is in Homepage
  When User click Daily Deals option
  Then User can access the Daily Deals Products Posted by other Users     
  