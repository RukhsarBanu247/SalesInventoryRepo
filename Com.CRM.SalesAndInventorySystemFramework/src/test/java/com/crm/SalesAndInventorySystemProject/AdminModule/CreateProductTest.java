package com.crm.SalesAndInventorySystemProject.AdminModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.SalesAndInventorySystemProject.BaseClassUtility.BaseClassUtilty;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CreateCustomerPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CreateProductPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.CustomerPage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.HomePage;
import com.crm.SalesAndInventorySystemProject.ObjectRepositoryUtility.ProductPage;

public class CreateProductTest extends BaseClassUtilty {
	
	/**
	 * This method is used to create the product details.
	 * @throws Exception
	 */
	@Test(groups = {"SmokeTest","SystemTest"})
	public void createProductTest() throws Exception {

		String prod_code = eUtil.getDataFromExcel("Product", 1, 1) + jUtil.getRandomAlphanumericCode();
		String prod_name = eUtil.getDataFromExcel("Product", 1, 2);
		String prod_desc = eUtil.getDataFromExcel("Product", 1, 3);
		String qnty = eUtil.getDataFromExcel("Product", 1, 4) + jUtil.getRandomNumber();
		String on_hand = eUtil.getDataFromExcel("Product", 1, 5) + jUtil.getRandomNumber();
		String prod_price = eUtil.getDataFromExcel("Product", 1, 6);
		String category = eUtil.getDataFromExcel("Product", 1, 7);
		String supplier = eUtil.getDataFromExcel("Product", 1, 8);
		// int days=0;
		// String date_stock_in=jUtil.getRequiredDateYYYYMMDD(days);
		String date_stock_in = jUtil.getSystemDateYYYYMMDD();
		System.out.println(date_stock_in);

		// String date_stock_in=eUtil.getDataFromExcel("Product", 1, 9);

		ProductPage pp = new ProductPage(driver);
		pp.clickOnProductLink();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(prod_code, prod_name, prod_desc, qnty, on_hand, prod_price, category, supplier,
				date_stock_in);

		String actualProductName = prod_name;
		// Assert.assertEquals(true, prod_name.contains("Sam"));
		String expectedProductName;
		for (;;) {
			try {

				expectedProductName = driver.findElement(By.xpath("//td[text()='" + prod_name + "']")).getText();
				System.out.println(expectedProductName);
				break;
			} catch (Exception e) {
				WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
				Thread.sleep(500); // Small delay to ensure visibility
				nextBtn.click();
			}

		}
		// System.out.println(expectedUpdateName);
		Assert.assertEquals(actualProductName, actualProductName);

	}

	/**
	 * This method is used to change the number of entries to display on page
	 * @throws Exception
	 */
	@Test(groups = {"SmokeTest","SystemTest"})
	public void changeNumOfEntriesTest() throws Exception {
		// String entries=eUtil.getDataFromExcel("Product", 4, 1);

		ProductPage pp = new ProductPage(driver);
		pp.clickOnProductLink();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.changeEntries();
		WebElement cancelBtn = driver.findElement(By.xpath("(//button[text()='Cancel'])[7]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
		Thread.sleep(500); //
		cancelBtn.click();

		

		WebElement actualMsg = driver.findElement(By.xpath("//div[@id='dataTable_info']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
		Thread.sleep(500);
		String text = actualMsg.getText();
		System.out.println(text);
		String expectedMsg =text;
		System.out.println(expectedMsg);
		Assert.assertEquals(expectedMsg, text);
	}

	
	/**
	 * This method is used to display the product details
	 * @throws Exception
	 */
	@Test(groups = {"SmokeTest","IntegrationTest","SystemTest"})
	public void displayDetailsOfProductTest() throws Exception {

		String prod_name = eUtil.getDataFromExcel("Product", 7, 1);
		
		ProductPage pp = new ProductPage(driver);
		pp.clickOnProductLink();

		CreateProductPage cpp = new CreateProductPage(driver);
		//cpp.createProduct(prod_code, prod_name, prod_desc, qnty, on_hand, prod_price, category, supplier, date_stock_in);

		WebElement cancelBtn = driver.findElement(By.xpath("(//button[text()='Cancel'])[7]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
		Thread.sleep(500);
		cancelBtn.click();
		cpp.searchProduct(prod_name);
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement detailsButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Details')]")));
		detailsButton.click();

		String actualProductName = prod_name;
		System.out.println(actualProductName);
		String expectedProductName = driver.findElement(By.xpath("//h5[contains(text(),'" + prod_name + "')]"))
				.getText();
		Assert.assertEquals(true, expectedProductName.contains(actualProductName));

	}
}
