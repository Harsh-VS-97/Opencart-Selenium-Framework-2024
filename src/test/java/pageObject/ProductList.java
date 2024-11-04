package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ProductList extends BasePage{

	public ProductList(WebDriver driver) {
		super(driver);
	}
	
	@FindAll(@FindBy(xpath="//div[@class='content']//h4"))
	List<WebElement> products;
	

	
	public void ProductsList() {
		int i=1;
		for(WebElement product : products) {
			
			 System.out.println("Product "+ i++ + ": " +product.getText());
			
		}
		
	}	
	
}
