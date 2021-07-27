package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import cucumber.api.java.en.Then;

public class ProductsPage extends Base {
	@FindBy(xpath = "//span[contains(text(),'We’re not in your area yet')]")
	public WebElement notInAreaMsg;
	
	@FindBy(id="product-search")
	public WebElement productSearch;
	
	@FindBy(xpath="//div[@class='gp-type-ahead gp-type-ahead-mobile-ios']")
	public WebElement productDropdown;
	
	@FindBy(id="shop")
	public WebElement listofProducts;
	
	Map<String, String> searchedProduct = new HashMap<String, String>();
	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyNotInAreaMsg()
	{
		try {
			Thread.sleep(4000);
			if(notInAreaMsg.isDisplayed())
			{
				System.out.println("Not in Area message displayed as: "+ notInAreaMsg.getText());
			}
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
	public void searchProduct()
	{
		productSearch.click();
		System.out.println("Searching for Product");
		productSearch.sendKeys("sundae");
		if(productDropdown.isDisplayed())
		{
			System.out.println("Product dropDown is displayed");
		}
		productSearch.click();
		productSearch.sendKeys(Keys.ENTER);
		//river.findElement(By.xpath("//div[@class='gp-type-ahead__item']/div/b[contains(text(), 'sundae')]")).click();
		System.out.println("Clicked on the product sundae");
	}
	
	
	public void findAllProducts()
	{
		try {
			Thread.sleep(4000);
			if(listofProducts.isDisplayed())
			{
				List<WebElement> allDisplayedProducts = driver.findElements(By.xpath("//div[@class='gp-product-tile__text']"));
				for(WebElement prod : allDisplayedProducts)
				{
					String productName = prod.getText();
					if(productName.contains("Sundae"))
					{
						//System.out.println(ele.getText());
						//String prodName = ele.getText();
						String[] strarr = productName.split(" ");
						String nwStr = "";
						for(String str:strarr)
						{
							if(!(str.contains("'")||str.contains(".")))
							{
								nwStr = nwStr+str+" ";
								
							}
							else
								break;
						}
						nwStr = nwStr.trim();
						System.out.println(nwStr);
						WebElement price = driver.findElement(By.xpath("//div[@class='gp-product-tile__text'][contains(text(),'"+nwStr+"')]/parent::div/div/div/div[@class='gp-product-tile__price gp-product-tile__price-sale']"));
						//System.out.println("Price in view");
						System.out.println(price.getText());
						
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
