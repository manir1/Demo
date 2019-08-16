package com.web.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import com.web.pages.HomePage;
import com.web.steps.serenity.BuyerSteps;

public class DisplayProductDetailsScenarioSteps {

    @Steps
    BuyerSteps buyer;

    HomePage homePage;

    @Given("^I have searched for '(.*)' in the '(.*)'$")
    public void i_have_searched_for_data_in_the_book(String searchTerm, String category) {
        buyer.opens_home_page();
        buyer.select_category(category);
        buyer.searches_by_keyword(searchTerm);
        
    }

    @When("^I select first displayed item$")
    public void i_select_first_displayed_item() {
         buyer.select_suggestion(1);   
    }
    
    @Then("I should see product description and price on the details page")
    public void thenIShouldSeeProductDescriptionAndPriceOnTheDetailsPage() {
        buyer.get_product_details();
        buyer.get_Kindle_book_details();
    }    

}
