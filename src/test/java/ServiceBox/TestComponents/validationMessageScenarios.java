package ServiceBox.TestComponents;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import ServiceBOX.pageobjectmodel.homepage;
import ServiceBOX.pageobjectmodel.loginPageSample;

public class validationMessageScenarios extends BaseTest {

	@Test(groups = {"VINValidation"},retryAnalyzer=retryListeners.class)
	public void lisencePlateMessageValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		loginPageSample loginPageSample = launchingApplication();

		loginPageSample.loginDetails("DB87046", "XTTIAM1", "010072Y");
		loginPageSample.selectLanguage("EN");
		loginPageSample.selectCountry("FR");
		homepage homePage = loginPageSample.submit();
		homePage.lisencePlateNumberField("DR8879Y");
		Assert.assertEquals("We were unable to identify your vehicle", homePage.lpnValidationMessage());

	}
	
	@Test(groups = {"VINValidation"})
	public void vehicleIdentificationNumberValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		loginPageSample loginPageSample = launchingApplication();

		loginPageSample.loginDetails("DB87047", "XTTIAM7", "010072Y");
		loginPageSample.selectLanguage("EN");
		loginPageSample.selectCountry("FR");
		homepage homePage = loginPageSample.submit();
		homePage.vehicleIdentificationNumberField("SiRUU761");
		Assert.assertEquals("We were unable to identify your vehicle", homePage.vinValidationMessage());

	}

}
