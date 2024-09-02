package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePageObjects {

	public WebDriver driver;

	// Encapsulation
	private By myAccount = By.xpath("//a[@title='My Account']");
	private By register = By.xpath("//a[text()='Register']");
	private By login = By.xpath("//a[text()='Login']");

	
	// Constructor
	public homePageObjects(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement clickOnmyAccount() {

		return driver.findElement(myAccount);
	}

	public WebElement clickOnRegister() {

		return driver.findElement(register);
	}
	
	public WebElement clickOnLogin() {

		return driver.findElement(login);
	}

}
