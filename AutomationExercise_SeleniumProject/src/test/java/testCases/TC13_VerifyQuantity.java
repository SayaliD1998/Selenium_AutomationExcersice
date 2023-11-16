package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Cart;
import pageFactory.Home;
import pageFactory.Products;

public class TC13_VerifyQuantity extends BaseClass {

	@Test
	public void VerifyQuantity() {
		Home HomePage_Ob = new Home(driver);

		Products Products_Ob = new Products(driver);

		Cart Cart_Ob = new Cart(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Click 'View Product' for any product on home page
		// 5. Verify product detail is opened
		Products_Ob.ViewProd_1();

		// 6. Increase quantity to 4
		// 7. Click 'Add to cart' button
		Products_Ob.AddQuantity4();

		// 8. Click 'View Cart' button
		Products_Ob.ClickonViewCart_Modal();

		// 9. Verify that product is displayed in cart page with exact quantity
		Cart_Ob.CartProducts_List();
	}

}
