
  package stepdefinitions;
  
  import
  io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import
  io.cucumber.java.en.When;
  
  public class LoginSteps {
  
		/*
		 * 
		 * 
		 * @Given("user launches the AutomationExercise website") public void
		 * userLaunchesTheAutomationExerciseWebsite() {
		 * driver.get("https://automationexercise.com/");
		 * driver.manage().window().maximize();
		 * 
		 * 
		 * }
		 * 
		 * @Given("user navigates to Login page") public void userNavigatesToLoginPage()
		 * { WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated
		 * (By.xpath("//a[contains(text(),'Signup')]"))); until.click();
		 * 
		 * 
		 * }
		 * 
		 * @When("user enters valid email and password") public void
		 * userEntersValidEmailAndPassword() {
		 * 
		 * driver.findElement(By.name("email")).sendKeys("antoniodas420@gmail.com");
		 * driver.findElement(By.name("password")).sendKeys("PAss123@");
		 * 
		 * 
		 * }
		 * 
		 * @When("user clicks on Login button") public void userClicksOnLoginButton() {
		 * driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click(); }
		 * 
		 * 
		 * 
		 * @Then("username should be displayed on the home page") public void
		 * usernameShouldBeDisplayedOnTheHomePage() {
		 *  WebElement uname =
		 * driver.findElement(By.xpath("//a[text()=' Logged in as ']//b"));
		 * System.out.println(uname.getText());
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * @When("user click on Login button") public void userClickOnLoginButton() {
		 * driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click(); }
		 * 
		 * 
		 * @When("user enters valid email and invalid password") public void
		 * userEntersValidEmailAndInvalidPassword() {
		 * 
		 * driver.findElement(By.name("email")).sendKeys("antoniodas420@gmail.com");
		 * driver.findElement(By.name("password")).sendKeys("Invalid");
		 * 
		 * 
		 * }
		 * 
		 * @Then("error message should be displayed") public void
		 * errorMessageShouldBeDisplayed() { 
		 * WebElement errmsg = driver.findElement(By.
		 * xpath("//p[text()='Your email or password is incorrect!']")); String errtxt =
		 * errmsg.getText(); Assert.assertEquals("Your email or password is incorrect!",
		 * errtxt); }
		 * 
		 * 
		 * 
		 * @When("user clicks on Login button without entering credentials") public void
		 * userClicksOnLoginButtonWithoutEnteringCredentials() {
		 * driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		 * 
		 * 
		 * }
		 * 
		 * @Then("validation message should be displayed") public void
		 * validationMessageShouldBeDisplayed() {
		 *  WebElement emailfield =
		 * driver.findElement(By.name("email")); String validationtxt =
		 * emailfield.getAttribute("validation"); System.out.println(validationtxt);
		 * //Assert.assertEquals(null, null); }
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 */
  
  
  
  
  
  
  
  
 




@Given("user launches the AutomationExercise website")
public void userLaunchesTheAutomationExerciseWebsite() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Given("user navigates to Login page")
public void userNavigatesToLoginPage() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@When("user clicks on Login button without entering credentials")
public void userClicksOnLoginButtonWithoutEnteringCredentials() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Then("validation message should be displayed")
public void validationMessageShouldBeDisplayed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}}