package orange.hRM.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orange.hRM.data.DataReader;
import orange.hRM.testComponents.BaseClass;

public class EmployeeManagement extends BaseClass {

	@Test(dataProvider = "getValidLoginData")
	public void createEmployee(HashMap<String, String> data) {
		employeeManagementPage = loginPage.login(data.get("Name"), data.get("Password"));
		Assert.assertEquals(driver.getTitle(), "Employee Management");
		employeeManagementPage.openEmployeeList();
		employeeManagementPage.addEmployee();
		employeeManagementPage.enterEmployeeName("Nikhil", "gowda", "B R");
		employeeManagementPage.selectLocation("India Office");
		employeeManagementPage.movetoNextPageFromAddEmpoyeePage();
	}

	@DataProvider
	public Object[][] getValidLoginData() throws IOException {
		List<HashMap<String, String>> data = DataReader.getJsonDataToMap("validLoginData.json");
		return DataReader.convertListToObj(data);
	}
}
