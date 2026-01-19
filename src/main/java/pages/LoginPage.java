package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.DriverInstance;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {
	DriverInstance instance;
	public LoginPage(DriverInstance instance) {
		this.instance=instance;

	}


	@And("User Click the signUp\\/Login button")
	public void userClickTheSignUpLoginButton() {
		System.out.println("Im in LoginPage");
		WebDriverWait wait = new WebDriverWait(instance.getDriver(), Duration.ofSeconds(10));
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//a[contains(text(),'Signup')]"))); until.click();
	}
	@When("user enters valid email and password as {string} and {string}")
	public void userEntersValidEmailAndPasswordAsAnd(String uname, String pass) {
		instance.getDriver().findElement(By.name("email")).sendKeys(uname);
		instance.getDriver().findElement(By.name("password")).sendKeys(pass);
	}




	@When("user clicks on Login button")
	public void userClicksOnLoginButton() {
		instance.getDriver().findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	}
	@Then("username should be displayed on the home page")
	public void usernameShouldBeDisplayedOnTheHomePage() {
		WebElement uname =
				instance.getDriver().findElement(By.xpath("//a[text()=' Logged in as ']//b"));
		System.out.println(uname.getText());

	}


	@When("user enters valid email and invalid password as {string} and {string}")
	public void userEntersValidEmailAndInvalidPasswordAsAnd(String uname, String ivdpass) {
		instance.getDriver().findElement(By.name("email")).sendKeys(uname);
		instance.getDriver().findElement(By.name("password")).sendKeys(ivdpass);
	}

	@When("user click on Login button")
	public void userClickOnLoginButton() {
		instance.getDriver().findElement(By.xpath("(//button[@type='submit'])[1]")).click();

	}
	@Then("error message should be displayed")
	public void errorMessageShouldBeDisplayed() {
		WebElement errmsg = instance.getDriver().findElement(By.
				xpath("//p[text()='Your email or password is incorrect!']")); 
		String errtxt = errmsg.getText(); 
		Assert.assertEquals("Your email or password is incorrect!",errtxt); }


	@When("user clicks on Login button without entering credentials")
	public void userClicksOnLoginButtonWithoutEnteringCredentials() {
		instance.getDriver().findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	}
	@Then("validation message should be displayed")
	public void validationMessageShouldBeDisplayed() {
		WebElement emailfield =instance.getDriver().findElement(By.name("email")); 
		String validationtxt =	emailfield.getAttribute("validation");
		System.out.println(validationtxt);
		


	}


}
