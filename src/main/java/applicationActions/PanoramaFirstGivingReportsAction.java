package applicationActions;

import com.pageObjects.PanoramaFirstGivingReportsPage;

public class PanoramaFirstGivingReportsAction {

	public void clickOnFirstGivingPaymentReports() {
		PanoramaFirstGivingReportsPage pgp = new PanoramaFirstGivingReportsPage();
		pgp.paymentReports.click();
	}
	
	public void clickOnFirstGivingDonationReports() {
		PanoramaFirstGivingReportsPage pgp = new PanoramaFirstGivingReportsPage();
		pgp.DonationReports.click();
	}
	
	public void clickOnFirstGivingCardonfileSummary() {
		PanoramaFirstGivingReportsPage pgp = new PanoramaFirstGivingReportsPage();
		pgp.CardonfileSummary.click();
	}

public void clickOnFirstGivingFundraisingReports() {
	PanoramaFirstGivingReportsPage pgp = new PanoramaFirstGivingReportsPage();
	pgp.FundraisingReports.click();
}
}
