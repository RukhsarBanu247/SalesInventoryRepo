package com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SalesAndInventorySystemProject.WebDriverUtility.WebdriverUtility;

public class HomePage
{
	@FindBy(xpath = "//img[contains(@class,'img-profile rounded-circle')]")
	private WebElement admin_Img;
	
	@FindBy(partialLinkText = "Logout")
	private WebElement logout_Link;
	
	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	private WebElement alert_Logout;
	

	public WebElement getAlert_Logout() {
		return alert_Logout;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAdmin_Img() {
		return admin_Img;
	}

	public WebElement getLogout_Link() {
		return logout_Link;
	}
	
	@FindBy(xpath = "//span[text()='Customer']")
	private WebElement customer_link;
	
	public WebElement getCustomer_link() {
		return customer_link;
	}
	
	@FindBy(xpath = "//span[text()='Supplier']")
	private WebElement supplier_link;
	
	public WebElement getSupplier_link() {
		return supplier_link;
	}

	WebDriver driver=null;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void navigateToCustomerPage()
//	{
//		Actions a=new Actions(driver);
//		a.moveToElement(customer_link);
//		customer_link.click();
//	}
	
	/**
	 * This method is used to log out from the Application
	 */
	public void logOutFromApp()
	{
		//WebdriverUtility wUtil=new WebdriverUtility();
//		wUtil.mouseMoveOnElement(driver, admin_Img);
		admin_Img.click();
		logout_Link.click();
		alert_Logout.click();
		
		
		
	}
	
}
