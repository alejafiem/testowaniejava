package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObjectGoogleTest {
	
	private static WebDriver driver;
	public PageObjectGoogle googlePage;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/*
	@Test
	public void searchGoogle() throws Exception {
		googlePage = new PageObjectGoogle(driver);
		googlePage.search();
		assertTrue(googlePage.assertTitle());
	}*/
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
