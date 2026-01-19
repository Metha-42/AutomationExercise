package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import driver.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HeaderPage {
	
	DriverInstance instance;
	public HeaderPage(DriverInstance instance) {
		this.instance=instance;
	}
	@Given("user navigates to the Products page")
	public void userNavigatesToTheProductsPage() {
		 instance.getDriver().findElement(By.xpath("(//a[@href])[3]//i")).click();
	System.out.println("Product Page clicked ");
	}
	@Given("user logged in")
	public void userLoggedIn() {
	    LoginPage page= new LoginPage(instance);
	    page.userClickTheSignUpLoginButton();
	    page.userEntersValidEmailAndPasswordAsAnd("antoniodas420@gmail.com", "PAss123@");
	    page.userClicksOnLoginButton();
	}


@When("user navigates to cart page")
public void userNavigatesToCartPage() {

	WebElement viewCart = instance.getDriver().findElement(By.xpath("//a[@href='/view_cart']//u"));
	instance.getWait().until(ExpectedConditions.elementToBeClickable(viewCart));
	viewCart.click();

}

}
