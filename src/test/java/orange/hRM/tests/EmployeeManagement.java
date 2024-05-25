package orange.hRM.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import orange.hRM.data.DataReader;
import orange.hRM.pageObjects.PersonalDetailsPage;
import orange.hRM.testComponents.BaseClass;

public class EmployeeManagement extends BaseClass {

	@Test(dataProvider = "getEmployeeDetails")
	public void createEmployee(HashMap<String, String> loginCred, HashMap<String, String> empDetails,
			HashMap<String, String> personalDetails) {
		employeeManagementPage = loginPage.login(loginCred.get("Name"), loginCred.get("Password"));
		Assert.assertEquals(driver.getTitle(), "Employee Management");
		employeeManagementPage.openEmployeeList();
		employeeManagementPage.addEmployee();
		SoftAssert as = new SoftAssert();
		as.assertTrue(employeeManagementPage.checkAutoGenerateEmpIdToggle(),
				" autogenerate toogle validation in Employee create page Failed");
		employeeManagementPage.enterEmployeeName(empDetails.get("firstName"), empDetails.get("middleName"),
				empDetails.get("lastName"));
		employeeManagementPage.selectLocation(empDetails.get("location"));
		personalDetailPage = employeeManagementPage.movetoNextPageFromAddEmpoyeePage();
		as.assertEquals(personalDetailPage.getFirstName(), empDetails.get("firstName"));
		as.assertEquals(personalDetailPage.getMiddleName(), empDetails.get("middleName"));
		as.assertEquals(personalDetailPage.getLastName(), empDetails.get("lastName"));
		as.assertTrue(personalDetailPage.checkAutoGenerateEmpIdToggle(),
				"autogenerate toogle validation in Personal details page Failed");
		personalDetailPage.enterOtherId(personalDetails.get("otherId"));
		personalDetailPage.enterIdNo(personalDetails.get("idNo"));
		personalDetailPage.enterEmpBirthday(personalDetails.get("empBirthday"));
		personalDetailPage.selectMaritalStatus(personalDetails.get("maritalStatus"));
		personalDetailPage.selectGender(personalDetails.get("gender"));
		personalDetailPage.selectNationality(personalDetails.get("nationality"));
		personalDetailPage.enterDriverLicenseNo(personalDetails.get("drivingLicenseNo"));
		personalDetailPage.enterDriverLicenseExpDate(personalDetails.get("drivingLicenseExpiryDate"));
		personalDetailPage.moveToNextPageFromPeronalDetailPage();
		as.assertAll();

	}

	@DataProvider
	public Object[][] getEmployeeDetails() throws IOException {
		List<HashMap<String, HashMap<String, String>>> data = DataReader.getNestedJsonDataToMap("EmployeeData.json");
		return DataReader.convertNestedListToObj(data);
	}
}
