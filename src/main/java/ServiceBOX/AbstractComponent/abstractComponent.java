package ServiceBOX.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ServiceBOX.pageobjectmodel.CaddyPage;

public class abstractComponent {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(css = ".caddy")
	WebElement serviceBoxCaddyButton;
	By serviceCaddyButton = By.cssSelector(".caddy");
	
	
	@FindBy(xpath = "//nav[@id='RFmainHeader']//div[@id='navbarSupportedContent']//button[@class='element-header d-flex align-items-center']")
	WebElement languageChangeWebElement;
	
	By languageChangeLocator = By.xpath("//nav[@id='RFmainHeader']//div[@id='navbarSupportedContent']//button[@class='element-header d-flex align-items-center']");

	
	@FindBy(xpath="//nav[@id='RFmainHeader']//a[@id='RFmainHeader-logo']")
	WebElement serviceBoxLogo;
	
	@FindBy(css = ".btn.btn-link")
	WebElement serviceBoxLogobutton;
	
	@FindBy(xpath = "//li[normalize-space()='Français']")
	WebElement getLanguage;
	
	@FindBy(xpath = "//li[@class='nav-item nav-item-caddy no-border']//button[@type='button']")
	WebElement Logout;
	
	@FindBy(css = "button[class='btn btn-primary']")
	WebElement Logoutbutton;
	
	

	public abstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	public CaddyPage cartPage() throws InterruptedException {
		
		   
		waitforElement(serviceCaddyButton);
		Thread.sleep(2000);
		serviceBoxCaddyButton.click();
		System.out.println("Article added to cart");
		CaddyPage caddyPage = new CaddyPage(driver);
		return caddyPage;
		
		
	}
	public void serviceBoxLogoIcon() {
		serviceBoxLogo.click();
	}
	
	public void languageSelection() throws InterruptedException {
		waitforElement(languageChangeLocator);
		
		languageChangeWebElement.click();
		serviceBoxLogobutton.click();
		getLanguage.click();
		Thread.sleep(4000);
		
	}
	public void logoutMethod() {
		Logout.click();
		Logoutbutton.click();
		
	}
	

	public void waitforElement(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(findBy));
				

	}
	public void waitforWebElement(WebElement lpnErrorMessage) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(lpnErrorMessage));
				

	}


}
