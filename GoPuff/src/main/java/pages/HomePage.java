package pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePage extends Base
{
	@FindBy(id="address-lookup")
	public WebElement deliveryAddress;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath = "//div[@class='search-results__row absolute bg-white w-full rounded']")
	public WebElement deliveryLocDpDwn;
	
	@FindBy(xpath = "//div[@class='animation-content modal-content']")
	public WebElement notInArea;
	
	//@FindBy(xpath = "//span[contains(text(),'Browse Products')]")
	@FindBy(xpath = "//button[@class='btn rounded btn--text btn--full-width']")
	public WebElement browseProductsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
//	public void homepage()
//	{
//		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJava\\Drivers\\chrome_91\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://gopuff.com/go");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}
	
	public void enterDeliveryAddress()
	{
		try {
			deliveryAddress.click();
			deliveryAddress.sendKeys("NY, USA");
			Thread.sleep(1000);
			if(deliveryLocDpDwn.isDisplayed())
			{
				System.out.println("Location drop DownDisplayed");
				driver.findElement(By.xpath("//div[@class='secondary-search-label'][contains(text(),'NY, USA')]")).click();
				System.out.println("Selected delivery location");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//submitButton.click();
	}

	public ProductsPage verifyNotInAreaPopup()
	{
		try {
			Thread.sleep(4000);
			if(notInArea.isDisplayed())
			{
				System.out.println("Not in area messgae");
			}
			System.out.println("Before licking browse product");
			Thread.sleep(2000);
			browseProductsLink.click();
			System.out.println("Clicked on Browse Products link");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ProductsPage();
	}
}
