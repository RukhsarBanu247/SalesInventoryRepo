package com.crm.SalesAndInventorySystemProject.AdminModule;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.SalesAndInventorySystemProject.BaseClassUtility.BaseClassUtilty;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CreateProductPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CreateSupplierPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.HomePage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.InventoryPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.ProductPage;

public class CreateSupplierTest extends BaseClassUtilty {
	
	/**
	 * This method is used to create the supplier.
	 * @throws Exception
	 */
	@Test(groups = {"SystemTest","IntegrationTest"})
	public void supplierProductInventoryTest() throws Exception {
		String supplierName = eUtil.getDataFromExcel("Supplier", 1, 1) + jUtil.getRandomAlphanumericCode();
		String suppPhone = eUtil.getDataFromExcel("Supplier", 1, 2);
		String prod_code = eUtil.getDataFromExcel("Product", 1, 1) + jUtil.getRandomAlphanumericCode();
		String prod_name = eUtil.getDataFromExcel("Product", 1, 2);
		String prod_desc = eUtil.getDataFromExcel("Product", 1, 3);
		String qnty = eUtil.getDataFromExcel("Product", 1, 4) + jUtil.getRandomNumber();
		String on_hand = eUtil.getDataFromExcel("Product", 1, 5) + jUtil.getRandomNumber();
		String prod_price = eUtil.getDataFromExcel("Product", 1, 6);
		String category = eUtil.getDataFromExcel("Product", 1, 7);
		// String supplier = eUtil.getDataFromExcel("Product", 1, 8);
		String supplier = supplierName;
		String date_stock_in = jUtil.getSystemDateYYYYMMDD();

		HomePage hp = new HomePage(driver);
		hp.getSupplier_link().click();

		CreateSupplierPage csp = new CreateSupplierPage(driver);
		csp.getCreate_supplier().click();

		csp.createSupplierWithoutProvinceAndCity(supplierName, suppPhone);

		ProductPage pp = new ProductPage(driver);
		pp.clickOnProductLink();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(prod_code, prod_name, prod_desc, qnty, on_hand, prod_price, category, supplier,
				date_stock_in);
		;

		InventoryPage ip = new InventoryPage(driver);
		ip.getInventoryLink();

		ip.search(prod_code);

		String actualProductCode = prod_code;
		System.out.println(actualProductCode);
		String expectedProductCode = driver.findElement(By.xpath("//td[text()='" + prod_code + "']")).getText();
		System.out.println(expectedProductCode);

		Assert.assertEquals(expectedProductCode, actualProductCode);

	}

	/**
	 * This method is used to update the details of  supplier
	 * @throws Exception
	 */
	@Test(groups = {"SmokeTest","IntegrationTest"})
	public void updateSupplierTest() throws Exception {
		String compnyName = eUtil.getDataFromExcel("Supplier", 4, 1);
		String phoneNum = eUtil.getDataFromExcel("Supplier", 4, 4);
		String province = eUtil.getDataFromExcel("Supplier", 4, 2);
		String city = eUtil.getDataFromExcel("Supplier", 4, 3);
		String updateName = eUtil.getDataFromExcel("Supplier", 4, 5);

		HomePage hp = new HomePage(driver);
		hp.getSupplier_link().click();

		CreateSupplierPage csp = new CreateSupplierPage(driver);
		csp.getCreate_supplier().click();
		csp.createSupplier(compnyName, phoneNum, province, city);
		csp.searchSupplier(compnyName);
		csp.updateSupplier(updateName, city);
		csp.searchUpdatedCompanyDetails(updateName);
		String actualUpdatedName = updateName;
		System.out.println(actualUpdatedName);

		String expectedUpdateName;
		for (;;) {
			try {

				expectedUpdateName = driver.findElement(By.xpath("//td[text()='" + updateName + "']")).getText();
				System.out.println(expectedUpdateName);
				break;
			} catch (Exception e) {
				WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				Thread.sleep(500); // Small delay to ensure visibility
				nextBtn.click();
			}

		}

		Assert.assertEquals(expectedUpdateName, actualUpdatedName);

	}


}
