package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Cart;
import pageFactory.Home;
import pageFactory.Products;
import pageFactory.SigupLogin;

public class TC15_PlaceOrder_RegBeforeCheckout extends BaseClass {

	@Test
	public void PlaceOrder_RegBeforeCheckout() throws IOException, InterruptedException {

		Home HomePage_Ob = new Home(driver);

		Products Products_Ob = new Products(driver);

		Cart Cart_Ob = new Cart(driver);

		SigupLogin SigupLogin_Ob = new SigupLogin(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Click 'Signup / Login' button
		SigupLogin_Ob.OpenSignupLoginPage();

		// 5. Fill all details in Signup and create account
		// 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
		SigupLogin_Ob.Signup("Sayali", "saydan@gmail.com");
		SigupLogin_Ob.CreateAcc();

		// 7. Verify ' Logged in as username' at top
		SigupLogin_Ob.VerifyUsername();

		// 8. Add products to cart
		Products_Ob.HovernAddProduct_Prod1();
		Products_Ob.ClickonContinueShopingBtn_Modal();
		Products_Ob.HovernAddProduct_Prod2();

		// 9. Click 'Cart' button
		Products_Ob.ClickonViewCart_Modal();

		// 10. Verify that cart page is displayed
		// 11. Click Proceed To Checkout
		Cart_Ob.ClickProcedToCheckout();

		// 12. Verify Address Details and Review Your Order
		// 13. Enter description in comment text area and click 'Place Order'
		// 14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
		// 15. Click 'Pay and Confirm Order' button
		// 16. Verify success message 'Your order has been placed successfully!'
		Cart_Ob.PlaceOrder();

		// 17. Click 'Delete Account' button
		// 18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
		SigupLogin_Ob.DeletAcc();

	}
}
