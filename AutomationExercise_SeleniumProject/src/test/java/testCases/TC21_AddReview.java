package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Products;

public class TC21_AddReview extends BaseClass {

	@Test
	public void AddReview() throws InterruptedException {

		Products Products_Ob = new Products(driver);

		// 3. Click on 'Products' button
		// 4. Verify user is navigated to ALL PRODUCTS page successfully
		Products_Ob.OpenProductsPage();

		// 5. Click on 'View Product' button
		Products_Ob.ViewProd_1();

		// 6. Verify 'Write Your Review' is visible
		// 7. Enter name, email and review
		// 8. Click 'Submit' button
		// 9. Verify success message 'Thank you for your review.'
		Products_Ob.SubmitReview();

	}

}
