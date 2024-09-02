package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.homePageObjects;
import pageObjectModel.registrationPageObjects;
import resources.Baseclass;
import resources.commonMethods;
import resources.storedata;

public class verifyRegistration extends Baseclass {

	@Test
	public void verifyRegistrationWithValidData() throws IOException, InterruptedException {

		homePageObjects hp = new homePageObjects(driver);
		
		commonMethods.handleExplictWait(10, hp.clickOnmyAccount(), driver);

		hp.clickOnmyAccount().click();
		hp.clickOnRegister().click();

		registrationPageObjects rp = new registrationPageObjects(driver);
		rp.enterFirstName().sendKeys(storedata.firstname);
		rp.enterLastName().sendKeys(storedata.lastname);
		rp.enterEmail().sendKeys(emailAddress);
		rp.Telephone().sendKeys(storedata.telephone);
		rp.Password().sendKeys(storedata.password);
		rp.PasswordConfirm().sendKeys(storedata.confirmPassword);
		rp.PrivacyPolicy().click();
		rp.Continue().click();

		String actual = rp.getRegistrationConfirmText().getText();
		String expected = storedata.regExpectedText;
		commonMethods.handleAssertion(actual, expected);

	}

	@Test
	public void verifyRegistrationWithBlankData() throws IOException, InterruptedException {

		homePageObjects hp = new homePageObjects(driver);

		commonMethods.handleExplictWait(10, hp.clickOnmyAccount(), driver);

		hp.clickOnmyAccount().click();
		hp.clickOnRegister().click();

		registrationPageObjects rp = new registrationPageObjects(driver);

		rp.Continue().click();

		String FirstNameactual = rp.getfirstnameErrorText().getText();
		String FirstNameexpected = storedata.firstNameErrorExpectedresult;
		commonMethods.handleAssertion(FirstNameactual, FirstNameexpected);

		String LastNameactual = rp.getlastnameErrorText().getText();
		String LastNameexpected = storedata.lastNameErrorExpectedresult;
		commonMethods.handleAssertion(LastNameactual, LastNameexpected);

		String Emailactual = rp.getemailErrorText().getText();
		String Emailexpected = storedata.emailErrorExpectedresult;
		commonMethods.handleAssertion(Emailactual, Emailexpected);

		String Telephoneactual = rp.gettelephoneErrorText().getText();
		String Telephoneexpected = storedata.telephoneErrorExpectedresult;
		commonMethods.handleAssertion(Telephoneactual, Telephoneexpected);

		String Passwordactual = rp.getpasswordErrorText().getText();
		String Passwordexpected = storedata.passwordErrorExpectedresult;
		commonMethods.handleAssertion(Passwordactual, Passwordexpected);

	}

}
