package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement TxtSearch;
	
	@FindBy(xpath="//button[@class='btn btn-light btn-lg']")
	WebElement BtnSearch;
	
	@FindBy(xpath="//div[@id='product-list']//img")
	List<WebElement> SearchResult;
	
	public void EnterProductSearch(String p) {
		
		TxtSearch.sendKeys(p);
	}

	
	public void ClickSearchButton() {
		
		BtnSearch.click();
	}
	
	public boolean isProductExist(String productName)
	{
		boolean flag=false;
		for(WebElement product:SearchResult)
		{				
			if(product.getAttribute("title").equals(productName))
			{
			flag=true;
			break;
			}
		}
		
		return flag;
	
	}
	
	public void ProductSelect(String ps) {
		
		for(WebElement SrchP : SearchResult) {
			
			String Prodname = SrchP.getAttribute("alt");
			if(Prodname.equalsIgnoreCase(ps)) {
				
				try {
					SrchP.click();
				}
				catch(Exception e) {
					
				}
			}
		}
	}
}
