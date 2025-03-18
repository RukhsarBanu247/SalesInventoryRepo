package com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SalesAndInventorySystemProject.WebDriverUtility.WebdriverUtility;

public class CreateCustomerPage {
	@FindBy(name = "firstname")
	private WebElement firstName;


	
	@FindAll({@FindBy(name="lastname"), @FindBy(xpath = "//h5[text()='Add Customer']/../following-sibling::div/form/div[2]/input[@placeholder='Last Name']")})
	private WebElement lastName;
	
	@FindBy(name = "phonenumber")
	private WebElement phnNo;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement resetBtn;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelBtn;
	
	@FindBy(xpath = "//div/a[@data-toggle='dropdown']")
	private WebElement editDrpdwn;
	
	@FindBy(partialLinkText = "Edit")
	private WebElement editBtn;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateBtn;

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getEditDrpdwn() {
		return editDrpdwn;
	}
	
//	public WebElement getActualFirstName() {
//		return actualFirstName;
//	}

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBox;
	
	public WebElement getNextBtn() {
		return nextBtn;
	}

	@FindBy(xpath = "//a[text()='Next']")
	private WebElement nextBtn;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPhnNo() {
		return phnNo;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	WebDriver driver=null;
	
	public CreateCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	String actualFirstString= getDriver().findElement(By.xpath("//td[text()='"+firstName+"']")).getText();
//
//	public WebElement getActualFirstName() {
//		return getActualFirstName();
//	}
	
	public void createAndSaveCustomer(String fName,String lName,String PhnNo) throws InterruptedException
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		Thread.sleep(2000);
		phnNo.sendKeys(PhnNo);
		Thread.sleep(2000);
		saveBtn.click();
		
	}
	public void createAndResetCustomer(String fName,String lName,String PhnNo)
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		phnNo.sendKeys(PhnNo);
		resetBtn.click();
		
	}
	public void createAndCancelCustomer(String fName,String lName,String PhnNo) throws InterruptedException
	{
		firstName.sendKeys(fName);
		Thread.sleep(5000);
		lastName.sendKeys(lName);
		phnNo.sendKeys(PhnNo);
		cancelBtn.click();
		
	}
	
	public void searchCustomer(String searchName) {
		searchBox.sendKeys(searchName, Keys.ENTER);
	}
	
	public void updateCustomer(String updateName)
	{
		editDrpdwn.click();
		editBtn.click();
		firstName.clear();
		firstName.sendKeys(updateName);
		updateBtn.click();
		WebdriverUtility wUtil=new WebdriverUtility();
		wUtil.handlingAlertWithExplicitWait(driver);
	}

}
