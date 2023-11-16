package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Home;

public class TC10_VerifySubscription extends BaseClass {

	@Test
	public void VerifySubscription() {
		Home HomePage_Ob = new Home(driver);
		// 3. Verify that home page is visible successfully

		HomePage_Ob.OpenHomePage();

		// 4. Scroll down to footer
		HomePage_Ob.ScrollTofooter();

		// 5. Verify text 'SUBSCRIPTION'
		HomePage_Ob.VerifySubscriptionHeading();

		// 6. Enter email address in input and click arrow button
		// 7. Verify success message 'You have been successfully subscribed!' is visible
		HomePage_Ob.Subscribe();
	}

}
