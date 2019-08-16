package com.web.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;

import com.web.pages.HomePage;
import com.web.pages.ListingPage;

public class BuyerSteps extends ScenarioSteps {

    /**
	 * 
	 */
	HomePage homePage;
    ListingPage listingPage;
    

    @Step
    public void opens_home_page() {
        homePage.open();
    }

    @Step
    public void select_category(String category) {
    	
    	assertThat(homePage.selectCategory(category)).containsIgnoringCase(category);
    }
    @Step
    public void searches_by_keyword(String keyword) {
        homePage.enterSearchTerms(keyword);
    }

    @Step    
    public void select_suggestion(int order) {
    	homePage.selectSerachFromSuggestion(order);
    }
    
    @Step
    public void get_product_details() {
    	listingPage.getProductDetails();
    }
    
    public void get_Kindle_book_details() {
    	String name = listingPage.getProductDescription(1);
    	assertThat(listingPage.getKindelBookPrice(name)).isNotEqualTo(null);
    }
}
