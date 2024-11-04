package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductList;
import pageObject.ProductPage;
import testBase.BaseClass;

public class TC004_ProductListTest extends BaseClass{

	@Test
	public void ProductsListTest() throws InterruptedException {
		
		Logger.info("****** Product List Test Start ******");
	try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.EnterLoginEmail(Pr.getProperty("email"));
		lp.EnterLoginPassword(Pr.getProperty("password"));
		lp.ClickLoginButton();
		Thread.sleep(1000);
		lp.ClickHomeButton();
		Thread.sleep(1000);
		
		ProductList pl = new ProductList(driver);
		
		pl.ProductsList();
		
}
	catch(Exception e) {
		
		Assert.fail();
	}
		
		Logger.info("****** Product List Test End ******");
		
	}
	
}

