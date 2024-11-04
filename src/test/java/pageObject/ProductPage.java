package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='mb-3']//input")
	WebElement ProductQuantity;
	
	@FindBy(xpath="//div[@class='mb-3']//button")
	WebElement BtnAddToCart;
	
	@FindBy(xpath="//button[@aria-label='Add to Wish List']")
	WebElement BtnAddToWishList;
	
	@FindBy(xpath="//img[@title='Your Store']")
	WebElement BtnHomePage;
	
	@FindBy(xpath="//div[@class='col-sm']//h1")
	WebElement ProdName;
	
	@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
	WebElement Alert;
	
	@FindBy(xpath="//select[@id='input-option-226']")
	WebElement DropDownSelect;

	
	public void AddQuantity(String q) {
		
		ProductQuantity.clear();
		ProductQuantity.sendKeys(q);
	}
	
	public void SelectColour(String col) {
		
		Select s = new Select(DropDownSelect);
		s.selectByVisibleText(col);
	}
	
	public void ClickAddToWishList() {
		
		BtnAddToWishList.click();
	}
	
	public void ClickAddToCart() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(BtnAddToCart)).click();
		
	}
	
	public void ClicktoHomepage() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(BtnHomePage)).click();
	}

	public boolean SuccessAlertMessage() {
		
		try {
			
			return Alert.isDisplayed();
		}
		catch(Exception e) {
			
			return false;
		}
		
	}

}
