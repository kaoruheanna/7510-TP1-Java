package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.HashMap;

public class ArgumentsMap {
	
	private HashMap<String, String> hmap = new HashMap<String, String>();
	
	public ArgumentsMap(ArrayList<String> keys, ArrayList<String> values) {
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = values.get(i);
			this.hmap.put(key, value);
		}
	}

	public String getForKey(String key) {
		return this.hmap.get(key);
	}
}
