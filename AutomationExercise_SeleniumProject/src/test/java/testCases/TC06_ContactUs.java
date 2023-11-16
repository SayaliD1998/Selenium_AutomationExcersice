package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.ContactUs;
import pageFactory.Home;

public class TC06_ContactUs extends BaseClass {

	@Test

	public void ContactUs() throws IOException {

		Home HomePage_Ob = new Home(driver);

		ContactUs ContactUs_Ob = new ContactUs(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Click on 'Contact Us' button
		ContactUs_Ob.OpenContactPage();

		// 5. Verify 'GET IN TOUCH' is visible
		// 6. Enter name, email, subject and message
		// 7. Upload file
		// 8. Click 'Submit' button
		// 9. Click OK button
		// 10. Verify success message 'Success! Your details have been submitted
		// successfully.' is visible

		ContactUs_Ob.SubmitContactForm();

		// 11. Click 'Home' button and verify that landed to home page successfully
		HomePage_Ob.OpenHomePage();

	}
}
