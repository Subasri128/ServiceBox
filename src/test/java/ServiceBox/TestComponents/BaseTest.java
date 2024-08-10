package ServiceBox.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ServiceBOX.pageobjectmodel.loginPageSample;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	// Declare webdriver globally
	public static WebDriver driver;

	public static WebDriver initializeDriver() throws IOException {

		// read property file
		Properties properties = new Properties();
		FileInputStream fileinputstream = new FileInputStream("C:\\Users\\a819538\\eclipse-workspace\\Servicebox\\src\\main\\java\\ServiceBOX\\Resources\\GlobalDataSBMB.properties");
		properties.load(fileinputstream);
		
		String systemBrowser = System.getProperty("browser");
		String browserName=systemBrowser!=null?systemBrowser:properties.getProperty("browser");
		
		//String browserName=	System.getProperty("browser")!= null ? System.getProperty("browser"):properties.getProperty("browser");
	//	String browserName = properties.getProperty("browser");

		if (browserName.contains("chrome")) {
			//Headless : means browser invocation will not be visible to user , it runs internally.
			ChromeOptions options= new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			//Full screen dimension : 1440,900
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1440,900));
			
			

		} else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();

		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJSONDataToHashMap(String filePath) throws IOException {
		//read json to String
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		//String to HashMap - By using Jackson Databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
		return data;
	
	}

	// Launching an application in specific env
	
	@BeforeMethod(alwaysRun=true)
	public static loginPageSample launchingApplication() throws IOException {
		// take above methodName for initializing
		driver = initializeDriver();
		loginPageSample loginpagesample = new loginPageSample(driver);

		loginpagesample.integration();
		return loginpagesample;

	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png" ;
	}
	
	
}