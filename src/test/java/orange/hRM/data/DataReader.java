package orange.hRM.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public static List<HashMap<String, String>> getJsonDataToMap(String fileName) throws IOException {

		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\orange\\hRM\\data\\" + fileName),
				"UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public static Object[][] convertListToObj(List<HashMap<String, String>> data) {
		Object[][] obj = new Object[data.size()][];

		for (int i = 0; i < obj.length; i++) {
			obj[i] = new Object[1];
			obj[i][0] = data.get(i);
		}

		return obj;

	}

	public static Object[][] convertNestedListToObj(List<HashMap<String, HashMap<String, String>>> data) {
		Object[][] obj = new Object[data.size()][];

		for (int i = 0; i < obj.length; i++) {
			HashMap<String, HashMap<String, String>> outerMap = data.get(i);
			int innerSize = outerMap.size();
			Object[] innerArray = new Object[innerSize];
			int j = 0;

			for (String key : outerMap.keySet()) {
				HashMap<String, String> innerMap = outerMap.get(key);
				innerArray[j++] = innerMap;
				obj[i] = innerArray;
			}

		}

		return obj;

	}

	public static List<HashMap<String, HashMap<String, String>>> getNestedJsonDataToMap(String fileName)
			throws IOException {

		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\orange\\hRM\\data\\" + fileName),
				"UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, HashMap<String, String>>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, HashMap<String, String>>>>() {
				});
		return data;
	}

}
