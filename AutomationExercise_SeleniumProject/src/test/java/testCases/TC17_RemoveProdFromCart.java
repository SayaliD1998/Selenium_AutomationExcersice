package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Cart;
import pageFactory.Home;
import pageFactory.Products;

public class TC17_RemoveProdFromCart extends BaseClass {

	@Test
	public void RemoveProdFromCart() throws InterruptedException {

		Home HomePage_Ob = new Home(driver);
		Products Products_Ob = new Products(driver);
		Cart Cart_Ob = new Cart(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Add products to cart
		Products_Ob.HovernAddProduct_Prod1();
		Products_Ob.ClickonContinueShopingBtn_Modal();
		Products_Ob.HovernAddProduct_Prod2();

		// 5. Click 'Cart' button
		// 6. Verify that cart page is displayed
		Products_Ob.ClickonViewCart_Modal();
		System.out.print("Product in the cart before removing products :");
		Cart_Ob.CartProducts_List();
		Thread.sleep(2000);

		// 7. Click 'X' button corresponding to particular product
		Cart_Ob.RemoveProd_cart();
		Thread.sleep(2000);

		// 8. Verify that product is removed from the cart
		System.out.print("Product in the cart after removing products :");
		driver.navigate().refresh();
		Thread.sleep(2000);
		Cart_Ob.CartProducts_List();

	}

}
