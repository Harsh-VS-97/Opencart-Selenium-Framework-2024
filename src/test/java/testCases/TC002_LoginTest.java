package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void Login_Test() throws InterruptedException {
		
		Logger.info("****** Starting Login Test ******");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		Logger.info("****** Clicking My Account ******");
		Thread.sleep(1000);
		hp.clickLogin();
		Logger.info("****** Clicking Login ******");
		Thread.sleep(1000);
		
		LoginPage lp = new LoginPage(driver);
		lp.EnterLoginEmail(Pr.getProperty("email"));
		Logger.info("****** Enter Email in Login Page ******");
		Thread.sleep(1000);
		lp.EnterLoginPassword(Pr.getProperty("password"));
		Logger.info("****** Enter Password in Login Page ******");
		Thread.sleep(1000);
		lp.ClickLoginButton();
		Logger.info("****** Clicking Login Button in Login Page ******");
		Thread.sleep(1000);
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean status = ap.MyAccountText();
		
		Assert.assertEquals(status, true, "Login Fail");
		
		lp.ClickHomeButton();
		Thread.sleep(2000);
		System.out.println("Page Title: " + lp.StoreTitle());
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		Logger.info("****** Ending Login Test ******");
	}
	
}
