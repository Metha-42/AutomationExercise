package pages;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import driver.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {

	DriverInstance instance;
	public HomePage(DriverInstance instance) {
		this.instance=instance;
	}




	@Given("user enters product name in search box")
	public void userEntersProductNameInSearchBox() {
		instance.getWait().until(ExpectedConditions.urlMatches("https://automationexercise.com/products"));
		System.out.println("before serch :"+ instance.getDriver().getCurrentUrl());
		WebElement searchBox = instance.getDriver().findElement(By.xpath("//input[@placeholder='Search Product']"));
		System.out.println("After serch :"+instance.getDriver().getCurrentUrl());
		instance.getWait().until(ExpectedConditions.visibilityOf(searchBox));
		System.out.println(instance.getDriver().getCurrentUrl());
		searchBox.sendKeys("frozen");
	}


	@When("user clicks on search button")
	public void userClicksOnSearchButton() {

		instance.getDriver().findElement(By.id("submit_search"));

	}
	@Then("matching products should be displayed")
	public void matchingProductsShouldBeDisplayed() {

		WebElement productele = instance.getDriver().findElement(By.xpath("(//div[starts-with(@class,'productinfo text-center')])//p[text()='Frozen Tops For Kids']"));
		String producttext = productele.getText();
		System.out.println(producttext);
		assertEquals("Frozen Tops For Kids", producttext);
		instance.takeScreenshot(instance.getDriver(), producttext, null);
	}

	//Next Scenario>..............................
	@When("user clicks on searched product")
	public void userClicksOnSearchedProduct() {
		WebElement prodele = instance.getDriver().findElement(By.xpath("(//div[starts-with(@class,'productinfo text-center')])//p[text()='Frozen Tops For Kids']"));
		instance.getWait().until(ExpectedConditions.elementToBeClickable(prodele));
		prodele.click();
	}
	@Then("product details page should be displayed")
	public void productDetailsPageShouldBeDisplayed() {

		String currentUrl = instance.getDriver().getCurrentUrl();
		System.out.println(currentUrl);
		assertEquals(currentUrl.equals(currentUrl), true);


	}
	@Then("product name, price, and availability should be visible")
	public void productNamePriceAndAvailabilityShouldBeVisible() {

		WebElement productDetails = instance.getDriver().findElement(By.xpath("(//div[starts-with(@class,'choose')])[11]"));
		instance.getWait().until(ExpectedConditions.visibilityOf(productDetails));
		instance.takeScreenshot(instance.getDriver(), null, productDetails);
	}



	//Next Scenario>......................Add product to cart


	@When("user adds a product to the cart")
	public void userAddsAProductToTheCart() {

		WebElement prodele = instance.getDriver().findElement(By.xpath("(//div[starts-with(@class,'productinfo text-center')])//p[text()='Frozen Tops For Kids']"));
		instance.getWait().until(ExpectedConditions.elementToBeClickable(prodele));
		WebElement addcart = instance.getDriver().findElement(By.xpath("//a[@data-product-id='13']"));
		instance.getWait().until(ExpectedConditions.elementToBeClickable(addcart));
		addcart.click();

	}
	@Then("selected product should be displayed in the cart")
	public void selectedProductShouldBeDisplayedInTheCart() {
		WebElement cartproduct = instance.getDriver().findElement(By.linkText("Frozen Tops For Kids"));
		instance.getWait().until(ExpectedConditions.elementToBeClickable(cartproduct));
		instance.takeScreenshot(instance.getDriver(),null , null);
		cartproduct.click();
		String url="https://automationexercise.com/product_details/13";
		String currentUrl = instance.getDriver().getCurrentUrl();
		assertEquals(url,currentUrl);
	}

	//Next Scenario>...................Remove product from cart


	@Given("selected product is already added to the cart")
	public void selectedProductIsAlreadyAddedToTheCart() {
		WebElement cart = instance.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' Cart']")));
		cart.click();
		System.out.println("Cart Size "+cart.getSize());
			
				
			System.out.println("if stmt");
			WebElement cartEle1 = instance.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@id='product-13']/td[2]/h4/a")));
			//WebElement cartEle1 = instance.getDriver().findElement(By.xpath("//tr[@id='product-13']/td[2]/h4/a"));														//*[@id='product-13']/td[2]/h4/a		
			assertEquals(cartEle1.isDisplayed(), true);
			instance.takeScreenshot(instance.getDriver(), null, null);
				
		//	WebElement element = instance.getDriver().findElement(By.xpath("//*[@id='empty_cart']/p/a"));
			//element.click();
			//userAddsAProductToTheCart();

		
	}
	@When("user removes the product from the cart")
	public void userRemovesTheProductFromTheCart() {
		instance.getDriver().findElement(By.xpath("//tr[@id='product-13']/td[6]/a")).click();


	}
	@Then("product should be removed successfully")
	public void productShouldBeRemovedSuccessfully() {



		WebElement emptyMsg = instance.getDriver().findElement(By.xpath("//*[@id='empty_cart']/p/b"));
		String msgText = emptyMsg.getText();
		System.err.println("Cleaning Cart MSG "+msgText);
		assertEquals(msgText, "Cart is empty!");
	}

