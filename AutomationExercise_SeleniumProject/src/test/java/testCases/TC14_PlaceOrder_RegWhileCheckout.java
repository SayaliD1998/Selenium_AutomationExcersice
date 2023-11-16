package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Cart;
import pageFactory.Home;
import pageFactory.Products;
import pageFactory.SigupLogin;

public class TC14_PlaceOrder_RegWhileCheckout extends BaseClass {

	@Test
	public void PlaceOrder_RegWhileCheckout() throws InterruptedException, IOException {

		Home HomePage_Ob = new Home(driver);

		Products Products_Ob = new Products(driver);

		Cart Cart_Ob = new Cart(driver);

		SigupLogin SigupLogin_Ob = new SigupLogin(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Add products to cart
		Products_Ob.HovernAddProduct_Prod1();
		Products_Ob.ClickonContinueShopingBtn_Modal();
		Products_Ob.HovernAddProduct_Prod2();

		// 5. Click 'Cart' button
		Products_Ob.ClickonViewCart_Modal();

		// 6. Verify that cart page is displayed
		// 7. Click Proceed To Checkout
		Cart_Ob.ClickProcedToCheckout();

		// 8. Click 'Register / Login' button
		Products_Ob.ClickonRegisterLogin_Modal();

		// 9. Fill all details in Signup and create account
		// 10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
		SigupLogin_Ob.Signup("Sayali", "saydan@gmail.com");
		SigupLogin_Ob.CreateAcc();

		// 11. Verify ' Logged in as username' at top
		SigupLogin_Ob.VerifyUsername();

		// 12.Click 'Cart' button
		Cart_Ob.ClickCartMenu();

		// 13. Click 'Proceed To Checkout' button
		Cart_Ob.ClickProcedToCheckout();

		// 14. Verify Address Details and Review Your Order
		// 15. Enter description in comment text area and click 'Place Order'
		// 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
		// 17. Click 'Pay and Confirm Order' button
		// 18. Verify success message 'Your order has been placed successfully!'

		Cart_Ob.PlaceOrder();

		// 19. Click 'Delete Account' button
		// 20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
		SigupLogin_Ob.DeletAcc();
	}
}
