package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Cart;
import pageFactory.Home;
import pageFactory.Products;
import pageFactory.SigupLogin;

public class TC16_PlaceOrder_LoginBeforeCheckout extends BaseClass {

	@Test
	public void PlaceOrder_LoginBeforeCheckout() throws InterruptedException {

		Home HomePage_Ob = new Home(driver);

		Products Products_Ob = new Products(driver);

		Cart Cart_Ob = new Cart(driver);

		SigupLogin SigupLogin_Ob = new SigupLogin(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Click 'Signup / Login' button
		SigupLogin_Ob.OpenSignupLoginPage();

		// 5. Fill email, password and click 'Login' button
		SigupLogin_Ob.Login("saydan@gmail.com", "test");

		// 6. Verify 'Logged in as username' at top
		SigupLogin_Ob.VerifyUsername();

		// 7. Add products to cart
		Products_Ob.HovernAddProduct_Prod1();
		Products_Ob.ClickonContinueShopingBtn_Modal();
		Products_Ob.HovernAddProduct_Prod2();

		// 8. Click 'Cart' button
		Products_Ob.ClickonViewCart_Modal();

		// 9. Verify that cart page is displayed
		// 10. Click Proceed To Checkout
		Cart_Ob.ClickProcedToCheckout();

		// 11. Verify Address Details and Review Your Order
		// 12. Enter description in comment text area and click 'Place Order'
		// 13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
		// 14. Click 'Pay and Confirm Order' button
		// 15. Verify success message 'Your order has been placed successfully!'
		Cart_Ob.PlaceOrder();

	}
}
