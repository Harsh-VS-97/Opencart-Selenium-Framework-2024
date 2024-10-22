package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.Dataprovider;

public class TC003_DDT_LoginTest extends BaseClass{

	
	@Test(dataProvider="LoginDataProvider", dataProviderClass=Dataprovider.class, groups="DataDriven")
	public void verify_DDT_Login(String email, String password, String expectedRes) throws InterruptedException {
		
		Logger.info("****** Starting Data Driven Login Test ******");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		Logger.info("****** Clicking My Account ******");
		Thread.sleep(1000);
		hp.clickLogin();
		Logger.info("****** Clicking Login ******");
		Thread.sleep(1000);
		
		LoginPage lp = new LoginPage(driver);
		lp.EnterLoginEmail(email);
		Logger.info("****** Enter Email in Login Page ******");
		Thread.sleep(1000);
		lp.EnterLoginPassword(password);
		Logger.info("****** Enter Password in Login Page ******");
		Thread.sleep(1000);
		lp.ClickLoginButton();
		Logger.info("****** Clicking Login Button in Login Page ******");
		Thread.sleep(1000);
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean status = ap.MyAccountText();
		
		if(expectedRes.equalsIgnoreCase("Valid")) {
			
			if(status==true) {
				
				ap.ClickLogout();
				ap.ClickLogoutContinue();
				Assert.assertTrue(true);
			}
			else {
				
				Assert.assertTrue(false);
			}
			
		}
		
if(expectedRes.equalsIgnoreCase("Invalid")) {
			
			if(status==true) {
				
				ap.ClickLogout();
				ap.ClickLogoutContinue();
				Assert.assertTrue(false);
			}
			else {
				
				Assert.assertTrue(true);
			}
			
		}
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		finally {
			
		Logger.info("****** Ending Data Driven Login Test ******");
		}
	}
	
	
	
}
