package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.SearchPage;
import testBase.BaseClass;

public class TC006_SearchProductTest extends BaseClass{

	@Test
	public void SearchPageTest() throws InterruptedException {
		
Logger.info("****** Starting Search product Test ******");
		
		Logger.info("****** Click My account ******");
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		
		Logger.info("****** Click Login ******");
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
		
		SearchPage sp = new SearchPage(driver);
		ProductPage pp = new ProductPage(driver);
		
		Logger.info("****** Enter Product name to Search ******");
		sp.EnterProductSearch("iPhone");
		Thread.sleep(1000);
		Logger.info("****** Click Search Button ******");
		sp.ClickSearchButton();
		Thread.sleep(1000);
		Logger.info("****** If Product Exist ******");
		if(sp.isProductExist("iPhone")) {
			
			Logger.info("****** Click Product Button ******");
			sp.ProductSelect("iPhone");
			
			Logger.info("****** Enter Product Qauntity ******");
			pp.AddQuantity("2");
			
			Logger.info("****** Click Add To Cart button");
			pp.ClickAddToCart();
			
			Thread.sleep(1000);
			Logger.info("****** Click Home Button");
			pp.ClicktoHomepage();
		}
		else {System.out.println("Product not exist");
		Assert.fail();
	}
}
}
