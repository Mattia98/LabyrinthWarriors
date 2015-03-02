package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.*;

public class MapLoader {
	String mapPath = "map.json";
	String mapRaw;
	public static List<Wall> walls;
	
	public MapLoader() {
		walls = new ArrayList<Wall>();
		loadMap();
		convertJson();
	}
	
	protected Boolean loadMap() {
		try {
			mapRaw = new String(Files.readAllBytes(Paths.get(mapPath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	protected Boolean convertJson() {
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(mapRaw);
			JSONArray jsonWalls = (JSONArray) jsonObject.get("walls");
			Iterator i = jsonWalls.iterator();
			
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();
				walls.add(new Wall((int)(long)innerObj.get("height"), (int)(long)innerObj.get("width"), (int)(long)innerObj.get("x"), (int)(long)innerObj.get("y")));
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
