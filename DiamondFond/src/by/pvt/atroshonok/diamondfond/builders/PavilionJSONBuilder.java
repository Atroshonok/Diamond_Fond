package by.pvt.atroshonok.diamondfond.builders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import by.pvt.atroshonok.diamondfond.beans.Gem;
import by.pvt.atroshonok.diamondfond.beans.Pavilion;
import by.pvt.atroshonok.diamondfond.beans.VisualParametersList;
import by.pvt.atroshonok.diamondfond.enums.GemColor;
import by.pvt.atroshonok.diamondfond.enums.GemPreciousness;

public class PavilionJSONBuilder extends AbstractPavilionBuilder {
	private JSONParser jsonParser;
	private Gem currentGem;

	public PavilionJSONBuilder() {
		jsonParser = new JSONParser();

	}

	public void buildPavilion(String jsonFileName) {
		FileReader reader = null;
		try {
			reader = new FileReader(jsonFileName);
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray ZSONpavilion = (JSONArray) jsonObject.get("pavilion");
			Iterator<?> iter = ZSONpavilion.iterator();
			while (iter.hasNext()) {
				setGemFieldsFromJSONFile(iter);
				pavilion.getGemList().add(currentGem);
			}
		} catch (FileNotFoundException e) {
			System.err.println("JSONFile " + jsonFileName + " is not found! " + e);
		} catch (IOException e) {
			System.err.println("Error of I/O Stream: " + e);
		} catch (ParseException e) {
			System.err.println("Error of JSONParser: " + e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @return the pavilion
	 */
	public Pavilion getPavilion() {
		return pavilion;
	}

	private void setGemFieldsFromJSONFile(Iterator<?> iter) {
		JSONObject innerJSONObject = (JSONObject) iter.next();
		currentGem = new Gem();
		currentGem.setId((String) innerJSONObject.get("id"));
		currentGem.setName((String) innerJSONObject.get("name"));
		currentGem
				.setPreciousness(GemPreciousness.valueOf(((String) innerJSONObject.get("preciousness")).toUpperCase()));
		currentGem.setOrigin((String) innerJSONObject.get("origin"));
		currentGem.setValue((double) innerJSONObject.get("value"));

		VisualParametersList list = currentGem.getVisualParamList();
		JSONObject JSONVisualParam = (JSONObject) innerJSONObject.get("visual-parameters-list");
		list.setGemColor(GemColor.valueOf(((String) JSONVisualParam.get("color")).toUpperCase()));
		list.setTransparency(((Number) JSONVisualParam.get("transparency")).intValue());
		list.setFacesCount(((Number) JSONVisualParam.get("facescount")).intValue());
	}

}
