package com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.SalesAndInventorySystemProject.WebDriverUtility.WebdriverUtility;

public class CreateProductPage 
{
	@FindBy(name = "prodcode")
	private WebElement product_code;
	
	public WebElement getProduct_code() {
		return product_code;
	}

	public WebElement getProduct_name() {
		return product_name;
	}

	public WebElement getProduct_desc() {
		return product_desc;
	}

	public WebElement getProd_qnty() {
		return prod_qnty;
	}

	public WebElement getOnhand() {
		return onhand;
	}

	public WebElement getProduct_price() {
		return product_price;
	}

	public WebElement getSelect_category() {
		return select_category;
	}

	public WebElement getSelect_supplier() {
		return select_supplier;
	}

	public WebElement getDate_stock() {
		return date_stock;
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

	@FindBy(name ="name" )
	private WebElement product_name;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement product_desc;
	
	@FindBy(name = "quantity")
	private WebElement prod_qnty;
	
	@FindBy(name = "onhand")
	private WebElement onhand;
	
	@FindBy(xpath = "//input[@name='price']")
	private WebElement product_price;
	
	@FindBy(xpath = "//select[@name='category']")
	private WebElement select_category;
	
	@FindBy(xpath = "//select[@name='supplier']")
	private WebElement select_supplier;
	
	@FindBy(xpath = "//input[@placeholder='Date Stock In']")
	private WebElement date_stock;

	@FindBy(xpath = "(//button[text()='Save'])[5]")
	private WebElement save_Btn;
	
	@FindBy(xpath = "//button[@type='reset']")
	private WebElement reset_Btn;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancel_Btn;
	
	@FindBy(linkText = "Next")
	private WebElement nextBtn;
	
	@FindBy(xpath = "//select[@name='dataTable_length']")
	private WebElement selectEntries;
	
	@FindBy(xpath = "//div[text()='Showing 1 to 100 of 118 entries']")
	private WebElement verifyMsg;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBtn;
	


	
	
	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getSelectEntries() {
		return selectEntries;
	}

	public WebElement getVerifyMsg() {
		return verifyMsg;
	}

	public WebDriver getDriver() {
		return driver;
	}

	WebDriver driver=null;
	
	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createProduct(String prod_code,String prod_name,String prod_desc,String qnty,String on_hand,String prod_price,String category,String supplier,String date_stock_in) throws InterruptedException
	{
		product_code.sendKeys(prod_code);
		product_name.sendKeys(prod_name);
		product_desc.sendKeys(prod_desc);
		prod_qnty.sendKeys(qnty);
		onhand.sendKeys(on_hand);
		product_price.sendKeys(prod_price);
		Select s=new Select(select_category);
		s.selectByVisibleText(category);
		Select s1=new Select(select_supplier);
		s1.selectByVisibleText(supplier);
		//WebdriverUtility wUtil=new WebdriverUtility();
		//wUtil.scrollToElement(driver, date_stock);
//		wUtil.scrollByAmt(driver, 0, 2000);
//		Thread.sleep(1000);
		//date_stock.sendKeys("11-03-2025");
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", date_stock);
//		Thread.sleep(500); // Small delay to ensure visibility
//		date_stock.sendKeys("14-03-2025");
		
		Actions act=new Actions(driver);
		act.sendKeys(date_stock, date_stock_in).perform();
		save_Btn.click();
		
		
		
//		date_stock.clear();
//		date_stock.sendKeys("2025-03-11");
//		date_stock.sendKeys(Keys.RETURN);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document.getElementsByName('datestock').value='2025-11-03';");
		//js.executeScript("document.getElementsByClassName('form-control')[28].setAttribute('value','11-03-2025')","");
		//js.executeScript("document.getElementsByClassName('form-control')[28].value='2025-11-03';");
		//date_stock.sendKeys("11-03-2025");
	
		
		
	}
	
	public void changeEntries()
	{
		WebdriverUtility wUtil=new WebdriverUtility();
		wUtil.select(selectEntries, 3);
	}
	
	
	
	public void searchProduct(String prod_name)
	{
		searchBtn.sendKeys(prod_name);
	}
	
	
}
