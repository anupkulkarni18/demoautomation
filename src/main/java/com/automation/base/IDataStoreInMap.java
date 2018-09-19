package com.automation.base;

public interface IDataStoreInMap {
	
	String getValue(String key) throws CustomException;

	public void put(String key, String value);
}
