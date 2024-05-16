package orange.hRM.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import orange.hRM.testComponents.BaseClass;

public class Authorization extends BaseClass {

	@Test
	public void validLogin() {
		landingPage.login("Admin", "Fz@zNGVj51");
		Assert.assertEquals(driver.getTitle(), "Employee Management");
	}

	@Test(priority = 1)
	public void invalidUsername() {
		landingPage.login("Admi", "Fz@zNGVj51");
		SoftAssert as = new SoftAssert();
		as.assertEquals(driver.getCurrentUrl(),
				"https://nikhilgowda-trials712.orangehrmlive.com/securityAuthentication/retryLogin");
		String expectedMessage = "Invalid Credentials";
		String actualMessage =landingPage.getErrorMessage();
		as.assertTrue(actualMessage.contains(expectedMessage));
		as.assertAll();
	}
}
