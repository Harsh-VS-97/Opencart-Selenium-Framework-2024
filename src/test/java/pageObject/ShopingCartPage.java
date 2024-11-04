package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopingCartPage extends BasePage{

	public ShopingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//a[@title='Shopping Cart']")
	WebElement BtnShopingCart;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tbody//td[2]//a")
	List<WebElement> ProdName;
	
	@FindBy(xpath="//*[contains(text(),\" Success: You have modified your shopping cart! \")]")
	WebElement UpdateAlert;
	
	@FindBy(xpath="//*[contains(text(),\" Success: You have removed an item from your shopping cart! \")]")
	WebElement DeleteAlert;		
	
	@FindBy(xpath="//tfoot[@id='checkout-total']//tr[4]//td[2]")
	WebElement Total;
	
	public void GotoShoppingCart() {
		
		BtnShopingCart.click();
	}
	
	public boolean isProductExist(String name) {
		
		boolean stat=false;
		for(WebElement PN: ProdName) {
		if(PN.getText().equals(name)) {
			stat = true;
		}
	}
		return stat;
	}
	
public void UpdateProductQuantity(String Prod, String Qt) {
		
		for(WebElement PN: ProdName) {
		if(PN.getText().equalsIgnoreCase(Prod)) {
			
			WebElement Quantity = driver.findElement(By.xpath("//tr[contains(.,'" + Prod + "')]//td[4]//input"));
			Quantity.clear();
			Quantity.sendKeys(Qt);
			WebElement updateBtn = driver.findElement(By.xpath("//tr[contains(.,'" + Prod + "')]//td[4]//button[1]"));
			updateBtn.click();
		}
		}
	}
	
	
	public boolean isUpdateAlertExist() {
		
		try {
			return UpdateAlert.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void DeleteProduct(String Pr) {
		
			for(WebElement PrNm: ProdName) {
				if(PrNm.getText().equalsIgnoreCase(Pr)) {
					
			WebElement DeleteBtn = driver.findElement(By.xpath("//tr[contains(.,'" + Pr + "')]//td[4]//button[2]"));
			DeleteBtn.click();
				}
		}
	}
	
	
public boolean isDeleteAlertExist() {
		
		try {
			return DeleteAlert.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}

public String ReturnTotal() {
	
	return Total.getText();
}
}
