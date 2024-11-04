package testCases;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.ShopingCartPage;
import testBase.BaseClass;

public class TC005_ProductAddToCartTest extends BaseClass{

	@Test
	public void AddtoCartTest() throws InterruptedException {
		
		Logger.info("****** Starting Add to Cart Test ******");
		
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
		
		Logger.info("****** Click Product link ******");
		hp.clickProduct("MacBook");
		Thread.sleep(2000);
		
		ProductPage pp = new ProductPage(driver);
		
		Logger.info("****** Add product quantity ******");
		pp.AddQuantity("2");
		Thread.sleep(1000);
		Logger.info("****** Click Add To Cart Button ******");
		pp.ClickAddToCart();
		Logger.info("****** Click Home Button ******");
		pp.ClicktoHomepage();
		Thread.sleep(1000);
		
}
	
}

