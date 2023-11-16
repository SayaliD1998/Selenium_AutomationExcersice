package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Cart;
import pageFactory.Home;
import pageFactory.Products;
import pageFactory.SigupLogin;

public class TC22_AddtoCart_RecommendedItem extends BaseClass {

	@Test
	public void AddtoCart_RecommendedItem() throws InterruptedException {
		Home HomePage_Ob = new Home(driver);

		// 3. Scroll to bottom of page

		// 4. Verify 'RECOMMENDED ITEMS' are visible

		// 5. Click on 'Add To Cart' on Recommended product
		HomePage_Ob.AddRecommendedItes();
		Products Products_Ob = new Products(driver);

		Cart Cart_Ob = new Cart(driver);

		// 6. Click on 'View Cart' button
		Products_Ob.ClickonViewCart_Modal();

		// 7. Verify that product is displayed in cart page
		Cart_Ob.CartProducts_List();
	}

}
