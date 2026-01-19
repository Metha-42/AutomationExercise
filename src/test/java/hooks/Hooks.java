package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import driver.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks  {
	DriverInstance instance;
	public Hooks(DriverInstance instance) {
		this.instance=instance;

	}
	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Im in Hooks");
		ChromeOptions options = new ChromeOptions();

		// Disable ads & notifications
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-site-isolation-trials");
		options.addArguments("--disable-features=IsolateOrigins,site-per-process");


		// Block ads & tracking requests
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.ads", 2);
		prefs.put("profile.default_content_setting_values.popups", 2);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("profile.managed_default_content_settings.images", 2);
		prefs.put("profile.default_content_setting_values.ads", 2);
		prefs.put("profile.default_content_setting_values.popups", 2);
		prefs.put("profile.default_content_setting_values.notifications", 2);

		options.setExperimentalOption("prefs", prefs);

		RemoteWebDriver driver = new ChromeDriver(options); 

		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		instance.setDriver(driver);
		instance.setWait(wait);

		instance.getDriver().get("https://automationexercise.com/");
		instance.getDriver().manage().window().maximize();
		//instance.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	//	JavascriptExecutor js = driver;
	//	js.executeScript(
	//			"document.querySelectorAll('iframe[id^=\"aswift\"], iframe[src*=\"ads\"]').forEach(e => e.remove());");
	}

	@After
	public void afterScenario(Scenario scenario) {
		boolean failed = scenario.isFailed();
		if (failed) {
			String takeScreenshot = instance.takeScreenshot(instance.getDriver(), scenario.getName(), null);
			try {
				ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(takeScreenshot, scenario.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}


		}
		instance.getDriver().quit();
	}

}














