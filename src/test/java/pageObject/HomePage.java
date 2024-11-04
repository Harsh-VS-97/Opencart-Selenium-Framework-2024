package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement Accounts;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
	
	@FindBy(xpath="//*[@id='content']/div[2]//img")
	List<WebElement> products;
	
	public void clickMyAccount() {
		
		Accounts.click();
	}
	
	public void clickRegister() {
		
		Register.click();
	}
	
	public void clickLogin() {
		
		Login.click();
	}
	
	public void clickProduct(String prod) {
		try {
		for(WebElement product : products) {
			
			
			if(product.getAttribute("title").equals(prod)) {
				
				product.click();
				
			}
		}
		}
		catch(Exception e) {
			
		}
	}
	
	
}
