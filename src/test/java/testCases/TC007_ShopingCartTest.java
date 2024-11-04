package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShopingCartPage;
import testBase.BaseClass;

public class TC007_ShopingCartTest extends BaseClass{

	@Test
	public void ShoppingCartTest() throws InterruptedException {
		
Logger.info("****** Starting Shopping Cart Test ******");
		
		Logger.info("****** Click My account ******");
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		Logger.info("****** Enter Email ID ******");
		lp.EnterLoginEmail(Pr.getProperty("email"));
		Logger.info("****** Enter Password ******");
		lp.EnterLoginPassword(Pr.getProperty("password"));
		Logger.info("****** Click Login Button ******");
		lp.ClickLoginButton();
		Thread.sleep(1000);
		Logger.info("****** Click HomePage button on My Account ******");
		lp.ClickHomeButton();
		Thread.sleep(1000);
		
		ShopingCartPage sc = new ShopingCartPage(driver);
		
		Logger.info("****** Click Shopping Cart link ******");
		
		sc.GotoShoppingCart();
		Thread.sleep(1000);
		
		Logger.info("****** Check if product exist ******");
		
		Logger.info("****** Check if Macbook Exist ******");
		if(sc.isProductExist("MacBook")) {
			
			System.out.println("Product present in shopping cart");
			Assert.assertTrue(true);
		}
		else {
			
			System.out.println("Product not exist");
			Assert.assertTrue(false);
		}
		
		
		Logger.info("****** Check if iPhone Exist ******");
		if(sc.isProductExist("iPhone")) {
			
			System.out.println("Product present in shopping cart");
			Assert.assertTrue(true);
		}
		else {
			
			System.out.println("Product not exist");
			Assert.assertTrue(false);
		}
		
		Logger.info("****** Total amount of Products ******");
		
		System.out.println("Total Amount: " + sc.ReturnTotal());

		Logger.info("****** Update Product Quantity ******");
		
		sc.UpdateProductQuantity("MacBook", "3");
		Thread.sleep(2000);
		
		Logger.info("****** Update Alert Testing ******");
		
		if(sc.isUpdateAlertExist()) {
			
			System.out.println("Alert displayed successfully");
			Assert.assertTrue(true);
		}
		else {
			
			System.out.println("Alert unsuccessful");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		
		Logger.info("****** Delete Product ******");
		
		sc.DeleteProduct("iPhone");
		Thread.sleep(2000);
		
		Logger.info("****** Update Alert Testing ******");
		
		if(sc.isDeleteAlertExist()) {
			
			System.out.println("Alert displayed successfully");
			Assert.assertTrue(true);
		}
		else {
			
			System.out.println("Alert unsuccessful");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);
		
Logger.info("****** Total Updated Amount ******");
		
		System.out.println("Updated Total Amount: " + sc.ReturnTotal());
		
		
	}
	
	
	
	
}
