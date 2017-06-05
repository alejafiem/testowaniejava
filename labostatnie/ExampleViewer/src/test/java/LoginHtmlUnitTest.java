import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class LoginHtmlUnitTest {

	private static HtmlUnitDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
	}

	@Test
	public void loginTest() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://songsrails.herokuapp.com/users/sign_in");				
		
		driver.findElement(By.id("user_email")).sendKeys("admin@test.com");
		
		driver.findElement(By.name("user[password]")).sendKeys("123456");
		
		driver.findElement(By.cssSelector("input[name=commit]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("td")));
		
		assertEquals(driver.getTitle(), "Songs");
	}
	
	
	@Test
	public void loginFailedTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://songsrails.herokuapp.com/users/sign_in");
		
		driver.findElement(By.id("user_email")).sendKeys("admin@test.com");
		
		driver.findElement(By.name("user[password]")).sendKeys("fsdfsd");
		
		driver.findElement(By.cssSelector("input[name=commit]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bs-example-navbar-collapse-1")));
		
		assertEquals(driver.findElement(By.xpath("//*[contains(text(), 'Invalid')]")).getText(), "Invalid Email or password.");
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
