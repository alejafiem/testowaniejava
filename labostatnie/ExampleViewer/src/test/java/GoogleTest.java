

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {
	
	/*private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		//Do pobrania tutaj: https://github.com/mozilla/geckodriver/releases
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
		driver = new FirefoxDriver();
	}

	@Test
	public void testTitlePage() {
		driver.get("https://duckduckgo.com/");
    	assertEquals("DuckDuckGo", driver.getTitle());
	}
	
	@Test
	public void testClick(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_form_input_homepage")));
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Mateusz Miotk");
		driver.findElement(By.id("search_button_homepage")).click();
		wait.until(ExpectedConditions.titleIs("Mateusz Miotk na DuckDuckGo"));
		assertEquals(driver.getTitle(), "Mateusz Miotk na DuckDuckGo");
	}
	

	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}*/

}
