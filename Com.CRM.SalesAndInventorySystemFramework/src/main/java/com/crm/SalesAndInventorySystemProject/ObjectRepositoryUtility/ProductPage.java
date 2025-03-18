package com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
	@FindBy(xpath="//span[text()='Product']")
	private WebElement product_link;

	public WebElement getProduct_link() {
		return product_link;
	}
	
	@FindBy(xpath = "//h4/a[@href='#']")
	private WebElement create_product_Btn;

	public WebElement getCreate_product_Btn() {
		return create_product_Btn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	WebDriver driver =null;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnProductLink() {
		product_link.click();
		create_product_Btn.click();
	}
	
	

}
