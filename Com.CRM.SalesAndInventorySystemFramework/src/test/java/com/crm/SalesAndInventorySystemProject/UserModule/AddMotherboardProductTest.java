package com.crm.SalesAndInventorySystemProject.UserModule;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.SalesAndInventorySystemProject.BaseClassUtility.BaseClassUtilty;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.AddKeyboardProductPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.AddMotheboardProductPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.HomePage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.LoginPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.ProductCategoryPage;

@Listeners(com.crm.SalesAndInventorySystemProject.ListeneresUtility.ListenerImplementationClass.class)
public class AddMotherboardProductTest extends BaseClassUtilty
{
	
		/**
		 * This method is used to add the motherboard product to the existing customer
		 * @throws Exception
		 */
		@Test
		public void addingMotherboardProduct() throws Exception
		{
			HomePage hp=new HomePage(driver);
			hp.logOutFromApp();
			
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp("test", "test");
			
			String fName=eUtil.getDataFromExcel("Customer", 4, 1)+jUtil.getRandomNumber();
			String lName=eUtil.getDataFromExcel("Customer", 4, 2)+jUtil.getRandomNumber();
			String PhnNo=eUtil.getDataFromExcel("Customer", 4, 3);
			
		
			String cust_name=eUtil.getDataFromExcel("Motherboard", 1, 1);
			ProductCategoryPage pcp=new ProductCategoryPage(driver);
			pcp.getMotherboardLink().click();
			
			AddMotheboardProductPage app=new AddMotheboardProductPage(driver);
			app.getAdd_Btn1().click();
			
			
			//app.createcustomer(fName, lName, PhnNo);
			app.selectCustomer(cust_name);
			//app.selectTheNewCreatedCustomer(cust_name);
			
			pcp.getMotherboardLink().click();
			app.getAdd_Btn2().click();
		
			app.selectCustomer(cust_name);
			
	}
		
		/**
		 * This method is used to add the Motherboard product to the newly added customer customer
		 * @throws Exception
		 */
		@Test
		public void addingMotherboardProductBySelectingNewCustomer() throws Exception
		{
			HomePage hp=new HomePage(driver);
			hp.logOutFromApp();
			
			String Username=eUtil.getDataFromExcel("Customer", 10, 6);
			String Password=eUtil.getDataFromExcel("Customer", 10, 7);
			LoginPage lp=new LoginPage(driver);
			
			lp.loginToApp(Username, Password);
			
			String fName=eUtil.getDataFromExcel("Customer", 4, 1)+jUtil.getRandomNumber();
			String lName=eUtil.getDataFromExcel("Customer", 4, 2)+jUtil.getRandomNumber();
			String PhnNo=eUtil.getDataFromExcel("Customer", 4, 3);
			
			String cust_name=eUtil.getDataFromExcel("Motherboard", 3, 1);
			ProductCategoryPage pcp=new ProductCategoryPage(driver);
			pcp.getMotherboardLink().click();
			
			AddMotheboardProductPage app=new AddMotheboardProductPage(driver);
			app.getAdd_Btn1().click();
			
			
			app.createcustomer(fName, lName, PhnNo);
			//app.selectCustomer(cust_name);
			app.selectTheNewCreatedCustomer(cust_name);
			
			pcp.getMotherboardLink().click();
			app.getAdd_Btn2().click();
		
			app.selectCustomer(cust_name);
			
			
		}


}
