package com.web.pages;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListingPage extends PageObject {

	By name = By.cssSelector(".sg-row:nth-of-type(1) h2 .a-size-medium.a-color-base.a-text-normal");
	
	public void getProductDetails() {

		List<WebElement> productNames = getDriver().findElements(name);

		for (WebElement productName : productNames) {

			String productDescription = productName.getText();
			assertTrue("Product Description should not be null", productDescription != null);
			String author = getDriver().findElement(By.xpath("//*[contains(.,'" + productDescription
					+ "') and contains(@class,'a-color-base')]/..//*[contains(@class,'a-size-base a-link-normal')]"))
					.getText();
			assertTrue("Author name should not be null", author != null);
			String paperBookPrice = getDriver().findElement(By.xpath("//*[contains(.,'" + productDescription
					+ "') and contains(@class,'a-color-base')]/../../../../../../..//div/a[contains(. ,'Paperback')]/../../div[2]//*[@class='a-price']"))
					.getText();
			assertTrue("Paper book price should not be null", paperBookPrice != null);

		}
	}

	public String getProductDescription(int order) {
		return getDriver().findElements(name).get(order).getText();
	}

	public String getKindelBookPrice(String productName) {
		return getDriver().findElement(By.xpath("//*[contains(.,'" + productName
				+ "') and contains(@class,'a-color-base')]/../../../../../../..//div/a[contains(. ,'Kindle Edition')]/../../div[2]//*[@class='a-price']"))
				.getText();
	}
}
