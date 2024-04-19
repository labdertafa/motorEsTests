package com.laboratorio.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJsonHelper {
	private static final Logger logger = LogHelper.getLogger(ReadJsonHelper.class);
	
	private JSONObject jsonObject;
	
	public ReadJsonHelper(String filename) {
		try {
			this.jsonObject = (JSONObject)readJson(filename);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Impossible de récupérer la définition de la page: " + filename);
			this.jsonObject = null;
		}
	}

	private Object readJson(String filename) throws Exception {
		FileReader reader = null;

		try {
			reader = new FileReader(filename);
			JSONParser jsonParser = new JSONParser();
			return jsonParser.parse(reader);
		} catch (FileNotFoundException | NullPointerException e) {
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
	
	public JSONObject getEntity(String element) {
		return (JSONObject)jsonObject.get(element);
	}
}