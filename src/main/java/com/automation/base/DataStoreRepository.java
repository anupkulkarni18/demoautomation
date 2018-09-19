package com.automation.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * This class consist of method which are common to all framework
 * 
 * @author bharatp : 14/04/2017
 *
 */
public class DataStoreRepository {
	private String folderName;
	private String fileName;
	// Hashmap : In this will store all keys and values for given properties
	private static Map<String, String> configValues;

	private DataStoreRepository() {

	}

	private static DataStoreRepository repository = new DataStoreRepository();
	public static DataStoreRepository getDataStoreRepositoryInstance() {

		return repository;
	}

	public static String getValue(String key) throws CustomException {
		String value = configValues.get(key);
		if (value == null) {
			throw new CustomException(key + ": Failed Key not found in selected file");
		} else if (value.isEmpty()) {
			throw new CustomException(key + ": Failed Kay does not have any value");
		}
		return value;
	}

	DataStoreRepository(String folderName, String fileName) {
		this.folderName = folderName;
		this.fileName = fileName;
		this.configValues = new HashMap<>();
	}

	public static DataStoreRepository loadRepository(String folderName, String fileName) throws CustomException {
		DataStoreRepository dataStoreRepository = new DataStoreRepository(folderName, fileName);
		Properties properties = dataStoreRepository.loadData(folderName, fileName);
		dataStoreRepository.populateMap(properties);
		return dataStoreRepository;
	}

	final static Logger LOGGER = Logger.getLogger(DataStoreRepository.class.getName());

	/**
	 * This method will load the data from selected property file
	 * 
	 * @param folderName
	 * @param fileName
	 * @return property data
	 * @throws CustomException
	 * @throws FileNotFoundException
	 */
	private Properties loadData(String folderName, String fileName) throws CustomException {
		InputStream resourceStream;
		Properties props = new Properties();
		String resourceName;

		if (null != folderName && folderName.isEmpty()) {
			resourceName = fileName + ".properties";
		} else {
			resourceName = folderName + "/" + fileName + ".properties";
		}
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		resourceStream = loader.getResourceAsStream(resourceName);
		if (resourceStream != null) {
			try {
				props.load(resourceStream);
				LOGGER.info("Property file is loaded successfully: " + resourceName);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					resourceStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			throw new CustomException("Filed file not found: " + resourceName);
		}
		return props;
	}

	/**
	 * This method will store the data in MAP
	 * 
	 * @param folderName
	 * @param fileName
	 * @throws CustomException
	 */
	private void populateMap(Properties data) throws CustomException {
		Set<String> propertyNames = data.stringPropertyNames();
		for (String Property : propertyNames) {
			/* dataStoreInMap.put(Property, data.getProperty(Property)); */
			configValues.put(Property, data.getProperty(Property));
		}
	}

	/*
	 * public IDataStoreInMap CreateDataStoreForFile() throws HandleException{
	 * DataStoreInMap dataStore = new DataStoreInMap(); populateMap(dataStore);
	 * return dataStore;
	 * 
	 * }
	 */
}
