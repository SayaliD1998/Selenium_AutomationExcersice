package pageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SigupLogin {

	WebDriver driver;

	// constructor
	public SigupLogin(WebDriver wd) {
		driver = wd;
		PageFactory.initElements(driver, this);
	}

	// Repository of Elements - Signup
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li[4]/child::a")
	WebElement SingupLoginMenu;

	@FindBy(xpath = "//div[@class='signup-form']/child::h2")
	WebElement SignupFormHeading;

	@FindBy(xpath = "//div[@class='signup-form']/child::form/child::input[2]")
	WebElement SignupName;

	@FindBy(xpath = "//div[@class='signup-form']/child::form/child::input[3]")
	WebElement SignupEmail;

	@FindBy(xpath = "//div[@class='signup-form']/child::form/child::button")
	WebElement SignupBtn;

	@FindBy(xpath = "//div[@class='login-form']/child::h2/child::b")
	WebElement CreateAccHeading;

	@FindBy(xpath = "//form[@action='/signup']/child::div[1]/child::div[2]")
	WebElement Title;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;

	@FindBy(xpath = "//select[@id='days']")
	WebElement Day;

	@FindBy(xpath = "//select[@id='months']")
	WebElement Month;

	@FindBy(xpath = "//select[@id='years']")
	WebElement Year;

	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement Checkbox1;

	@FindBy(xpath = "//input[@id='optin']")
	WebElement Checkbox2;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement LastName;

	@FindBy(xpath = "//input[@id='company']")
	WebElement Compny;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement Address;

	@FindBy(xpath = "//input[@id='address2']")
	WebElement Address2;

	@FindBy(xpath = "//select[@id='country']")
	WebElement Country;

	@FindBy(xpath = "//input[@id='state']")
	WebElement State;

	@FindBy(xpath = "//input[@id='city']")
	WebElement City;

	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement Zipcode;

	@FindBy(xpath = "//input[@id='mobile_number']")
	WebElement Mobilenum;

	@FindBy(xpath = "//form[@action='/signup']/child::button")
	WebElement CreateAccBtn;

	@FindBy(xpath = "//form[@action='/signup']/child::p")
	WebElement SignupErrorMsg;

	@FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/child::h2/child::b")
	WebElement PageHeading;

	@FindBy(xpath = "//div[@class='pull-right']/child::a")
	WebElement ContinueBtn;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li[10]/child::a")
	WebElement LogedinAsUsernmaeMenu;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li[5]/child::a")
	WebElement DeletAccMenu;

	@FindBy(xpath = "//form[@action='/login']/child::input[2]")
	WebElement LoginEmail;

	@FindBy(xpath = "//form[@action='/login']/child::input[3]")
	WebElement LoginPassword;

	@FindBy(xpath = "//form[@action='/login']/child::button")
	WebElement LoginBtn;

	@FindBy(xpath = "//form[@action='/login']/child::p")
	WebElement LoginErrorMsg;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li[4]/child::a")
	WebElement LogoutMenu;

	// Methods - Signup

	public void OpenSignupLoginPage() {
		SingupLoginMenu.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(SignupFormHeading));

		String ExpURL = "https://automationexercise.com/login";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ExpURL, ActualURL);
		System.out.println("SignupLoginPage is opened and url is:" + ActualURL);

	}

	public void Signup(String signupname, String signupemail) {
		if (SignupFormHeading.isDisplayed()) {
			System.out.println("signup form heading is visible:" + SignupFormHeading.getText());
		} else {
			System.out.println("signup form heading is not visible");
		}

		SignupName.sendKeys(signupname);

		SignupEmail.sendKeys(signupemail);

		SignupBtn.click();

	}

	public void CreateAcc() throws IOException {
		String FilePath = "C:\\Users\\Acer\\Downloads\\Frameworks.xlsx";

		// read data from file
		FileInputStream fis = new FileInputStream(FilePath);

		// Enter into workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// enter into Login sheet
		XSSFSheet sheet = workbook.getSheet("Register");

		// count no of rows
		int rows = sheet.getLastRowNum();
		System.out.println("Number of Rows are : " + rows);

		// Iterate through all the rows

		for (int i = 1; i <= rows; i++) {
			// enter into row
			XSSFRow row = sheet.getRow(i);

			XSSFCell pass = row.getCell(0); // read data from 0th column

			XSSFCell Fname = row.getCell(1); // read data from 1st column

			XSSFCell Lname = row.getCell(2);

			XSSFCell compny = row.getCell(3);

			XSSFCell Add1 = row.getCell(4);

			XSSFCell Add2 = row.getCell(5);

			XSSFCell state = row.getCell(6);

			XSSFCell city = row.getCell(7);

			XSSFCell zpcode = row.getCell(8);

			XSSFCell mob = row.getCell(9);

			Title.click();

			Password.sendKeys(pass.toString());

			Select drpDay = new Select(Day);
			drpDay.selectByVisibleText("14");

			Select drpMonth = new Select(Month);
			drpMonth.selectByVisibleText("December");

			Select drpYear = new Select(Year);
			drpYear.selectByVisibleText("1992");

			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", Checkbox1);

			j.executeScript("arguments[0].click();", Checkbox2);

			FirstName.sendKeys(Fname.toString());

			LastName.sendKeys(Lname.toString());

			Compny.sendKeys(compny.toString());

			Address.sendKeys(Add1.toString());

			Address2.sendKeys(Add2.toString());

			Select drpCountry = new Select(Country);
			drpYear.selectByVisibleText("1992");

			State.sendKeys(state.toString());

			City.sendKeys(city.toString());

			Zipcode.sendKeys(zpcode.toString());

			Mobilenum.sendKeys(mob.toString());

			j.executeScript("arguments[0].click();", CreateAccBtn);

		}

		fis.close(); // close input stream file

		if (PageHeading.isDisplayed()) {
			System.out.println("Acc is created:" + PageHeading.getText());

			ContinueBtn.click();

		} else {
			System.out.println("Acc is not created");
		}

	}

	public void VerifyUsername() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(LogedinAsUsernmaeMenu));
		System.out.println("Username of loggedin user is: " + LogedinAsUsernmaeMenu.getText());
	}

	public void DeletAcc() {
		DeletAccMenu.click();

		if (PageHeading.isDisplayed()) {
			System.out.println("Acc is deleted:" + PageHeading.getText());

			ContinueBtn.click();

		} else {
			System.out.println("Acc is not deleted");
		}
	}

	public void Login(String lgemail, String lgpass) {
		LoginEmail.sendKeys(lgemail);

		LoginPassword.sendKeys(lgpass);

		LoginBtn.click();

	}

	public void VerifyLoginErrorMsg() {
		if (LoginErrorMsg.isDisplayed()) {
			System.out.println("Error Message is displayed:" + LoginErrorMsg.getText());

		} else {
			System.out.println("User is logedin");
		}

	}

	public void LogoutMenu() {
		LogoutMenu.click();

	}

	public void VerifySignupErrorMsg() {
		if (SignupErrorMsg.isDisplayed()) {
			System.out.println("Error Message is displayed:" + SignupErrorMsg.getText());

		} else {
			System.out.println("User is signup");
		}

	}
}