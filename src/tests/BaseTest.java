package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.CommonHome;

public abstract class BaseTest {

	protected WebDriver driver;
	protected CommonHome homePage;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_linux64/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		// options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		// driver= new ChromeDriver();
		driver.get("http://opencart.abstracta.us");
		homePage = PageFactory.initElements(driver, CommonHome.class);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
