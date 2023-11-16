package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Home;
import pageFactory.SigupLogin;

public class TC01_RegisterUser extends BaseClass {

	@Test

	public void RegisterUser() throws IOException {

		Home HomePage_Ob = new Home(driver);

		SigupLogin SigupLogin_Ob = new SigupLogin(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Click on 'Signup / Login' button
		SigupLogin_Ob.OpenSignupLoginPage();

		// 5. Verify 'New User Signup!' is visible
		// 6. Enter name and email address
		// 7. Click 'Signup' button
		SigupLogin_Ob.Signup("Sayali", "saydan@gmail.com");

		// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
		// 9. Fill details: Title, Name, Email, Password, Date of birth
		// 10. Select checkbox 'Sign up for our newsletter!'
		// 11. Select checkbox 'Receive special offers from our partners!'
		// 12. Fill details: First name, Last name, Company, Address, Address2, Country,
		// State, City, Zipcode, Mobile Number
		// 13. Click 'Create Account button'
		// 14. Verify that 'ACCOUNT CREATED!' is visible
		// 15. Click 'Continue' button
		SigupLogin_Ob.CreateAcc();

		// 16. Verify that 'Logged in as username' is visible
		SigupLogin_Ob.VerifyUsername();

		// 17. Click 'Delete Account' button
		// 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		SigupLogin_Ob.DeletAcc();
	}

}
