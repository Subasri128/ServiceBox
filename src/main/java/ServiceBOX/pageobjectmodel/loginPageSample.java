package ServiceBOX.pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ServiceBOX.AbstractComponent.abstractComponent;

public class loginPageSample extends abstractComponent {

	public  WebDriver driver;

	public loginPageSample(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userid")
	

	WebElement user;

	@FindBy(id = "storecode")
	

	WebElement RRDIcode;

	@FindBy(id = "dopr")
	

	WebElement doprcode;

	@FindBy(className = "btn-primary")
	

	WebElement Submit;

	@FindBy(id = "country")
	

	WebElement selectcountry;

	@FindBy(id = "language")
	

	WebElement selectLanguage;

	public void recette() {
		driver.get("https://recette.multibrand.servicebox-parts.com//login/");

	}

	public void integration() {
		driver.get("https://integration.multibrand.servicebox-parts.com//login/");

	}

	public void preview() {
		driver.get("https://preview.multibrand.servicebox-parts.com//login/");

	}

	public void loginDetails(String userid, String storecode, String dopr) {
		user.clear();
		user.sendKeys(userid);
		RRDIcode.clear();
		RRDIcode.sendKeys(storecode);
		doprcode.clear();
		doprcode.sendKeys(dopr);
		
	}

	public void selectCountry(String country) {
		Select drop = new Select(selectcountry);
		drop.selectByVisibleText(country);

	}

	public void selectLanguage(String language) {
		Select dropdown = new Select(selectLanguage);
		dropdown.selectByVisibleText(language);
	}

	public  homepage submit() {
		Submit.click();
		homepage homePage = new homepage(driver);
		return homePage;
	}
}
