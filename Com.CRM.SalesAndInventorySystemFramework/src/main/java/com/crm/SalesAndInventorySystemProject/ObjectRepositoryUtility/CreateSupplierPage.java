package com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.SalesAndInventorySystemProject.WebDriverUtility.WebdriverUtility;

public class CreateSupplierPage 
{
	@FindBy(xpath = "//h4/a[@href='#']")
	private WebElement create_supplier;

	public WebElement getCreate_supplier() {
		return create_supplier;
	}
	WebDriver driver=null;
	
	@FindBy(xpath = "//input[@placeholder='Company Name']")
	private WebElement companyName;
	
	@FindBy(name = "phonenumber")
	private WebElement phNnum;
	
	@FindBy(xpath = "(//button[text()='Save'])[1]")
	private WebElement saveBtn;
	
	@FindBy(name = "province")
	private WebElement provinceSelect;
	
	@FindBy(id = "city")
	private WebElement city_select;
	
	@FindBy(xpath = "//input[@placeholder='City/Municipality']")
	private WebElement citySelect;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//div/a[@data-toggle='dropdown']")
	private WebElement editDrpdwn;
	
	@FindBy(partialLinkText = "Edit")
	private WebElement editBtn;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateBtn;
	
	public CreateSupplierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createSupplierWithoutProvinceAndCity(String supplierName, String suppPhone) throws InterruptedException
	{
		companyName.sendKeys(supplierName);
		phNnum.sendKeys(suppPhone);
		Thread.sleep(2000);
		saveBtn.click();
		
	}
	public void createSupplier(String compnyName,String phoneNum,String province,String city)
	{
		companyName.sendKeys(compnyName);
		phNnum.sendKeys(phoneNum);

		Select s=new Select(provinceSelect);
		s.selectByVisibleText(province);
		Select s1=new Select(city_select);
		s1.selectByVisibleText(city);
		saveBtn.click();
	}
	
	public void searchSupplier(String compnyName) throws InterruptedException
	{
		searchBtn.sendKeys(compnyName);
		Thread.sleep(2000);
	}
	public void updateSupplier(String updateName,String city) throws InterruptedException
	{
		editDrpdwn.click();
		editBtn.click();
		companyName.clear();
		companyName.sendKeys(updateName);
		citySelect.sendKeys(city);
		
		updateBtn.click();
		Thread.sleep(5000);
		WebdriverUtility wUtil=new WebdriverUtility();
		wUtil.handlingAlertWithExplicitWait(driver);
	}
	
	public void searchUpdatedCompanyDetails(String updateName)
	{
		searchBtn.sendKeys(updateName);
	}


	

	
}
