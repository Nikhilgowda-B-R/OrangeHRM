package orange.hRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
