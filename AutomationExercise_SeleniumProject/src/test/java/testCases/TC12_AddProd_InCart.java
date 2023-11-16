package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Cart;
import pageFactory.Home;
import pageFactory.Products;

public class TC12_AddProd_InCart extends BaseClass {

	@Test
	public void AddProduct() throws InterruptedException {

		Home HomePage_Ob = new Home(driver);

		Products Products_Ob = new Products(driver);

		Cart Cart_Ob = new Cart(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Click 'Products' button
		Products_Ob.OpenProductsPage();

		// 5. Hover over first product and click 'Add to cart'

		Products_Ob.HovernAddProduct_Prod1();

		// 6. Click 'Continue Shopping' button
		Products_Ob.ClickonContinueShopingBtn_Modal();

		// 7. Hover over second product and click 'Add to cart'
		Products_Ob.HovernAddProduct_Prod2();

		// 8. Click 'View Cart' button
		Products_Ob.ClickonViewCart_Modal();

		// 9. Verify both products are added to Cart
		// 10. Verify their prices, quantity and total price
		Cart_Ob.CartProducts_List();

	}

}
