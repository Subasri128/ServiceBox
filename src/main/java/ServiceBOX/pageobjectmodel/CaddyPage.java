package ServiceBOX.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ServiceBOX.AbstractComponent.abstractComponent;

public class CaddyPage extends abstractComponent {
	WebDriver driver;

	public CaddyPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@formcontrolname='productSku']")
	List<WebElement> caddyArticles;

	public Boolean getCaddyArticlename(String productName) {
		
		Boolean match = caddyArticles.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
}}
