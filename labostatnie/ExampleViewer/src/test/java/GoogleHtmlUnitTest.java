

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class GoogleHtmlUnitTest {
	
	private static HtmlUnitDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
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
		wait.until(ExpectedConditions.titleIs("Mateusz Miotk at DuckDuckGo"));
		assertEquals(driver.getTitle(), "Mateusz Miotk at DuckDuckGo");
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
