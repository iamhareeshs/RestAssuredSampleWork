package apitest.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Util {
	/**
	 * Method Name: fetchDataFromJson    Method Description: Used to fetch data from json file.
	 * @param <T>
	 * @param jsonFile
	 * @param clazz
	 * @return
	 */
	public static <T> Object[][] fetchDataFromJson(File jsonFile, Class<T> clazz) {
		List<T> dataObjects = getTestData(jsonFile, clazz);
		Object[][] response = new Object[dataObjects.size()][1];
		populateTestData(response, dataObjects);
		return response;
	}

	/**
	 * Method Name: fetchDataFromJson    Method Description: Used to fetch data from json file.
	 * @param <T>
	 * @param jsonFile
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> getTestData(File jsonFile, Class<T> clazz) {
		JsonParser parser = new JsonParser();
		JsonArray array = null;
		try {
			array = (JsonArray) parser.parse(new FileReader(jsonFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<T> result = new ArrayList<>();
		T javaObject;
		assert array != null : "Couldn't fetch data from the json file, please check";
		Gson gson = new Gson();
		for (Object object : array) {
			JsonObject ob = (JsonObject) object;
			javaObject = gson.fromJson(ob, clazz);
			result.add(javaObject);
		}
		return result;
	}

	/**
	 * Method Name: fetchDataFromJson    Method Description: Used to fetch data from json file.
	 * @param <T>
	 * @param response
	 * @param dataObject
	 */
	private static <T> void populateTestData(Object[][] response, List<T> dataObject) {
		int counter = 0;
		for (T data : dataObject) {
			response[counter++] = new Object[] { data };
		}
	}
}
