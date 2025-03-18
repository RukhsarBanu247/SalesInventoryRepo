package com.crm.SalesAndInventorySystemProject.UserModule;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.SalesAndInventorySystemProject.BaseClassUtility.BaseClassUtilty;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.AddKeyboardProductPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CreateCustomerPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CustomerPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.HomePage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.LoginPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.ProductCategoryPage;

@Listeners(com.crm.SalesAndInventorySystemProject.ListeneresUtility.ListenerImplementationClass.class)
public class AddKeyboardProductTest extends BaseClassUtilty
{
	/**
	 * This method is used to add the keyboard to the existing customer
	 * @throws Exception
	 */
	@Test(groups = "SmokeTest")
	public void addingKeyboardProduct() throws Exception
	{
		
	
		HomePage hp=new HomePage(driver);
		hp.logOutFromApp();
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("test", "test");
				
		String cust_name=eUtil.getDataFromExcel("Keyboard", 1, 1);
		ProductCategoryPage pcp=new ProductCategoryPage(driver);
		pcp.getKeyboardLink().click();
		
		AddKeyboardProductPage app=new AddKeyboardProductPage(driver);
		app.getAdd_Btn().click();
		
		
		app.selectCustomer(cust_name);
	
		
			
	}
	
	/**
	 * This method is used to add the keyboard product to the newly added customer customer
	 * @throws Exception
	 */
	@Test(groups = {"SmokeTest","IntegrationTest"})
	public void addingKeyboardProductBySelectingNewCustomer() throws Exception
	{
		HomePage hp=new HomePage(driver);
		hp.logOutFromApp();
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("test", "test");
		
		String fName=eUtil.getDataFromExcel("Customer", 1, 1)+jUtil.getRandomNumber();
		String lName=eUtil.getDataFromExcel("Customer", 1, 2)+jUtil.getRandomNumber();
		String PhnNo=eUtil.getDataFromExcel("Customer", 1, 3);
		
	
		String cust_name=eUtil.getDataFromExcel("Keyboard", 1, 1);
		ProductCategoryPage pcp=new ProductCategoryPage(driver);
		pcp.getKeyboardLink().click();
		
		AddKeyboardProductPage app=new AddKeyboardProductPage(driver);
		app.getAdd_Btn().click();
		
		app.createcustomer(fName, lName, PhnNo);
		//app.selectCustomer(cust_name);
		app.selectTheNewCreatedCustomer(cust_name);
		
		
	}

}
