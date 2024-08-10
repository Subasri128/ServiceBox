package ServiceBox.StepDefinition;

import java.io.IOException;

import ServiceBOX.pageobjectmodel.homepage;
import ServiceBOX.pageobjectmodel.loginPageSample;
import ServiceBox.TestComponents.BaseTest;
import io.cucumber.java.en.Given;

public class StepDefinitionImplementation extends BaseTest {
	 
	public loginPageSample loginpagesample;
	public homepage homePage;
	
	@Given("I navigated to ecommerce website")
	public void I_navigated_to_ecommerce_website() throws IOException {
		loginpagesample=launchingApplication();
		}
	//Use regular expression as the input is given from feature file
	
	@Given("^Logged in userId(.+), RRDIcode(.+) and DOPRcode(.+)$")
	 public void Logged_in_userId_RRDIcode_DOPRcode(String userId, String RRDIcode, String DOPRcode){
		
		loginDetails(userId, RRDIcode, DOPRcode);
		selectLanguage("EN");
	selectCountry("FR");
		homePage = loginPageSample.submit(); 
	 }

}
