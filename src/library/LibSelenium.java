package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coreFrame.Config;

public class LibSelenium {

	WebDriver driver;
	WebElement webElement ;
	WebDriverWait wait;
	static LibSelenium instacia = new LibSelenium();
	private Config config = Config.getInstance();
	
	private LibSelenium(){}
	
	public static LibSelenium getInstance(){
		return instacia;
	}
	
	public void navigate(String URL) {
		switch (config.getUsingBrowser()) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", (config.getFramePath() + getSystemDriver())
					.replace("ProjetoTesteSelenium", "FrameworkApoio"));
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			this.driver = new ChromeDriver(options);
			driver.get(URL);
			break;
		case "IE":
			
			break;

		case "Firefox":

			break;
		}

	}
	
	private String getSystemDriver() {
		String systemDriver = null;

		if (System.getProperty("os.name").contains("Linux")) {
			systemDriver = "lib//chromedriver";
		} else if (System.getProperty("os.name").contains("Windows")) {
			systemDriver = "lib//chromedriver.exe";
		}

		return systemDriver;
	}

	public WebElement findObject(String xPath) {
		webElement = driver.findElement(By.xpath(xPath));
		return webElement;
	}
	
	public void click(String xPath) {
		findObject(xPath).click();
	}

	public void sendKeys(String xPath, String texto) {
		findObject(xPath).sendKeys(texto);
	}
	
	public boolean exists(String xPath) {
		try {
			findObject(xPath);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getProperty(String xPath, String atribute) {
		return findObject(xPath).getAttribute(atribute).toString();
	}

	public void waitElement(String xPath){
		wait = new WebDriverWait(driver, 10);  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));		
	}
	
	public void driverClose() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
}