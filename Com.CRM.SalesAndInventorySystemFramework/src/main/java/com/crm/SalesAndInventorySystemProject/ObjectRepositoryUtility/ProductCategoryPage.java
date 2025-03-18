package com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryPage 
{
	@FindBy(linkText = "Keyboard")
	private WebElement keyboardLink;
	
	public WebElement getKeyboardLink() {
		return keyboardLink;
	}

	public WebElement getMotherboardLink() {
		return motherboardLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(linkText = "Motherboard")
	private WebElement motherboardLink;
	
	WebDriver driver;
	
	public ProductCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

}
