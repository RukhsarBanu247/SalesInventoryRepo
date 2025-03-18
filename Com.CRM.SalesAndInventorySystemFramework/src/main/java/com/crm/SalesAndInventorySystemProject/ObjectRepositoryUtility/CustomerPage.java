package com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	@FindBy(xpath = "//span[text()='Customer']")
	private WebElement customer_link;

	

	public WebElement getCustomer_link() {
		return customer_link;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(xpath = "//h4/a[@href='#']")
	private WebElement create_cust;

	public WebElement getCreate_cust() {
		return create_cust;
	}

	WebDriver driver = null;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCustomerLink() {
		customer_link.click();
		create_cust.click();
	}

	
	

	

}
