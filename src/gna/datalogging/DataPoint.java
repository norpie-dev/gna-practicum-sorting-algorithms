package gna.datalogging;

import java.util.HashMap;

public class DataPoint {

	private HashMap<String, Object> data;

	public DataPoint(HashMap<String, Object> data) {
		this.data = data;
	}
	
	public Object get(String key) {
		return data.get(key);
	}

	public HashMap<String, Object> getData() {
		return data;
	}

}
