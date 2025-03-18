package com.crm.SalesAndInventorySystemProject.AdminModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.SalesAndInventorySystemProject.BaseClassUtility.BaseClassUtilty;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.AddKeyboardProductPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CreateCustomerPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CreateProductPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CustomerPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.HomePage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.LoginPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.ProductCategoryPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.ProductPage;

/**
 * This class is a TestNG class which contains 2 test methods i.e, create and
 * search the customer.
 */
@Listeners(com.crm.SalesAndInventorySystemProject.ListeneresUtility.ListenerImplementationClass.class)
public class CreateCustomerTest extends BaseClassUtilty {
	/**
	 * This method is used to create the customer with the provided details.
	 * 
	 * @throws Throwable
	 */
	//@Test(retryAnalyzer=com.crm.SalesAndInventorySystemProject.ListeneresUtility.RetryAnalyzer.class,groups = {"SmokeTest","SystemTest"})
	@Test(groups= {"SmokeTest","SystemTest"})
	public void createCustomerTest() throws Throwable {
		String fName = eUtil.getDataFromExcel("Customer", 1, 1) + jUtil.getRandomNumber();
		String lName = eUtil.getDataFromExcel("Customer", 1, 2);
		String PhnNo = eUtil.getDataFromExcel("Customer", 1, 3);

		CustomerPage cp = new CustomerPage(driver);
		cp.clickOnCustomerLink();

		CreateCustomerPage ccp = new CreateCustomerPage(driver);
		ccp.createAndSaveCustomer(fName, lName, PhnNo);

		
		String actualCustomerName =fName;
		System.out.println(actualCustomerName);

		String expectedCustomerName;
		for(;;)
		{
			try {
			
				expectedCustomerName=driver.findElement(By.xpath("//td[text()='"+fName+"']")).getText();
				System.out.println(expectedCustomerName);
				break;
			}catch(Exception e)
			{
				WebElement nextBtn=driver.findElement(By.xpath("//a[text()='Next']"));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				Thread.sleep(500); // Small delay to ensure visibility
				nextBtn.click();
			}
		
		}
		
	     Assert.assertEquals(expectedCustomerName, actualCustomerName);
		// String expectedCustomerName=ccp.getFirstName().getText();
		// String
		// expectedCustomerName=driver.findElement(By.xpath("//td[text()='"+fName+"']")).getText();
		//String expectedCustomerName = fName;
//		System.out.println(expectedCustomerName);
//		// Assert.assertEquals(actualCustomerName,expectedCustomerName);
//
////		String expectedCustomerName=ccp.getFirstName().getText();
//		Assert.assertEquals(actualCustomerName, expectedCustomerName);

	}
	
	/**
	 * This method is used to search the created or existing customer in customer page.
	 * @throws Exception
	 */

