package com.automation.SeperateUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.automation.base.CustomException;
import com.automation.base.DataStoreRepository;

import applicationActions.TrackingSummaryReportAction;

public class Summarytrackingreportverification extends LoginAsSeperateUser {

	List<String> expected = new ArrayList<String>(Arrays.asList("Add Account", "View All Accounts", "Add User",
			"View All Customer Support Users", "Account Owner Summary Report", "SMS Usage Report",
			"Table Tracker Order Summary", "Add Group", "View All Groups", "Profile", "Sign Out"));

	@Test(priority = 2)
	public void reportTrackingSummary() throws InterruptedException, IOException, CustomException {
		TrackingSummaryReportAction TSR = new TrackingSummaryReportAction();
		TSR.verifyReportTrackingSummaryUI();
		TSR.selectFromDateInCurrentMonth();
	}

	@Test(priority = 3)
	public void ExportVerificationWithExpectedFile() throws InterruptedException, IOException, CustomException {
		TrackingSummaryReportAction TSR = new TrackingSummaryReportAction();
		TSR.verifyexportRecord(DataStoreRepository.getValue("ExpectedTableTrackingSummaryReport"),
				DataStoreRepository.getValue("PathOfDownloadsFolder"));
	}

	@Test(priority = 4)
	public void ReportVerificationWithExpectedFile() throws InterruptedException, IOException, CustomException {
		TrackingSummaryReportAction
				.ReportTTSWebTableVerification(DataStoreRepository.getValue("ExpectedTableTrackingSummaryReport"));
	}

}
