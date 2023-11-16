package pageFactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home {

	WebDriver driver;

	// constructor
	public Home(WebDriver wd) {
		driver = wd;
		PageFactory.initElements(driver, this);
	}

	// Repository of Elements

	// @FindBy(xpath = "")
	// WebElement BannerH1;

	@FindBy(xpath = "//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")
	WebElement BannerH2;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li[5]/child::a")
	WebElement TestCaseMenu;

	@FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/child::h2/child::b")
	WebElement h2heading;

	@FindBy(xpath = "//div[@class='single-widget']/child::h2")
	WebElement SubscriptionHeading;

	@FindBy(xpath = "//form[@class='searchform']/child::input[2]")
	WebElement Subscriptionemail;

	@FindBy(xpath = "//form[@class='searchform']/child::button[1]")
	WebElement SubscriptionArrow;

	@FindBy(xpath = "//div[@id='success-subscribe']/child::div")
	WebElement SubscriptionSucessMsg;

	@FindBy(xpath = "//div[@class='recommended_items']/child::h2")
	WebElement RecommendedItem_Heading;

	@FindBy(xpath = "//div[@class='productinfo text-center']/child::a")
	WebElement RecommendedItem_AddtoCart;

	@FindBy(xpath = "//a[@id='scrollUp']")
	WebElement ScrollToUp;

	// Methods

	public void VerifyBannerText() {
		if (BannerH2.isDisplayed()) {
			System.out.println("Text on banner is: " + BannerH2.getText());
		} else {
			System.out.println("Text not visible");
		}
	}

	public void AddRecommendedItes()

	{

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView();", RecommendedItem_Heading);

		if (RecommendedItem_Heading.isDisplayed()) {
			System.out.println("Heading of the Recommende Items section is: " + RecommendedItem_Heading.getText());
		} else {
			System.out.println("Recommended Items not visible");
		}

		j.executeScript("arguments[0].click();", RecommendedItem_AddtoCart);
	}

	public void OpenHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(BannerH2));
		/*
		 * String ExpURL = "https://automationexercise.com/" ; String ActualURL =
		 * driver.getCurrentUrl(); Assert.assertEquals(ExpURL, ActualURL);
		 * System.out.println("Home page is opened and url is:" +ActualURL);
		 */

		String ExpTitle = "Full-Fledged practice website for Automation Engineers";
		String ActTitle = BannerH2.getText();
		Assert.assertEquals(ExpTitle, ActTitle);
		System.out.println("Home page is opened");

	}

	public void OpenTestCasePage() {
		TestCaseMenu.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(h2heading));
		String ExpURL = "https://automationexercise.com/test_cases";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ExpURL, ActualURL);
		System.out.println("Test Case page is opened and url is:" + ActualURL);

	}

	public void ScrollTofooter() {

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView();", SubscriptionHeading);

	}

	public void VerifySubscriptionHeading() {
		if (SubscriptionHeading.isDisplayed()) {
			System.out.println("subscription text is visible:" + SubscriptionHeading.getText());
		} else {
			System.out.println("subscription text is not visible");
		}
	}

	public void Subscribe() {
		Subscriptionemail.sendKeys("mravalekar@gmail.com");
		SubscriptionArrow.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(SubscriptionSucessMsg));
		System.out.println("Message after subscription is : " + SubscriptionSucessMsg.getText());
	}

	public void GotoTopUsingArrow() {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		j.executeScript("arguments[0].click();", ScrollToUp);

	}

	public void ScrolltoTop() {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

	}

}
