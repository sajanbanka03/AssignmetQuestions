package runner;



import org.junit.Test;
import pages.HomePage;
import pages.ProductsPage;



public class RunFeatures extends Final {
		@Test
		public void test()
		{
			HomePage home = new HomePage();
			home.enterDeliveryAddress();
			ProductsPage prodPage = home.verifyNotInAreaPopup();
			prodPage.verifyNotInAreaMsg();
			prodPage.searchProduct();
			prodPage.findAllProducts();
			
		}


}