package driver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverInstance{

	private RemoteWebDriver driver;
	private WebDriverWait wait;
	public RemoteWebDriver getDriver() {
		return driver;
	}
	public void setDriver(RemoteWebDriver driver) {
		this.driver = driver;
	}
	public WebDriverWait getWait() {
		return wait;
	}
	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

	
	
		

	

		public String SCREENSHOT_DIR = "screenshots";


		   

		    public  String takeScreenshot(RemoteWebDriver driver, String currentUrl, WebElement element) {
		        if (driver == null) {
		            throw new IllegalArgumentException("WebDriver instance is null");
		        }

		        String timestamp = LocalDateTime.now()
		                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

		        String fileName = currentUrl+ "_"+ timestamp + ".png";
		        Path destinationPath = Paths.get(SCREENSHOT_DIR, fileName);

		        try {
		            Files.createDirectories(destinationPath.getParent());

		            File source = ((TakesScreenshot) driver)
		                    .getScreenshotAs(OutputType.FILE);

		            Files.copy(source.toPath(), destinationPath);

		        } catch (IOException e) {
		            throw new RuntimeException("Failed to capture screenshot", e);
		        }
		    
		        return destinationPath.toAbsolutePath().toString();
		      }
				
	}

		

		
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	




