

import static org.junit.Assert.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRUDTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
		driver = new FirefoxDriver();	

	}

	@Test
	public void AddTest() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		driver.get("https://songsrails.herokuapp.com/users/sign_in");				
		
		driver.findElement(By.id("user_email")).sendKeys("admin@test.com");
		
		driver.findElement(By.name("user[password]")).sendKeys("123456");
		
		driver.findElement(By.cssSelector("input[name=commit]")).click();
					
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[contains(text(), 'Add')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("song_author")).sendKeys("dsa");		
		driver.findElement(By.id("song_name")).sendKeys("dsa");
		driver.findElement(By.id("song_key")).sendKeys("dsa");
		driver.findElement(By.id("song_chord")).sendKeys("dsa");
		driver.findElement(By.id("song_instrument")).sendKeys("dsa");
		driver.findElement(By.id("song_duration")).sendKeys("dsa");
		
		driver.findElement(By.cssSelector("input[name=commit]")).click();
		
		Thread.sleep(3000);
		
		WebElement baseTable = driver.findElement(By.className("table table-bordered table-striped"));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
		tableRows.get(0).getText();
		
		assertEquals(tableRows.get(0).getText(), "Songs");
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
	
}
