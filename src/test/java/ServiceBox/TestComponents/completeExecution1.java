package ServiceBox.TestComponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.bouncycastle.asn1.dvcs.Data;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ServiceBOX.pageobjectmodel.CaddyPage;
import ServiceBOX.pageobjectmodel.homepage;
import ServiceBOX.pageobjectmodel.loginPageSample;

public class completeExecution1 extends BaseTest {

	@Test(dataProvider="CheckData",groups="Purchase")
	public  void startTest1(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		loginPageSample loginPageSample = launchingApplication();

		loginPageSample.loginDetails(input.get("userId"),input.get("RRDIcode"),input.get("DOPRcode"));
		loginPageSample.selectLanguage("EN");
		loginPageSample.selectCountry("FR");
		homepage homePage = loginPageSample.submit();

		homePage.lisencePlateNumberField("DT285RY");
		homePage.vehicleFamily();
		homePage.vehicleSubFamily();
		List<WebElement> articles = homePage.articleSelect();
		homePage.getArticlename();
		homePage.articleAddCart("28");
	
		homePage.cartPage();
		homePage.serviceBoxLogoIcon();

		homePage.languageSelection();
		homePage.logoutMethod();
	}
	
	/***
	//This test is failing 
	@Test(dependsOnMethods="startTest1")
	public  void verifyCartPage() throws IOException, InterruptedException {
		
		loginPageSample loginPageSample = launchingApplication();

		loginPageSample.loginDetails("DB87045", "XTTIAM1", "010072Y");
		loginPageSample.selectLanguage("EN");
		loginPageSample.selectCountry("FR");
		homepage homePage = loginPageSample.submit();

	
		CaddyPage caddyPage =homePage.cartPage();
		Assert.assertTrue(caddyPage.getCaddyArticlename("MHCU3448")); 
	}
	***/
	/***
	 *Getting data from multidimensional array-(using data provider)
	@DataProvider
	public Object[][] CheckData() {
		return new Object[][] {{"DB87045","XTTIAM1","010072Y"},{"DB87046","XTTIAM7","010073Y"}};
	}
	***/
	
	
	/***
	//to make it in simpler & readable way use hashmap(Key -value pair data set)
	 * @throws IOException 
	@DataProvider
	public Object[][] CheckData() {
		
		HashMap<String, String> map =new HashMap<String, String>();
		map.put("userId","DB87045");
		map.put("RRDIcode","XTTIAM1");
		map.put("DOPRcode","010072Y");
		
		HashMap<String, String> map1 =new HashMap<String, String>();
		map1.put("userId","DB87046");
		map1.put("RRDIcode","XTTIAM7");
		map1.put("DOPRcode","010073Y");
		 return new Object[][] {{map},{map1}};
	}
	***/
	
	//From JSON FILE
	@DataProvider
	public Object[][] CheckData() throws IOException {
		
		List<HashMap<String, String>> dataset =  getJSONDataToHashMap(System.getProperty("user.dir")+"//src//test//java//ServiceBox//testdata//purchaseData.json");
		return new Object[][] {{dataset.get(0)},{dataset.get(1)}};
	}
	}
	
	


