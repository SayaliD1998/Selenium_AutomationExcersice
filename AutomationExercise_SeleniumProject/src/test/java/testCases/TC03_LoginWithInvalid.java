package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Home;
import pageFactory.SigupLogin;

public class TC03_LoginWithInvalid extends BaseClass {

	@Test
	public void LoginWithInvalid() {

		Home HomePage_Ob = new Home(driver);

		SigupLogin SigupLogin_Ob = new SigupLogin(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();
		// 4. Click on 'Signup / Login' button
		SigupLogin_Ob.OpenSignupLoginPage();

		// 5. Verify 'Login to your account' is visible
		// 6. Enter incorrect email address and password
		// 7. Click 'login' button
		SigupLogin_Ob.Login("test@gmail.com", "test");

		// 8. Verify error 'Your email or password is incorrect!' is visible
		SigupLogin_Ob.VerifyLoginErrorMsg();

	}
}
