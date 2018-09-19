package com.automation.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bharatp
 *
 */

public class DataStoreInMap implements IDataStoreInMap {
	Map<String, String> dataFromFiles;

	public DataStoreInMap() {
		dataFromFiles = new HashMap<String, String>();
	}

	public String getValue(String key) throws CustomException {
		String temp = dataFromFiles.get(key);
		if (temp == null) {
			throw new CustomException(key + ": Failed Key not found in selected file");
		} else if (dataFromFiles.get(key).isEmpty()) {
			throw new CustomException(key + ": Failed Kay does not have any value");
		}
		return temp;
	}

	public void put(String key, String value) {
		dataFromFiles.put(key, value);
	}

}
