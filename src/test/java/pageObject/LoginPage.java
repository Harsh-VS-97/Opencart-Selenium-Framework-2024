package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtLoginEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtLoginPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	public void EnterLoginEmail(String em) {
		
		txtLoginEmail.sendKeys(em);
	}
	
	public void EnterLoginPassword(String pw) {
		
		txtLoginPassword.sendKeys(pw);
	}
	
	public void ClickLoginButton() {
		
		Actions action = new Actions(driver);
		action.moveToElement(btnLogin).click().perform();
		
	}

}
