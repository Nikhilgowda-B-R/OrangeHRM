package orange.hRM.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public static List<HashMap<String, String>> getJsonDataToMap(String fileName) throws IOException {

		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\orange\\hRM\\data\\" + fileName),
				StandardCharsets.UTF_8);

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

}
