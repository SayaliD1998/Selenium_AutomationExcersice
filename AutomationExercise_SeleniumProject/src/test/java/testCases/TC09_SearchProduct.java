package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Home;
import pageFactory.Products;

public class TC09_SearchProduct extends BaseClass {
	@Test
	public void SearchProduct() {
		Home HomePage_Ob = new Home(driver);

		Products Products_Ob = new Products(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();
		// HomePage_Ob.CloseIframe();

		// 4. Click on 'Products' button
		// 5. Verify user is navigated to ALL PRODUCTS page successfully
		Products_Ob.OpenProductsPage();

		// 6. Enter product name in search input and click search button
		Products_Ob.SearchProudct("Blue Top");

		// 7. Verify 'SEARCHED PRODUCTS' is visible
		// 8. Verify all the products related to search are visible
		Products_Ob.VerifySearchResult();
	}

}
