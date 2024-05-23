package orange.hRM.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.hRM.abstractComponents.AbstractComponent;

public class EmployeeManagementPage extends AbstractComponent {

	public WebDriver driver;

	public EmployeeManagementPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Employee List ']")
	private WebElement employeeListMenu;

	@FindBy(xpath = "//a[@id=\"addEmployeeButton\"]/i")
	private WebElement addEmployeeIcon;

	@FindBy(id = "first-name-box")
	private WebElement firstNameBox;

	@FindBy(id = "middle-name-box")
	private WebElement middleNameBox;

	@FindBy(id = "last-name-box")
	private WebElement lastNameBox;

	@FindBy(xpath = "//button[@class = 'btn dropdown-toggle']/div/div/div")
	private WebElement locationDropDown;

	@FindBy(xpath = "//a[@class='dropdown-item']")
	private List<WebElement> locationDropDownOptions;
	
	@FindBy(id = "modal-save-button")
	private WebElement addEmpNextBtn;

	public void openEmployeeList() {
		employeeListMenu.click();
	}

	public void addEmployee() {
		addEmployeeIcon.click();
	}

	public void enterEmployeeName(String first, String middle, String last) {
		if (first != null)
			firstNameBox.sendKeys(first);
		if (middle != null)
			middleNameBox.sendKeys(middle);
		if (last != null)
			lastNameBox.sendKeys(last);
	}

	public void selectLocation(String location) {
		locationDropDown.click();
		for (WebElement option : locationDropDownOptions) {
			if (location.contains(option.getText())) {
				option.click();
				break;
			}
		}
	}
	
	public void movetoNextPageFromAddEmpoyeePage() {
		addEmpNextBtn.click();
	}

}