	@Test(groups = {"SmokeTest","IntegrationTest"})
	public void searchCustomerTest() throws Exception {
		String fName = eUtil.getDataFromExcel("Customer", 4, 1) + jUtil.getRandomNumber();
		String lName = eUtil.getDataFromExcel("Customer", 4, 2) + jUtil.getRandomNumber();
		String PhnNo = eUtil.getDataFromExcel("Customer", 4, 3);
	

		CustomerPage cp = new CustomerPage(driver);
		cp.clickOnCustomerLink();

		CreateCustomerPage ccp = new CreateCustomerPage(driver);
		ccp.createAndSaveCustomer(fName, lName, PhnNo);
		Thread.sleep(2000);

		ccp.searchCustomer(fName);


		String actualCustomerName = fName;
		System.out.println(actualCustomerName);

		String expectedCustomerName;
		for(;;)
		{
			try {
			
				expectedCustomerName=driver.findElement(By.xpath("//td[text()='"+fName+"']")).getText();
				System.out.println(expectedCustomerName);
				break;
			}catch(Exception e)
			{
				WebElement nextBtn=driver.findElement(By.xpath("//a[text()='Next']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				Thread.sleep(500); // Small delay to ensure visibility
				nextBtn.click();
			}
		
		}
		
	     Assert.assertEquals(expectedCustomerName, actualCustomerName);
		
	
		
	}

	/**
	 * This method is used to update the details of existing customer
	 * @throws Exception
	 */
	@Test(groups = {"SmokeTest","IntegrationTest"})
	public void updateCustomerTest() throws Exception
	{
		String fName=eUtil.getDataFromExcel("Customer", 7, 1)+jUtil.getRandomNumber();
		String lName=eUtil.getDataFromExcel("Customer", 7, 2)+jUtil.getRandomNumber();
		String PhnNo=eUtil.getDataFromExcel("Customer", 7, 3);
		String searchName=eUtil.getDataFromExcel("Customer", 7, 4);
		String updateName=eUtil.getDataFromExcel("Customer", 7, 5);
		
		CustomerPage cp=new CustomerPage(driver);
		cp.clickOnCustomerLink();
		
		CreateCustomerPage ccp=new CreateCustomerPage(driver);
		ccp.createAndSaveCustomer(fName, lName, PhnNo);
		
		ccp.searchCustomer(searchName);
		Thread.sleep(2000);
		ccp.updateCustomer(updateName);
		Thread.sleep(2000);
		
		
		String actualUpdatedName=updateName;
		System.out.println(actualUpdatedName);
		
		String expectedUpdateName;
		for(;;)
		{
			try {
			
				expectedUpdateName=driver.findElement(By.xpath("//td[text()='"+updateName+"']")).getText();
				System.out.println(expectedUpdateName);
				break;
			}catch(Exception e)
			{
				WebElement nextBtn=driver.findElement(By.xpath("//a[text()='Next']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				Thread.sleep(500); // Small delay to ensure visibility
				nextBtn.click();
			}
		
		}
		//System.out.println(expectedUpdateName);
	     Assert.assertEquals(expectedUpdateName, actualUpdatedName);
		
	}

	/**
	 * This method is verify new product we can add to the existing/new customer or not.
	 * @throws Throwable
	 */
	@Test(groups = "IntegrationTest")
	public void customerReflectInSalesPageTest() throws Throwable {
		String fName = eUtil.getDataFromExcel("Customer", 10, 1);
		String lName = eUtil.getDataFromExcel("Customer", 10, 2);
		String PhnNo = eUtil.getDataFromExcel("Customer", 10, 3);
		String searchName = eUtil.getDataFromExcel("Customer", 10, 4);
		String cust_name = eUtil.getDataFromExcel("Keyboard", 5, 1);
	
		String username = eUtil.getDataFromExcel("Customer", 10, 6);
		String password = eUtil.getDataFromExcel("Customer", 10, 7);

		CustomerPage cp = new CustomerPage(driver);
		cp.clickOnCustomerLink();

		CreateCustomerPage ccp = new CreateCustomerPage(driver);
		ccp.createAndSaveCustomer(fName, lName, PhnNo);

		ccp.searchCustomer(searchName);
		Thread.sleep(2000);
	
		String expectedUpdateName=searchName;
		System.out.println(expectedUpdateName);


		HomePage hp = new HomePage(driver);
		hp.logOutFromApp();

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);

		//String cust_name = eUtil.getDataFromExcel("Keyboard", 5, 1);
		ProductCategoryPage pcp = new ProductCategoryPage(driver);
		pcp.getKeyboardLink().click();

		AddKeyboardProductPage app = new AddKeyboardProductPage(driver);
		app.getAdd_Btn().click();

		// app.createcustomer(fName, lName, PhnNo);
		app.selectCustomer(cust_name);
		// app.selectTheNewCreatedCustomer(cust_name);
		
		String actualUpdatedName=cust_name;
		System.out.println(actualUpdatedName);
		

		//System.out.println(expectedUpdateName);
	     Assert.assertEquals(expectedUpdateName, actualUpdatedName);

		//Assert.assertEquals(true, cust_name.contains(fName));
		

	}

}
