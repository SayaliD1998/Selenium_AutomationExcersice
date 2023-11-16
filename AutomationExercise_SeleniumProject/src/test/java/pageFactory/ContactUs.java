package pageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactUs {

	WebDriver driver;

	// constructor
	public ContactUs(WebDriver wd) {
		driver = wd;
		PageFactory.initElements(driver, this);
	}

	// Repository of Elements

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li[8]/child::a")
	WebElement ContactMenu;

	@FindBy(xpath = "//div[@class='contact-form']/child::h2")
	WebElement FormHeading;

	@FindBy(xpath = "//input[@name='name']")
	WebElement Name;

	@FindBy(xpath = "//input[@name='email']")
	WebElement Email;

	@FindBy(xpath = "//input[@name='subject']")
	WebElement Subject;

	@FindBy(xpath = "//textarea[@name='message']")
	WebElement Message;

	@FindBy(xpath = "//input[@name='upload_file']")
	WebElement FileUpload;

	@FindBy(xpath = "//input[@name='submit']")
	WebElement SubmitBtn;

	@FindBy(xpath = "//div[@class='contact-form']/child::div[2]")
	WebElement SucessMsg;

	@FindBy(xpath = "//div[@id='form-section']/child::a")
	WebElement HomeBtn;

	// Methods

	public void OpenContactPage() {
		ContactMenu.click();
		String ExpURL = "https://automationexercise.com/contact_us";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ExpURL, ActualURL);
		System.out.println("Contact page is opened and url is:" + ActualURL);

	}

	public void SubmitContactForm() throws IOException {
		if (FormHeading.isDisplayed()) {
			System.out.println("form heading is visible:" + FormHeading.getText());
		} else {
			System.out.println(" form heading is not visible");
		}

		// Store file path
		String FilePath = "D:\\Selenium\\Eclipse\\Workspace\\Project2_AutomationExercise\\src\\test\\resources\\testData\\Frameworks.xlsx";

		// read data from file
		FileInputStream fis = new FileInputStream(FilePath);

		// Enter into workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// enter into Login sheet
		XSSFSheet sheet = workbook.getSheet("ContactUs");

		// count no of rows
		int rows = sheet.getLastRowNum();

		// Iterate through all the rows

		for (int i = 1; i <= rows; i++) {
			// enter into row
			XSSFRow row = sheet.getRow(i);

			XSSFCell name = row.getCell(0); // read data from 0th column

			XSSFCell email = row.getCell(1); // read data from 1st column

			XSSFCell subject = row.getCell(2);

			XSSFCell msg = row.getCell(3);

			XSSFCell File = row.getCell(4);

			Name.sendKeys(name.toString());

			Email.sendKeys(email.toString());

			Subject.sendKeys(subject.toString());

			Message.sendKeys(msg.toString());

			FileUpload.sendKeys(File.toString());

			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", SubmitBtn);

			Alert alert = driver.switchTo().alert();

			alert.accept();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(SucessMsg));

			if (SucessMsg.isDisplayed()) {
				System.out.println("form is submitted:" + SucessMsg.getText());
			} else {
				System.out.println(" form is not submitted");
			}

			j.executeScript("arguments[0].click();", HomeBtn);

		}

	}
}
