package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Products {

	WebDriver driver;

	// constructor
	public Products(WebDriver wd) {
		driver = wd;
		PageFactory.initElements(driver, this);
	}

	// Repository of Elements

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li[2]/child::a")
	WebElement ProdMenu;

	@FindBy(xpath = "//input[@id='search_product']")
	WebElement SearchWindow;

	@FindBy(xpath = "//button[@id='submit_search']")
	WebElement SearchIcon;

	@FindBy(xpath = "//h2[contains(text(),'All Products')]")
	WebElement H2Title;

	@FindBy(xpath = "//div[@class='productinfo text-center']/child::p")
	List<WebElement> ProdName;

	@FindBy(xpath = "//div[@id='cartModal']/following-sibling::div[1]/child::div[1]/child::div[1]")
	WebElement Prod1;

	@FindBy(xpath = "//div[@id='cartModal']/following-sibling::div[1]/child::div[1]/child::div[1]/child::div[2]/child::div[1]/child::a")
	WebElement AddtoCart_Prod1;

	@FindBy(xpath = "//div[@id='cartModal']/following-sibling::div[1]/child::div[1]/child::div[2]/child::ul/child::li/child::a")
	WebElement View_Prod1;

	@FindBy(xpath = "//div[@id='cartModal']/following-sibling::div[2]/child::div[1]/child::div[1]")
	WebElement Prod2;

	@FindBy(xpath = "//div[@id='cartModal']/following-sibling::div[2]/child::div[1]/child::div[1]/child::div[2]/child::div[1]/child::a")
	WebElement AddtoCart_Prod2;

	@FindBy(xpath = "//div[@class='product-information']/child::h2")
	WebElement ProdDetail_Name;

	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement modalContainer;

	@FindBy(xpath = "//div[@class='left-sidebar']/child::h2")
	WebElement LeftMenu_CatHeading;

	@FindBy(xpath = "//div[@class='product-information']/child::p")
	WebElement ProdDetail_Cat;

	@FindBy(xpath = "//div[@class='product-information']/child::span/child::span")
	WebElement ProdDetail_Price;

	@FindBy(xpath = "//div[@class='product-information']/child::span/child::input[1]")
	WebElement ProdDetail_Quantity;

	@FindBy(xpath = "//div[@class='product-information']/child::p[2]")
	WebElement ProdDetail_Availability;

	@FindBy(xpath = "//div[@class='product-information']/child::p[3]")
	WebElement ProdDetail_Condition;

	@FindBy(xpath = "//div[@class='product-information']/child::p[4]")
	WebElement ProdDetail_Brand;

	@FindBy(xpath = "//div[@class='product-information']/child::span/child::button")
	WebElement ProdDetail_AddtoCart;

	@FindBy(xpath = "//li[@class='active']/child::a")
	WebElement ProdDetail_WriteReviewHeading;

	@FindBy(xpath = "//input[@id='name']")
	WebElement ProdDetail_ReviewName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement ProdDetail_ReviewEmail;

	@FindBy(xpath = "//textarea[@id='review']")
	WebElement ProdDetail_Review;

	@FindBy(xpath = "//button[@id='button-review']")
	WebElement ProdDetail_ReviewSubmit;

	@FindBy(xpath = "//div[@id='review-section']/child::div[1]/child::div[1]/child::span")
	WebElement ProdDetail_ReviewSucessMsg;

	// Methods

	public void SubmitReview() {
		System.out.println("Heading of review section is: " + ProdDetail_WriteReviewHeading.getText());

		ProdDetail_ReviewName.sendKeys("Megha");

		ProdDetail_ReviewEmail.sendKeys("mravalekar@gmail.com");

		ProdDetail_Review.sendKeys("Test Review");

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", ProdDetail_ReviewSubmit);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ProdDetail_ReviewSucessMsg));

		System.out.println("Sucess message after submitting the review is: " + ProdDetail_ReviewSucessMsg.getText());
	}

	public void OpenProductsPage() {
		ProdMenu.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(H2Title));

		/*
		 * String ExpURL = "https://automationexercise.com/products" ; String ActualURL
		 * = driver.getCurrentUrl(); Assert.assertEquals(ExpURL, ActualURL);
		 * System.out.println(" Products Page is opened and url is:" +ActualURL);
		 */

		String ExpTitle = "ALL PRODUCTS";
		String ActTitle = H2Title.getText();
		Assert.assertEquals(ExpTitle, ActTitle);
		System.out.println("Products page is opened");

	}

	public void SearchProudct(String prodName) {
		SearchWindow.sendKeys(prodName);
		SearchIcon.click();
	}

	public void VerifySearchResult() {

		System.out.println("result page shows : " + ProdName.size() + " products");
		System.out.println("Result page shows following products: ");

		for (WebElement e : ProdName) {
			System.out.println(e.getText());
			if (e.getText().contains("top")) {
				System.out.println("Result page show all the products related to 'top' ");
			} else {
				System.out.println("Result page show products related to other categories also ");
			}
		}
	}

	public void HovernAddProduct_Prod1() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true);", LeftMenu_CatHeading);

		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", H2Title);

		Actions actions = new Actions(driver);

		actions.moveToElement(Prod1).build().perform();

		Thread.sleep(2000);

		actions.click(AddtoCart_Prod1).build().perform();

		Thread.sleep(2000);

	}

	public void HovernAddProduct_Prod2() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true);", LeftMenu_CatHeading);

		Actions actions = new Actions(driver);

		actions.moveToElement(Prod2).build().perform();

		Thread.sleep(2000);

		actions.click(AddtoCart_Prod2).build().perform();

		Thread.sleep(2000);

	}

	public void ClickonViewCart_Modal() {
		WebElement modalviewcart = modalContainer
				.findElement(By.xpath("//div[@class='modal-content']/child::div[2]/child::p[2]/child::a"));

		modalviewcart.click();

	}

	public void ClickonContinueShopingBtn_Modal() {
		WebElement modalContinueShopingBtn = modalContainer
				.findElement(By.xpath("//div[@class='modal-content']/child::div[3]/child::button"));

		modalContinueShopingBtn.click();

	}

	public void ClickonRegisterLogin_Modal() {
		WebElement modalRegisterLoginLink = modalContainer
				.findElement(By.xpath("//div[@class='modal-content']/child::div[2]/child::p[2]/child::a"));

		modalRegisterLoginLink.click();

	}

	public void ClickonContinueonCart_Modal() {
		WebElement modalContinueonCartBtn = modalContainer
				.findElement(By.xpath("//div[@class='modal-content']/child::div[3]/child::button"));

		modalContinueonCartBtn.click();

	}

	public void ViewProd_1() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true);", LeftMenu_CatHeading);

		View_Prod1.click();
	}

	public void AddQuantity4() {
		ProdDetail_Quantity.clear();
		ProdDetail_Quantity.sendKeys("4");
		ProdDetail_AddtoCart.click();

	}

}
