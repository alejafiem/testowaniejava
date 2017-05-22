package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObjectSongsTest {
	private static WebDriver driver;
	public PageObjectSongs songsPage;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void loginSuccess() throws Exception {
		songsPage = new PageObjectSongs(driver);
		songsPage.login("admin@test.com", "123456");
		assertTrue(songsPage.assertLogin());
	}
	
	@Test
	public void loginFailed() throws Exception {
		songsPage = new PageObjectSongs(driver);
		songsPage.login("admin@test.com", "dsadas");
		assertFalse(songsPage.assertLogin());
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
}
