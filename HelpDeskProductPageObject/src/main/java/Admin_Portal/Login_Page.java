package Admin_Portal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import webdriverbase.AppPage;

//class BasePage {
//	protected WebDriver driver;
//	
//
//	public BasePage(WebDriver driver) {
//		this.driver = driver;
//	}
//}

public class Login_Page extends AppPage {
	
	public Login_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "id_username")
	private WebElement userName;

	public void login(String username, String password) {

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
	}

	public void forgotPassword() {
		driver.findElement(By.linkText("Forgot password?")).click();
	}
	
	public void navigateToHappyFoxHomePageURL(String url) {
		super.get(url);
	}
	
	public void enterUsername(String username) {

		userName.sendKeys(username);

	}
	
	@FindBy(id = "id_password")
	private WebElement passWord;
	
	public void enterPassword(String password) {

		passWord.sendKeys(password);
	}
	
	@FindBy(id = "btn-submit")
	private WebElement loginButton;
	
	public void clickLoginbutton() {
		loginButton.click();
	}
	
	public AdminPortalTest1stPage validatePendingTicketsTitle(String expectedTitle) {
		String pendingTicketsTitle = driver.getTitle();
		Assert.assertEquals(pendingTicketsTitle, expectedTitle);
		return new AdminPortalTest1stPage(driver);
	}
	
	public void validatePendingTicketsTitle1(String expectedTitle) {
		String pendingTicketsTitle = driver.getTitle();
		Assert.assertEquals(pendingTicketsTitle, expectedTitle);
	}
}

class HomePage extends AppPage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void verifyHomePage() {
		if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
			throw new IllegalStateException("Not on the home page");
		}
	}
	
	@FindBy(id = "profileLink")
	private WebElement profileClick;

	public void navigateToProfile() {
		profileClick.click();
	}

	class TablePage extends AppPage {
		
		@FindBy(xpath = "//table[@id='dataTable']/tbody/tr")

		private List<WebElement> rowLocator;

		public TablePage(WebDriver driver) {
			super(driver);
		}

		public void retrieveRowTexts() {
			List<WebElement> rows = rowLocator;

			for (int i = 0; i < rows.size(); i++) {
				WebElement row = rows.get(i);
				String rowText = row.getText();
				System.out.println("Row " + i + " Text: " + rowText);
			}
		}

	}

}
