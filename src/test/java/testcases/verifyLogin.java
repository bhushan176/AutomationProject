package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.homePageObjects;
import pageObjectModel.loginPageObjects;
import resources.Baseclass;
import resources.commonMethods;
import resources.storedata;

public class verifyLogin extends Baseclass {

	@Test
	public void verifyLoginWithValidData() throws IOException, InterruptedException {

		homePageObjects hp = new homePageObjects(driver);

		commonMethods.handleExplictWait(10, hp.clickOnmyAccount(), driver);

		hp.clickOnmyAccount().click();
		hp.clickOnLogin().click();

		loginPageObjects lp = new loginPageObjects(driver);

		lp.enterEmail().sendKeys(emailAddress);
		lp.enterPassword().sendKeys(storedata.password);
		lp.clickOnSubmit().click();

		String actual = driver.getCurrentUrl();
		String expected = storedata.LoginExpectedURL;
		commonMethods.handleAssertion(actual, expected);

		lp.clickOnMyAccount().click();
		lp.clickOnLogout().click();

		String actualWarningText = lp.getlogoutConfirmationText().getText();
		String expectedWarningText = storedata.LogOutExpectedConfirmationtext;
		commonMethods.handleAssertion(actualWarningText, expectedWarningText);

	}

	@Test
	public void verifyLoginWithInValidData() throws IOException, InterruptedException {

		homePageObjects hp = new homePageObjects(driver);

		hp.clickOnmyAccount().click();
		hp.clickOnLogin().click();

		loginPageObjects lp = new loginPageObjects(driver);

		lp.enterEmail().sendKeys(emailAddress);
		lp.enterPassword().sendKeys(storedata.incorrectPassword);
		lp.clickOnSubmit().click();

		commonMethods.handleExplictWait(15, lp.warningText(), driver);

		String actual = lp.warningText().getText();
		String expected = storedata.LoginFailedExpectedText;

		commonMethods.handleAssertion(actual, expected);
	}
}
