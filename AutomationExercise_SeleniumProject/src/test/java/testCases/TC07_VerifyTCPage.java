package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageFactory.Home;

public class TC07_VerifyTCPage extends BaseClass {

	@Test

	public void RegisterUser() throws IOException {

		Home HomePage_Ob = new Home(driver);

		// 3. Verify that home page is visible successfully
		HomePage_Ob.OpenHomePage();

		// 4. Click on 'Test Cases' button
		// 5. Verify user is navigated to test cases page successfully
		HomePage_Ob.OpenTestCasePage();

	}
}