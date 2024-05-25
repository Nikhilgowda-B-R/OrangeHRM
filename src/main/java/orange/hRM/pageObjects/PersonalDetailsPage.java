package orange.hRM.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import orange.hRM.abstractComponents.AbstractComponent;

public class PersonalDetailsPage extends AbstractComponent {

	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstName")
	private WebElement firstNameInput;

	@FindBy(id = "middleName")
	private WebElement middleNameInput;

	@FindBy(id = "lastName")
	private WebElement lastNameInput;

	@FindBy(id = "switch_autoGenerateEmployeeId")
	private WebElement autoGenerateEmpIdToggle;

	@FindBy(id = "otherId")
	private WebElement otherIdInput;

	@FindBy(id = "ssn")
	private WebElement IdNoInput;

	@FindBy(id = "emp_birthday")
	private WebElement empBirtdayInput;

	@FindBy(xpath = "//div[@id='emp_marital_status_inputfileddiv']/div/input")
	private WebElement maritalStatusDropdown;

	@FindBy(xpath = "//div[@id='emp_marital_status_inputfileddiv']//li/span")
	private List<WebElement> maritalStatusOptions;

	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div/input")
	private WebElement genderDropdown;

	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']//li/span")
	private List<WebElement> genderOptions;
	
	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']/div/input")
	private WebElement nationalityDropdown;
	
	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']//li/span")
	private List<WebElement> nationalityOptions;
	
	@FindBy(id = "licenseNo")
	private WebElement driverlicenseNoInput;
	
	@FindBy(id = "emp_dri_lice_exp_date")
	private WebElement driverLicenseExpDateInput;
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButton;

	public String getFirstName() {
		return firstNameInput.getAttribute("value");
	}

	public String getMiddleName() {
		return middleNameInput.getAttribute("value");
	}

	public String getLastName() {
		return lastNameInput.getAttribute("value");
	}

	public boolean checkAutoGenerateEmpIdToggle() {
		return autoGenerateEmpIdToggle.isSelected();
	}

	public void enterOtherId(String otherId) {
		otherIdInput.sendKeys(otherId);
	}

	public void enterIdNo(String idNo) {
		otherIdInput.sendKeys(idNo);
	}

	public void enterEmpBirthday(String empBirthday) {
		empBirtdayInput.sendKeys(empBirthday);

	}

	public void selectMaritalStatus(String maritalStatus){
		maritalStatusDropdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(maritalStatusDropdown, "class", "select-dropdown active"));
		for (WebElement option : maritalStatusOptions) {
			if (option.getText().contains(maritalStatus)) {
				option.click();
				break;
			}
		}

	}

	public void selectGender(String gender){
		genderDropdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(genderDropdown, "class", "select-dropdown active"));
		for (WebElement option : genderOptions) {
			if (option.getText().contains(gender)) {
				option.click();
				break;
			}
		}

	}
	
	public void selectNationality(String nationality) {
		nationalityDropdown.click();
		for (WebElement option : nationalityOptions) {
			if (option.getText().contains(nationality)) {
				option.click();
				break;
			}
		}

	}
	
	public void enterDriverLicenseNo(String driverLicenseNo) {
		driverlicenseNoInput.sendKeys(driverLicenseNo);
	}
	
	public void enterDriverLicenseExpDate(String driverLicenseExpDate) {
		driverLicenseExpDateInput.sendKeys(driverLicenseExpDate);
	}
	
	public void moveToNextPageFromPeronalDetailPage() {
		nextButton.click();
	}
}
