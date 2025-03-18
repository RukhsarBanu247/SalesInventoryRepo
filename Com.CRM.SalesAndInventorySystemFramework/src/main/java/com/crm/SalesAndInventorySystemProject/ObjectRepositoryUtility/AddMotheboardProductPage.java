package com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.SalesAndInventorySystemProject.BaseClassUtility.BaseClassUtilty;
import com.crm.SalesAndInventorySystemProject.WebDriverUtility.WebdriverUtility;

public class AddMotheboardProductPage extends BaseClassUtilty
{
	@FindBy(xpath = "//h6[text()='rukhsarbanu68@gmail.com']/following-sibling::input[@type='submit']")
	private WebElement add_Btn1;
	
	WebdriverUtility wutil;
	
	@FindBy(xpath = "//h6[text()='Munna1234']/following-sibling::input[@type='submit']")
	private WebElement add_Btn2;

	public WebdriverUtility getWutil() {
		return wutil;
	}

	public WebElement getAdd_Btn2() {
		return add_Btn2;
	}

	public WebElement getProcced_paymntBtn() {
		return procced_paymntBtn;
	}

	public WebElement getAdd_Btn1() {
		return add_Btn1;
	}

	@FindBy(name = "customer")
	private WebElement select_customer;

	public WebElement getSelect_customer() {
		return select_customer;
	}

	@FindBy(xpath = "(//a[@data-toggle='modal'])[3]")
	private WebElement create_customer;

	public WebElement getCreate_customer() {
		return create_customer;
	}
	@FindBy(xpath = "(//input[@placeholder='First Name'])[2]")
	private WebElement firstname;
	
	
	@FindBy(xpath = "(//input[@placeholder='Last Name'])[2]")
	private WebElement lastname;
	
	@FindBy(xpath = "(//input[@placeholder='Phone Number'])[2]")
	private WebElement phonenumber;
	
	@FindBy(xpath = "(//button[text()='Save'])[2]")
	private WebElement save_Btn;
	
	@FindBy(xpath = "//button[@type='reset']")
	private WebElement reset_Btn;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancel_Btn;
	
	@FindBy(xpath = "//button[text()='SUBMIT']")
	private WebElement submit_Btn;

	public WebElement getCash_text() {
		return cash_text;
	}

	@FindBy(xpath = "//input[@name='cash']")
	private WebElement cash_text;

	@FindBy(xpath = "//button[text()='PROCEED TO PAYMENT']")
	private WebElement procced_paymntBtn;
	
	public WebElement getSubmit_Btn() {
		return submit_Btn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getSave_Btn() {
		return save_Btn;
	}

	public WebElement getReset_Btn() {
		return reset_Btn;
	}

	public WebElement getCancel_Btn() {
		return cancel_Btn;
	}

	WebDriver driver = null;

	public AddMotheboardProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectCustomer(String cust_name) throws InterruptedException {
		Select s = new Select(select_customer);
		s.selectByVisibleText(cust_name);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit_Btn);
		Thread.sleep(500); // Small delay to ensure visibility
		
		submit_Btn.click();
		cash_text.sendKeys("500");
		procced_paymntBtn.click();
		wUtil.handlingAlertWithExplicitWait(driver);;
	}

	public void createcustomer(String fName,String lName,String PhnNo) 
	{
		create_customer.click();
		firstname.sendKeys(fName);
		lastname.sendKeys(lName);
		phonenumber.sendKeys(PhnNo);
		save_Btn.click();
		wUtil.handlingAlertWithExplicitWait(driver);
		
	}
	public void selectTheNewCreatedCustomer(String cust_name) throws InterruptedException
	{
		Select s=new Select(select_customer);
		s.selectByVisibleText(cust_name);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit_Btn);
		Thread.sleep(500); // Small delay to ensure visibility
		submit_Btn.click();
		cash_text.sendKeys("500");
		procced_paymntBtn.click();
		wUtil.handlingAlertWithExplicitWait(driver);
	}
	

}