// checkout feature 1st scenario...............................
	
	
	@Given("user is logged in")
	public void userIsLoggedIn() {
		HeaderPage header= new HeaderPage(instance);
		header.userLoggedIn();
	
	}
	
	@Given("product is added to the cart")
	public void productIsAddedToTheCart() {
		WebElement element = instance.getDriver().findElement(
				(By.xpath("(//a[@data-product-id='13'])[1]")));
		instance.getWait().until(ExpectedConditions.presenceOfElementLocated((By) element)).click();
		instance.getDriver().findElement((By.xpath("//div[@id='cartModal']/div/div/div[2]/p[2]/a"))).click();
		
	}
	@When("user proceeds to checkout")
	public void userProceedsToCheckout() {
		instance.getWait().until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id='do_action']/div[1]/div/div/a"))).click();
	}
	@Then("address details page should be displayed")
	public void addressDetailsPageShouldBeDisplayed() {
		WebElement adress = instance.getDriver().findElement(By.xpath("//div[@class='col-xs-12 col-sm-6'][1]"));
		instance.takeScreenshot(instance.getDriver(), null, adress);
		instance.getDriver().findElement(By.xpath("//*[@id='cart_items']/div/div[7]/a")).click();
		
	}
	@Then("order summary should be visible")
	public void orderSummaryShouldBeVisible() {
		String parentWindow = 	instance.getDriver().getWindowHandle();

Set<String> allWindows = instance.getDriver().getWindowHandles();

for (String window : allWindows) {
    if (!window.equals(parentWindow)) {
        instance.getDriver().switchTo().window(window);
        break;
    }
}

instance.getDriver().findElement(By.name("name_on_card")).sendKeys("Antonio");
instance.getDriver().findElement(By.name("card_number")).sendKeys("12345678");
instance.getDriver().findElement(By.name("cvc")).sendKeys("123");
instance.getDriver().findElement(By.name("expiry_month")).sendKeys("12");
instance.getDriver().findElement(By.name("expiry_year")).sendKeys("1234");
instance.getDriver().findElement(By.id("submit")).click();
WebElement summary = instance.getWait().until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]")));
System.out.println(summary.getText());
	
	}
// next scenario .............................
	@Given("user is not logged in")
	public void userIsNotLoggedIn() {
		WebElement signup = instance.getDriver().findElement(By.xpath("//*[text()=' Signup / Login']"));
	System.out.println(signup.getText());
	
	}
	@When("user tries to access checkout")
	public void userTriesToAccessCheckout() {
	   
		instance.getWait().until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id='do_action']/div[1]/div/div/a"))).click();
	}
	@Then("user should be redirected to login or signup page")
	public void userShouldBeRedirectedToLoginOrSignupPage() {
		WebElement msg = instance.getWait().until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id='checkoutModal']/div/div/div[2]/p[1]")));
		System.out.println(msg.getText());
		
		
	}
	





}
