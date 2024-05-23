package orange.hRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.hRM.abstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	private WebElement userNameInput;

	@FindBy(id = "txtPassword")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='toast toast-error']")
	private WebElement toastErrorMessage;
	

	public void goTo() {
		driver.get("https://nikhilgowda-trials712.orangehrmlive.com/");

	}

	public EmployeeManagementPage login(String userName, String password) {
		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		loginBtn.click();
		return new EmployeeManagementPage(driver);
	}

	public String getErrorMessage() {
		return toastErrorMessage.getText();
	}
}
