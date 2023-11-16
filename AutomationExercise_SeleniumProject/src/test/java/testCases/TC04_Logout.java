package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Home;
import pageFactory.SigupLogin;

public class TC04_Logout extends BaseClass {

	@Test
	public void Loginout() {

		Home HomePage_Ob = new Home(driver);

		SigupLogin SigupLogin_Ob = new SigupLogin(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Click on 'Signup / Login' button
		SigupLogin_Ob.OpenSignupLoginPage();

		// 5. Verify 'Login to your account' is visible
		// 6. Enter correct email address and password
		// 7. Click 'login' button
		SigupLogin_Ob.Login("saydan@gmail.com", "test");

		// 8. Verify that 'Logged in as username' is visible
		SigupLogin_Ob.VerifyUsername();

		// 9. Click 'Logout' button
		SigupLogin_Ob.LogoutMenu();

		// 10. Verify that user is navigated to login page
		SigupLogin_Ob.OpenSignupLoginPage();

	}

}
