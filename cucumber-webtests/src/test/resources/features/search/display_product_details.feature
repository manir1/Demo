@version:Release-1
@version:Sprint-1.2
Feature: Display product details
  In order to encourage buyers to make a purchase
  As a seller
  I want buyers to be able to see details about a product

  Scenario Outline: Display product details from the search list
    Given I have searched for '<product>' in the '<category>'
    When I select first displayed item
    Then I should see product description and price on the details page

	Examples: 
	|product|category|	
	|data   |book    |