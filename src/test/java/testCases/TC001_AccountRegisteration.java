package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegisterPage;
import testBase.BaseClass;


public class TC001_AccountRegisteration extends BaseClass {
	

	
	@Test(groups={"Regression","Master"})
	public void Account_Registeration_Test() throws InterruptedException {
		
		Logger.info("****** Starting TC001_Account_Registeration_Test ******");
		
		try {
		HomePage hp = new HomePage(driver); 
		
		hp.clickMyAccount();
		Logger.info("****** Clicking My Accounts ******");
		Thread.sleep(2000);
		hp.clickRegister();
		Logger.info("****** Clicking Register ******");
		Thread.sleep(2000);
		
		String email = randomString()+"@gmail.com";
		String password = randomAlphaNumeric();
		
		RegisterPage rp = new RegisterPage(driver);
		Logger.info("****** On Register Page ******");
		
		rp.EnterFirstname(randomString());
		Logger.info("****** Enter First Name ******");
		Thread.sleep(1000);
		rp.EnterLastname(randomString());
		Logger.info("****** Enter Last Name ******");
		Thread.sleep(1000);
		rp.EnterEmail(email);
		Logger.info("****** Enter Email ******");
		Thread.sleep(1000);
		rp.Enterpassword(password);
		Logger.info("****** Enter New Password ******");
		Thread.sleep(1000);
		rp.ClickPrivacyPolicy();
		Logger.info("****** Clicking Privacy Policy Button ******");
		Thread.sleep(1000);
		rp.ClickContinue();
		Logger.info("****** Clicking Continue Button on Register Page ******");
		Thread.sleep(1000);
		
		String AccountCreatedMsg = rp.Message();
		System.out.println("Acctual Message: " + AccountCreatedMsg);
		System.out.println("Registered Email: " + email);
		System.out.println("New Password: " + password);
		
		if(AccountCreatedMsg.equals("Your Account Has Been Created!")) {
			
			Assert.assertTrue(true);
		}
		
		else
		{
			Logger.error("Test Failed.........");
			Logger.debug("Debug Logs..........");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(AccountCreatedMsg, "Your Account Has Been Created!!!"); Harsh Assertion not create debug files in log4j2 file
		Logger.info("****** Testing Account Created Message ******");
		
		rp.ClickContinueOnAC();
		Logger.info("****** Continue Button on Account Created Confirmation Page ******");}
		catch(Exception e) {
			Assert.fail();
		}
		
		Logger.info("****** Ending TC001_Account_Registeration_Test ******");
	}
	
	
	
}

