

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePhantomJSTest {
	
	/*private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "src/test/resources/phantomjs");
		driver = new PhantomJSDriver();
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
