package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Home;

public class TC26_ScrollWithoutArrow extends BaseClass {
	@Test
	public void ScrollWithoutArrow() {
		Home HomePage_Ob = new Home(driver);
		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Scroll down page to bottom
		HomePage_Ob.ScrollTofooter();

		// 5. Verify 'SUBSCRIPTION' is visible
		HomePage_Ob.VerifySubscriptionHeading();

		// 6. Scroll up page to top
		HomePage_Ob.ScrolltoTop();

		// 7. Verify that page is scrolled up and 'Full-Fledged practice website for
		// Automation Engineers' text is visible on screen
	}

}
