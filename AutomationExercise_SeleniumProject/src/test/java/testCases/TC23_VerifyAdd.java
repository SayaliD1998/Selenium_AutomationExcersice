package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Cart;
import pageFactory.Home;
import pageFactory.Products;
import pageFactory.SigupLogin;

public class TC23_VerifyAdd extends BaseClass {

	@Test
	public void VerifyAdd() throws InterruptedException, IOException {

		Home HomePage_Ob = new Home(driver);

		Products Products_Ob = new Products(driver);

		Cart Cart_Ob = new Cart(driver);

		SigupLogin SigupLogin_Ob = new SigupLogin(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Click 'Signup / Login' button
		SigupLogin_Ob.OpenSignupLoginPage();

		// 5. Fill all details in Signup and create account
		SigupLogin_Ob.Signup("Sayali", "saydan@gmail.com");

		// 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
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

		// 12. Verify that the delivery address is same address filled at the time
		// registration of account
		// 13. Verify that the billing address is same address filled at the time
		// registration of account
		Cart_Ob.VerifyAddress();

		// 14. Click 'Delete Account' button

		// 15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
		SigupLogin_Ob.DeletAcc();
	}

}
