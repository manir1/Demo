package com.web.pages;

import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.amazon.in/")
public class HomePage extends PageObject {

	@FindBy(css = "#nav-search-submit-text")
	WebElementFacade searchButton;

	private final static String SHOP_SUGGESTION = "(//div[@id='suggestions']//div[@class='s-suggestion'])[1]";

	public void enterSearchTerms(String keyword) {
		$("#twotabsearchtextbox").type(keyword);
		new WebDriverWait(getDriver(), 1)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SHOP_SUGGESTION)));
		// withTimeoutOf(10,
		// TimeUnit.SECONDS).waitForPresenceOf(By.xpath(SHOP_SUGGESTION));
		waitForKeywordToBeUpdatedTo(keyword);
	}

	private void waitForKeywordToBeUpdatedTo(String keyword) {
		waitForCondition().withTimeout(5, TimeUnit.SECONDS).pollingEvery(250, TimeUnit.MILLISECONDS)
				.until(keywordFieldIsUpdatedTo(keyword));
	}

	private Function<? super WebDriver, Boolean> keywordFieldIsUpdatedTo(String keyword) {
		return webDriver -> $("#twotabsearchtextbox").getValue().equalsIgnoreCase(keyword);
	}

	public void search() {
		searchButton.click();
	}

	public String selectCategory(String category) {
		Select dropdown = new Select($("#searchDropdownBox"));
		dropdown.selectByValue(category);
		return dropdown.getFirstSelectedOption().getText();
	}

	public void selectSerachFromSuggestion(int order) {
		getDriver().findElement(By.xpath("(//div[@id='suggestions']//div[@class='s-suggestion'])[" + order + "]"))
				.click();
	}
}
