Feature: Verification about Ebay website

@differentcountries
Scenario: Availability of Ebay website for many different countries
  Given User is in Homepage
	When User click eBay Sites option
  Then User can able to select the country
     
@localproducts
Scenario Outline: Search for local products using zipcode
  Given User is in Homepage
  When User enters product <prod>
  And User enters the zipcode <zip> in Shipping to option
  Then user is able to search for the product in their locality
Examples: 
      | prod   | zip    | 
      | guitar | 608601 | 
 
@availabilityofproducts
Scenario Outline: Products available nationally and internationally
  Given User is in Homepage
  When User enters product <product>
  And User enters the zipcode <zip> in Shipping to option
  Then user click worldwide option in Item location
Examples: 
      | product   |  zip    |
      | cycle 		|  608601 |  
    
    