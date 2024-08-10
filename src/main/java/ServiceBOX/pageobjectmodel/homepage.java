package ServiceBOX.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ServiceBOX.AbstractComponent.abstractComponent;

public class homepage extends abstractComponent {
	WebDriver driver;

	public homepage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//LPN DETAILS
	@FindBy(xpath = "//*[@id='RFsearchVehicle-selectImmatInput']/div/div[1]")
	WebElement lpnSelectBox;
	By lpnbox = By.xpath("//*[@id='RFsearchVehicle-selectImmatInput']/div/div[1]");

	@FindBy(xpath = "//*[@id='RFsearchVehicle-selectImmatInput']/div/div[2]/input")
	WebElement lpninsert;

	@FindBy(xpath = "//*[@id='RFsearchVehicle-selectImmatBtn']")
	WebElement lpnSearch;
	
	//VIN DETAILS
	
	@FindBy(xpath = "//*[@id='RFsearchVehicle-mine-placeholder']/div/div[1]")
	WebElement vinSelectBox;
	By vinbox = By.xpath("//*[@id='RFsearchVehicle-mine-placeholder']/div/div[1]");

	@FindBy(xpath = "//*[@id='RFsearchVehicle-mine-placeholder']/div/div[2]/input")
	WebElement vininsert;

	@FindBy(xpath = "//button[@id='RFsearchVehicle-searchMineBtn']")
	WebElement vinSearch;
	
	//vin error message
	@FindBy(css = ".error-msg.small.mb-0.ng-star-inserted")
	WebElement vinErrorMessage;
	
	
	
	//Family
	@FindBy(xpath = "//div[@class='container-card ng-star-inserted']//h4[normalize-space()='Filtration']")
	WebElement Family;

	By familySelect = By.xpath("//div[@class='container-card ng-star-inserted']//h4[normalize-space()='Filtration']");

	@FindBy(xpath = "//p[@class='pointer badge-p ng-star-inserted'][contains(text(),' Filter, cabin air ')]")
	WebElement SubFamily;
	
	@FindBy(css = ".error-msg.small.ng-star-inserted")
	WebElement lpnErrorMessage;

	@FindBy(css = ".piece-card-box")
	List<WebElement> articles;

	By articleCount = By.cssSelector(".inputsize");
	By articleAddToCart = By.cssSelector(".icon-caddie");

	@FindBy(css = ".icon-caddie")
	WebElement articleCaddybutton;
	
	
	//Lisence Plate
	public void lisencePlateNumberField(String lisencePlateNumber) {
		waitforElement(vinbox);
		lpnSelectBox.click();
		lpninsert.sendKeys(lisencePlateNumber);
		System.out.println(lpninsert.getRect().getHeight());
		System.out.println(lpninsert.getRect().getWidth());
		System.out.println(lpninsert.getLocation());
		lpnSearch.click();
	}
	
	//VIN NUMBER
	
	public void vehicleIdentificationNumberField(String VIN) {
		waitforElement(vinbox);
		vinSelectBox.click();
		vininsert.sendKeys(VIN);
		vinSearch.click();
	}
	
	//VIN error message
	public String vinValidationMessage() {
		waitforWebElement(vinErrorMessage);
		return vinErrorMessage.getText();
		
	}
	

	public void vehicleFamily() {
		waitforElement(familySelect);
		Family.click();
		
	}
	
	public String lpnValidationMessage() {
		waitforWebElement(lpnErrorMessage);
		return lpnErrorMessage.getText();
		
	}
	public void vehicleSubFamily() {
	
		SubFamily.click();
	}


	public List<WebElement> articleSelect() {
		return articles;
	}

	public WebElement getArticlename() {
		WebElement partReference = articleSelect().stream()
				.filter(article -> article.findElement(By.cssSelector("span")).getText().equals("CU 3448")).findFirst()
				.orElse(null);
		return partReference;

	}

	public void articleAddCart(String productCount) throws InterruptedException {
		waitforElement(articleCount);
		WebElement partReferenceNumber = getArticlename();
		partReferenceNumber.findElement(articleCount).clear();
		partReferenceNumber.findElement(articleCount).sendKeys(productCount);
		Thread.sleep(3000);
		waitforElement(articleAddToCart);

		partReferenceNumber.findElement(articleAddToCart).click();

		// articleCaddybutton.click();
	}

}
