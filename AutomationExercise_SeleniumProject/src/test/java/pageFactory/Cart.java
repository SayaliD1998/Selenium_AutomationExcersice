package pageFactory;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {

	WebDriver driver;

	// constructor
	public Cart(WebDriver wd) {
		driver = wd;
		PageFactory.initElements(driver, this);
	}

	// Repository of Elements - Signup
	@FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr")
	List<WebElement> CartTableRow;

	@FindBy(xpath = "//table[@id='cart_info_table']/thead/tr/td")
	List<WebElement> CartTableCol;

	@FindBy(xpath = "//tr[@id='product-1']/child::td[6]/child::a")
	WebElement CartTableDeleteBtn;

	@FindBy(xpath = "//div[@class='col-sm-6']/child::a")
	WebElement ProceedToCheckoutBtn;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li[3]/child::a")
	WebElement CartMenu;

	@FindBy(xpath = "//ul[@id='address_delivery']/child::li")
	List<WebElement> Checkout_DeliveryAdd;

	@FindBy(xpath = "//ul[@id='address_invoice']/child::li")
	List<WebElement> Checkout_BillingAdd;

	@FindBy(xpath = "//textarea[@name='message']")
	WebElement Checkout_Comment;

	@FindBy(xpath = "//div[@id='ordermsg']/following::div[1]/child::a")
	WebElement Checkout_PalceOrder;

	@FindBy(xpath = "//input[@name='name_on_card']")
	WebElement Payment_CardName;

	@FindBy(xpath = "//input[@name='card_number']")
	WebElement Payment_CardNumber;

	@FindBy(xpath = "//input[@name='cvc']")
	WebElement Payment_CVC;

	@FindBy(xpath = "//input[@name='expiry_month']")
	WebElement Payment_Month;

	@FindBy(xpath = "//input[@name='expiry_year']")
	WebElement Payment_Year;

	@FindBy(xpath = "//button[@id='submit']")
	WebElement Payment_PayBtn;

	@FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/child::a")
	WebElement Payment_DownloadInvoice;

	@FindBy(xpath = "//div[@class='pull-right']/child::a")
	WebElement Payment_ContinueBtn;

	// Methods
	public void CartProducts_List() {
		for (int i = 1; i <= CartTableRow.size(); i++) {

			for (int j = 1; j <= CartTableCol.size(); j++)

			{
				String str = driver
						.findElement(By.xpath("//table[@id = 'cart_info_table']/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText();
				System.out.print(str + " | ");

			}

			System.out.println();
		}

	}

	public void ClickProcedToCheckout() {
		ProceedToCheckoutBtn.click();
	}

	public void ClickCartMenu() throws InterruptedException {
		Thread.sleep(2000);
		CartMenu.click();
	}

	public void PlaceOrder() {
		System.out.println("Delivery Address is:");
		for (WebElement e1 : Checkout_DeliveryAdd) {
			System.out.println(e1.getText());
		}

		System.out.println("Billing Address is:");

		for (WebElement e2 : Checkout_BillingAdd) {
			System.out.println(e2.getText());
		}

		Checkout_Comment.sendKeys("Test Comment");

		Checkout_PalceOrder.click();
		Payment_CardName.sendKeys("Test Card");
		Payment_CardNumber.sendKeys("12345678");
		Payment_CVC.sendKeys("123");
		Payment_Month.sendKeys("12");
		Payment_Year.sendKeys("2023");
		Payment_PayBtn.click();

	}

	public void RemoveProd_cart() {
		CartTableDeleteBtn.click();
	}

	public void VerifyAddress() {
		System.out.println("Delivery Address is:");
		for (WebElement e1 : Checkout_DeliveryAdd) {
			System.out.println(e1.getText());
		}

		System.out.println("Billing Address is:");

		for (WebElement e2 : Checkout_BillingAdd) {
			System.out.println(e2.getText());
		}
	}

	public void DownloadInvoice_Verify() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Payment_DownloadInvoice);

		js.executeScript("arguments[0].click();", Payment_ContinueBtn);

	}

}
