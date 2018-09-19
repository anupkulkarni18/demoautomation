package applicationActions;

import selenium.LocatorType;

import com.application.constants.LocationConstants;
import com.pageObjects.LocationPage;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

public class LocationActions {

	public void addLocation(String locationName, String custId, String address,
			String phoneNumber) {
		LocationPage lp = new LocationPage();
		lp.addLocationText.click();
		SeleniumCommon.waitForSeconds(10);
		// lp.locationName.clearText();
		lp.locationName.setText(locationName);
		// lp.custId.clearText();
		lp.custId.setText(custId);
		lp.address.clearText();
		lp.address.setText(address);
		lp.phoneNo.clearText();
		lp.phoneNo.setText(phoneNumber);
		lp.saveButton.click();

		TestngVerifications.assertBoolean(SeleniumCommon
				.getElementInstance()
				.getDynamicXPath(LocatorType.XPATH,
						lp.location1 + locationName + lp.location2)
				.isDisplayed());

	}

	public void verifyViewAllLocations(String locationName) {
		LocationPage lp = new LocationPage();
		lp.locations.click();
		lp.viewAllLocations.click();
		SeleniumCommon.waitForSeconds(10);
		lp.searchLocations.setText(locationName);
		lp.searchLocationsIcon.click();
	}

	public void addLocation(String locationName, String address,
			String phoneNumber) {
		LocationPage locationPage = new LocationPage();
		locationPage.locationsTab.click();
		locationPage.addLocationSubMenu.click();
		SeleniumCommon.waitForSeconds(10);
		locationPage.locationName.setText(locationName);
		SeleniumCommon.waitForSeconds(10);
		locationPage.address.setText(address);
		SeleniumCommon.waitForSeconds(10);
		locationPage.phoneNo.setText(phoneNumber);
	}

	public void verifyLocationCancellation(String locationName) {
		LocationPage locationPage = new LocationPage();
		locationPage.cancelButton.click();
		SeleniumCommon.waitForSeconds(10);
		locationPage.locations.click();
		locationPage.viewAllLocations.click();
		SeleniumCommon.waitForSeconds(10);
		locationPage.searchLocations.setText(locationName);
		locationPage.searchLocationsIcon.click();
		TestngVerifications.assertExpectedEqualsActualString(
				"No Locations found", locationPage.noLocationText.getText());

	}

	public void addNotesAndVerify() {
		LocationPage lp = new LocationPage();
		lp.notesTab.click();
		SeleniumCommon.waitForSeconds(5);
		lp.appleId.clearText();
		lp.appleId.setText(LocationConstants.appleID);

		lp.appleIdPassword.clearText();
		lp.appleIdPassword.setText(LocationConstants.appleIDpasssword);

		lp.pin.clearText();
		lp.pin.setText(LocationConstants.pin);

		lp.wifiPassword.clearText();
		lp.wifiPassword.setText(LocationConstants.wifiPassword);

		lp.warrantyExpirationDate.clearText();
		lp.warrantyExpirationDate.setText(LocationConstants.warrentyExpiery);

		lp.notes.clearText();
		lp.notes.setText(LocationConstants.notes);

		lp.noteSaveButton.click();

	}

	public void uploadLayout() {

		LocationPage lp = new LocationPage();
		lp.layoutTab.click();
		SeleniumCommon.waitForSeconds(5);
	}

}
