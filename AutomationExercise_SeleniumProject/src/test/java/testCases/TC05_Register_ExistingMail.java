package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Home;
import pageFactory.SigupLogin;

public class TC05_Register_ExistingMail extends BaseClass {

	@Test

	public void Register_ExistingMail() throws IOException {

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

		// 8. Verify error 'Email Address already exist!' is visible
		SigupLogin_Ob.VerifySignupErrorMsg();

	}
}
