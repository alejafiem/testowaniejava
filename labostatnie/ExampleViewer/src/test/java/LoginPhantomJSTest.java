import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPhantomJSTest {

	private static WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "src/test/resources/phantomjs");
		driver = new PhantomJSDriver();
	}

	@Test
	public void loginTest()
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
	
	@Test
	public void test()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://songsrails.herokuapp.com/users/sign_in");
		
		isElementPresent(By.id("user_email"));
		
		assertEquals(isElementPresent(By.id("user_email")), true);
	}
	
	public boolean isElementPresent(By by)
	{
		try {
	        driver.findElement(by);
	    } catch (NoSuchElementException e) {
	        return false;
	    }
		return true;
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
