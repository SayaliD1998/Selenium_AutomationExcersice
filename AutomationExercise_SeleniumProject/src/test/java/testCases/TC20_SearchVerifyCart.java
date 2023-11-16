package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Cart;
import pageFactory.Products;
import pageFactory.SigupLogin;

public class TC20_SearchVerifyCart extends BaseClass {
	@Test
	public void SearchVerifyCart() throws InterruptedException {
		Products Products_Ob = new Products(driver);
		SigupLogin SigupLogin_Ob = new SigupLogin(driver);
		Cart Cart_Ob = new Cart(driver);

		// 3. Click on 'Products' button
		// 4. Verify user is navigated to ALL PRODUCTS page successfully
		Products_Ob.OpenProductsPage();

		// 5. Enter product name in search input and click search button
		Products_Ob.SearchProudct("Blue Top");

		// 6. Verify 'SEARCHED PRODUCTS' is visible
		// 7. Verify all the products related to search are visible
		Products_Ob.VerifySearchResult();

		// 8. Add those products to cart
		Products_Ob.HovernAddProduct_Prod1();

		// 9. Click 'Cart' button and verify that products are visible in cart
		Products_Ob.ClickonViewCart_Modal();
		System.out.print("Product in the cart before login:");
		Cart_Ob.CartProducts_List();

		// 10. Click 'Signup / Login' button and submit login details
		SigupLogin_Ob.OpenSignupLoginPage();
		SigupLogin_Ob.Login("saydan@gmail.com", "test");

		// 11. Again, go to Cart page
		Cart_Ob.ClickCartMenu();

		// 12. Verify that those products are visible in cart after login as well
		System.out.print("Product in the cart after login:");
		Cart_Ob.CartProducts_List();

	}

}
