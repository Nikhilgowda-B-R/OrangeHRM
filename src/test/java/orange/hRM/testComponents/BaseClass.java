package orange.hRM.testComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import orange.hRM.pageObjects.EmployeeManagementPage;
import orange.hRM.pageObjects.LoginPage;
import orange.hRM.pageObjects.PersonalDetailsPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage loginPage;
	public EmployeeManagementPage employeeManagementPage;
	public PersonalDetailsPage personalDetailPage;


	public void initializerDriver() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}
	
	public String getSreenShot(String testCaseName, WebDriver driver) throws IOException {
		
		String filePath = System.getProperty("user.dir")+"//reports//"+testCaseName+System.currentTimeMillis()+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath);
		FileUtils.copyFile(src, dest);
		return filePath;
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() {
		initializerDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
		return loginPage;
	}

//	@AfterMethod(alwaysRun = true)
//	public void tearDown() {
//		driver.close();
//	}
}
