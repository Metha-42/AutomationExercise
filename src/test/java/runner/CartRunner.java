package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = {"src/main/resources/feature/Cart.feature"},
		dryRun = 
		!true,
		monochrome = true,
		glue={"hooks","pages" },
		snippets = SnippetType.CAMELCASE,
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,tags= "")
public class CartRunner extends AbstractTestNGCucumberTests {


}