package webdemo.seleniumDemo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class GoogleTest {
	
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		//Od wersji selenium 3.0 samo FirefoxDriver nie wystarcza
		//Należy dodać sterownik geckodriver
		//Do pobrania tutaj: https://github.com/mozilla/geckodriver/releases
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
/*
	@Test
	public void testTitlePage() {
		driver.get("https://duckduckgo.com/");
    	assertEquals("DuckDuckGo", driver.getTitle());
	}
	
	@Test
	public void testClick(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Mateusz Miotk");
		driver.findElement(By.id("search_button_homepage")).click();
		wait.until(ExpectedConditions.titleIs("Mateusz Miotk na DuckDuckGo"));
		assertEquals(driver.getTitle(), "Mateusz Miotk na DuckDuckGo");
	}
	*/
	
	@Test
	public void browserTestResultFoundAndClick()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://google.com/");

		
		driver.findElement(By.id("lst-ib")).sendKeys("alejafiem github");
		//driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("lst-ib")).submit();
		
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));		
		findElements.get(0).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("branch-infobar")));
		assertEquals(driver.getCurrentUrl(), "https://github.com/alejafiem/asi-1");
	}
	
	@Test
	public void browserTestResultNotFound()
	{
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://google.com/");
		
		driver.findElement(By.id("lst-ib")).sendKeys("alejafiem dsadsa");
		driver.findElement(By.id("lst-ib")).submit();
		
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));		

		assertEquals(findElements.size(), 0);
	}
	
	@Test
	public void browserTestResultCount()
	{
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://google.com/");
		
		driver.findElement(By.id("lst-ib")).sendKeys("alejafiem github");
		driver.findElement(By.id("lst-ib")).submit();
		
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));		

		assertEquals(findElements.size(), 10);
	}
	
	@Test
	public void loginTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://songsrails.herokuapp.com/");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("td")));
		
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("user_email")).sendKeys("admin@test.com");
		
		driver.findElement(By.name("user[password]")).sendKeys("123456");
		
		driver.findElement(By.cssSelector("input[name=commit]")).click();
		
		assertEquals(driver.findElement(By.partialLinkText("Logo")).getText(), "Logout");
	}
	
	@Test
	public void loginFailedTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://songsrails.herokuapp.com/");
		
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("user_email")).sendKeys("admin@test.com");
		
		driver.findElement(By.name("user[password]")).sendKeys("fsdfsd");
		
		driver.findElement(By.cssSelector("input[name=commit]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert alert-alert")));
		
		assertEquals(driver.findElement(By.className("alert alert-alert")).getText(), "Invalid Email or password.");
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
