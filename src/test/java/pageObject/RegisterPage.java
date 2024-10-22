package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	
	public RegisterPage(WebDriver driver) {
		super(driver);
		
	}
	
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement sldPrivacy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgAccountCreated;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btnAccCreatedContinue;
	
	public void EnterFirstname(String frstnm) {
		
		txtFirstName.sendKeys(frstnm);
	}
	
	public void EnterLastname(String lastnm) {
		
		txtLastName.sendKeys(lastnm);
	}
	
	public void EnterEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
	
	public void Enterpassword(String password) {
		
		txtPassword.sendKeys(password);
	}
	
	public void ClickPrivacyPolicy() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(sldPrivacy).click().perform();
	}
	
	public void ClickContinue() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(btnContinue).click().perform();
	}
	
	public String Message() {
		try{
		return (msgAccountCreated.getText());}
		catch(Exception e) {
			return (e.getMessage());
		}
		
	}

	public void ClickContinueOnAC() {
		
		btnAccCreatedContinue.click();
	}
}
