package webdemo.seleniumDemo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
		//System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//lab11
	@Test
	public void zad1()
	{
		ArrayList<String> linkarray = new ArrayList<String>();
		
		driver.get("https://google.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++)
		{
			linkarray.add(links.get(i).getAttribute("href"));
		} 
		
		// navigate to each Link on the webpage
		for(int i=0;i<links.size();i++)
		{
		driver.navigate().to(linkarray.get(i));
		//Thread.sleep(3000);
		driver.navigate().back();
		}
		//google
		for(int i=0;i<links.size();i++)
		{
			if(linkarray.get(i).contains("google"))
			{
				driver.navigate().to(linkarray.get(i));
		
				driver.navigate().back();
			}
		}
		
	}
	
	@Test
	public void zad1_2()
	{
		ArrayList<String> linkarray = new ArrayList<String>();
		
		driver.get("https://courses.edx.org/register");
		
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		
		for(int i=0;i<inputs.size();i++)
		{
			linkarray.add(inputs.get(i).getAttribute("name"));		
			System.out.println(inputs.get(i).getAttribute("name"));
		} 
		
		List<WebElement> selects = driver.findElements(By.tagName("select"));
		
		for(int i=0;i<selects.size();i++)
		{
			Select se = new Select(selects.get(i));
			List<WebElement> l = se.getOptions();
			System.out.println(selects.get(i).getAttribute("name") + " - " + l.size());
		} 						 
	}
	
	@Test
	public void zad2AccountAlreadyExists()
	{		
		driver.get("https://courses.edx.org/register");
		
		driver.findElement(By.id("register-email")).sendKeys("hophophop997@yopmail.com");
		
		driver.findElement(By.id("register-name")).sendKeys(("Radoslaw Dziaslo"));
		
		driver.findElement(By.id("register-username")).sendKeys(("RadzioDziaslo"));
		
		driver.findElement(By.id("register-password")).sendKeys(("trudnehaslo666"));
		
		List<WebElement> selects = driver.findElements(By.tagName("select"));				
		
		for(int i=0;i<selects.size();i++)
		{
			Select se = new Select(selects.get(i));
			se.selectByIndex(2);
		} 
		
		driver.findElement(By.id("register-goals")).sendKeys(("testesttest"));
		
		driver.findElement(By.id("register-honor_code")).click();
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
				
		assertEquals(driver.findElement(By.tagName("h4")).getText(), "We couldn't create your account.");
		
	}
	
	@Test
	public void zad2WrongEmail()
	{
		driver.get("https://courses.edx.org/register");
		
		driver.findElement(By.id("register-email")).sendKeys("hophophop997");
		
		driver.findElement(By.id("register-name")).sendKeys(("Radoslaw Dziaslo"));
		
		driver.findElement(By.id("register-username")).sendKeys(("RadzioDziaslo"));
		
		driver.findElement(By.id("register-password")).sendKeys(("trudnehaslo666"));
		
		List<WebElement> selects = driver.findElements(By.tagName("select"));				
		
		for(int i=0;i<selects.size();i++)
		{
			Select se = new Select(selects.get(i));
			se.selectByIndex(2);
		} 
		
		driver.findElement(By.id("register-goals")).sendKeys(("testesttest"));
		
		driver.findElement(By.id("register-honor_code")).click();
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
				
		assertEquals(driver.findElement(By.xpath("//ul[@class='message-copy']/li")).getText(), "The email address you've provided isn't formatted correctly.");
	}
	
	@Test
	public void zad2PolishLetters()
	{
		driver.get("https://courses.edx.org/register");
		
		driver.findElement(By.id("register-email")).sendKeys("hophophop997xx@yopmail.com");
		
		driver.findElement(By.id("register-name")).sendKeys(("Radosław Dziąsło"));
		
		driver.findElement(By.id("register-username")).sendKeys(("RadzioDziąsło"));
		
		driver.findElement(By.id("register-password")).sendKeys(("trudnehaslo666"));
		
		List<WebElement> selects = driver.findElements(By.tagName("select"));				
		
		for(int i=0;i<selects.size();i++)
		{
			Select se = new Select(selects.get(i));
			se.selectByIndex(2);
		} 
		
		driver.findElement(By.id("register-goals")).sendKeys(("testesttest"));
		
		driver.findElement(By.id("register-honor_code")).click();
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		System.out.println(driver.findElement(By.xpath("//ul[@class='message-copy']/li")).getText());
		
		assertEquals(driver.findElement(By.xpath("//ul[@class='message-copy']/li")).getText(), "Usernames can only contain Roman letters, western numerals (0-9), underscores (_), and hyphens (-).");
	}
	
	@Test
	public void zad3()
	{
		driver.get("https://google.com/");
		
		driver.navigate().refresh();
		
		driver.get(driver.getCurrentUrl());
		
		driver.navigate().to(driver.getCurrentUrl());
		
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.F5); 
		
		assertEquals(driver.getTitle(), "Google");
		
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
