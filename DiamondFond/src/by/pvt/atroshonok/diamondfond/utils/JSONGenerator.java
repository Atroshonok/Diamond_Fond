/**
 * 
 */
package by.pvt.atroshonok.diamondfond.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import by.pvt.atroshonok.diamondfond.beans.Gem;
import by.pvt.atroshonok.diamondfond.beans.Pavilion;
import by.pvt.atroshonok.diamondfond.beans.VisualParametersList;

/**
 * @author Atroshonok Ivan
 *
 */
public class JSONGenerator {

	public JSONGenerator() {
	}

	public static void createPavilionJSONFile(Pavilion pavilion, String outputfileName) {

		JSONObject jsonPavilion = createPavilionJSONObject(pavilion);
		writeJSONObjectToFile(jsonPavilion, outputfileName);
	}

	@SuppressWarnings("unchecked")
	private static JSONObject createPavilionJSONObject(Pavilion pavilion) {
		JSONObject jsonPavilion = new JSONObject();
		JSONArray jsonGemList = new JSONArray();

		for (Gem currentGem : pavilion.getGemList()) {
			JSONObject jsonGem = createGemJSONObject(currentGem);
			JSONObject jsonVisualParamList = createVisualParamListJSONObject(currentGem);
			jsonGem.put("visual-parameters-list", jsonVisualParamList);
			jsonGemList.add(jsonGem);
		}
		jsonPavilion.put("pavilion", jsonGemList);
		return jsonPavilion;
	}

	@SuppressWarnings("unchecked")
	private static JSONObject createGemJSONObject(Gem currentGem) {
		JSONObject jsonGem = new JSONObject();
		jsonGem.put("id", currentGem.getId());
		jsonGem.put("name", currentGem.getName());
		jsonGem.put("preciousness", currentGem.getPreciousness().toString());
		jsonGem.put("origin", currentGem.getOrigin());
		jsonGem.put("value", currentGem.getValue());
		return jsonGem;
	}

	@SuppressWarnings("unchecked")
	private static JSONObject createVisualParamListJSONObject(Gem currentGem) {
		VisualParametersList vpList = currentGem.getVisualParamList();
		JSONObject jsonVisualParamList = new JSONObject();
		jsonVisualParamList.put("color", vpList.getGemColor().toString());
		jsonVisualParamList.put("transparency", vpList.getTransparency());
		jsonVisualParamList.put("facescount", vpList.getFacesCount());
		return jsonVisualParamList;
	}

	private static void writeJSONObjectToFile(JSONObject jsonObject, String outputfileName) {
		File jsonFile = new File(outputfileName);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(jsonFile);
			writer.write(jsonObject.toJSONString());
			System.out.println("Created JSON File: " + jsonFile.getAbsolutePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}

}
