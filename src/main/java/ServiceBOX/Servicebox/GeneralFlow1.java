package ServiceBOX.Servicebox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GeneralFlow1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				// Initializing web driver
				WebDriver driver = new ChromeDriver();

				// URL
				driver.get("https://integration.multibrand.servicebox-parts.com//login/");

				// Login
				driver.manage().window().maximize();
				driver.findElement(By.id("userid")).clear();
				driver.findElement(By.id("userid")).sendKeys("DB87046");
				driver.findElement(By.id("storecode")).clear();
				driver.findElement(By.name("storecode")).sendKeys("XTTIAM7");
				WebElement testDropDown = driver.findElement(By.id("language"));
				Select dropdown = new Select(testDropDown);
				dropdown.selectByVisibleText("EN");
				driver.findElement(By.className("btn-primary")).click();

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				// Home Page

				WebElement lpn = driver.findElement(By.xpath("//*[@id=\'RFsearchVehicle-selectImmatInput\']"
						+ "/div/div[1]"));

				lpn.click();
				// Send keys after click the box
				WebElement lpninsert = driver
						.findElement(By.xpath("//*[@id=\'RFsearchVehicle-selectImmatInput\']/div/div[2]/input"));
				// Vehicle Search
				lpninsert.sendKeys("dt285ry");
				
				System.out.println(lpninsert.getRect().getHeight());
				System.out.println(lpninsert.getRect().getWidth());
				System.out.println(lpninsert.getLocation());
				lpninsert.getLocation();
				
			String	familyName="Filtration";
			String	subFamilyName="Filter, cabin air";	

				driver.findElement(By.xpath("//*[@id=\"RFsearchVehicle-selectImmatBtn\"]")).click();
				// Family page
				driver.findElement(By.xpath("//div[@class='container-card ng-star-inserted']"
						+ "//h4[normalize-space()='Filtration']")).click();
				
			
				// Subfamily
				driver.findElement(By.xpath(" //p[@class='pointer badge-p ng-star-inserted']"
						+ "[contains(text(),'Filter, cabin air')]")).click();
				
				
				
				//driver.findElement(By.xpath("//a[normalize-space()='Wiper Blade']")).click();
				// Genart page
				List<WebElement> articles = driver.findElements(By.cssSelector(".piece-card-box"));

				WebElement partReference = articles.stream()
						.filter(article -> article.findElement(By.cssSelector("span"))
								.getText().equals("CU 3448")).findFirst()
						.orElse(null);

				partReference.findElement(By.cssSelector(".inputsize")).clear();
				partReference.findElement(By.cssSelector(".inputsize")).sendKeys("28");
				Thread.sleep(2000);
				// Add to cart
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(
						By.cssSelector(".icon-caddie"))).click();
				

				// caddy Page
				

				wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//nav[@id='RFmainHeader']"
								+ "//div[@id='navbarSupportedContent']"
								+ "//li[@id='RFmainHeader-caddy']")))
				.click();
						
				System.out.println("Article added to cart");

				// Service box
				driver.findElement(By.xpath("//nav[@id='RFmainHeader']"
						+ "//a[@id='RFmainHeader-logo']")).click();

				// Language change

				//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//nav[@id='RFmainHeader']//div[@id='navbarSupportedContent']"
						+ "//button[@class='element-header d-flex align-items-center']"))).click();
						

				driver.findElement(By.cssSelector(".btn.btn-link")).click();
				// change language
				driver.findElement(By.xpath(
						"//div[@id='panel1']//ul[@class='list-country ng-star-inserted']"
						+ "//li[normalize-space()='Français']")).click();
				
				Thread.sleep(5000);
						
				//Logout
				driver.findElement(By.xpath("//li[@class='nav-item nav-item-caddy no-border']"
						+ "//button[@type='button']")).click();
				driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
				driver.close();
				
	}

}
