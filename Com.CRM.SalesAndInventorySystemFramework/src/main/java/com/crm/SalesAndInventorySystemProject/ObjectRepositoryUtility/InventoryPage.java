package com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage 
{
	public WebElement getInventoryLink() {
		return inventoryLink;
	}

	@FindBy(xpath = "//span[text()='Inventory']")
	private WebElement inventoryLink;
	
	WebDriver driver=null;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBox;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public InventoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void search(String prod_code)
	{
		searchBox.sendKeys(prod_code);
	}
	

}
