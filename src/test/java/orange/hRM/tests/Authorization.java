package orange.hRM.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import orange.hRM.data.DataReader;
import orange.hRM.testComponents.BaseClass;

public class Authorization extends BaseClass {

	@Test(dataProvider = "getValidLoginData")
	public void validLogin(HashMap<String, String> data) {
		loginPage.login(data.get("Name"), data.get("Password"));
		Assert.assertEquals(driver.getTitle(), "Employee Management");
	}

	@Test(dependsOnMethods = "validLogin",dataProvider = "getInValidLoginData")
	public void invalidUsername(HashMap<String, String> data) {
		loginPage.login(data.get("Name"), data.get("Password"));
		SoftAssert as = new SoftAssert();
		as.assertEquals(driver.getCurrentUrl(),
				"https://nikhilgowda-trials712.orangehrmlive.com/securityAuthentication/retryLogin");
		String expectedMessage = "Invalid Credentials";
		String actualMessage = loginPage.getErrorMessage();
		as.assertTrue(actualMessage.contains(expectedMessage));
		as.assertAll();
	}

	@DataProvider
	public Object[][] getValidLoginData() throws IOException {
		List<HashMap<String, String>> data = DataReader.getJsonDataToMap("validLoginData.json");
		return DataReader.convertListToObj(data);
	}
	
	@DataProvider
	public Object[][] getInValidLoginData() throws IOException {
		List<HashMap<String, String>> data = DataReader.getJsonDataToMap("invalidLoginData.json");
		return DataReader.convertListToObj(data);
	}
	
	
}
