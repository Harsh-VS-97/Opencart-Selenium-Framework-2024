package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgMyAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btnLogoutContinue;
	
	public boolean MyAccountText() {
		
		try {
		return (msgMyAccount.isDisplayed());
		}
		catch(Exception e) {
			
			return false;
		}
	}
	
	public void ClickLogout() {
		
		Actions action = new Actions(driver);
		action.moveToElement(btnLogout).click().perform();
		
	}
	
	public void ClickLogoutContinue() {
		
		Actions action = new Actions(driver);
		action.moveToElement(btnLogoutContinue).click().perform();
	}

}
