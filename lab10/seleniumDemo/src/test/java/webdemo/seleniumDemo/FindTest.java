package webdemo.seleniumDemo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindTest {
	
	//Przykłady znajdowania elementów na stronie www
	
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Implicity wait -> max czas na znalezienie elementu na stronie
		driver.get("https://www.google.pl");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
/*
	@Test
	public void findById() {
		WebElement element = driver.findElement(By.id("lst-ib"));
		assertNotNull(element);
	}
	
	@Test
	public void findByName() {
		WebElement element = driver.findElement(By.name("q"));
		assertNotNull(element);
	}
	
	@Test
	public void findByClass() {
		WebElement element = driver.findElement(By.className("gsfi"));
		assertNotNull(element);
	}
	
	@Test
	public void findBylinkText() {
		WebElement element = driver.findElement(By.linkText("Gmail"));
		assertNotNull(element);
	}
	
	@Test
	public void findByPartiallinkText() {
		WebElement element = driver.findElement(By.partialLinkText("Gra"));
		assertNotNull(element);
	}
	
	@Test
	public void findByTagName() {
		WebElement element = driver.findElement(By.tagName("div"));
		assertNotNull(element);
	}
	
	@Test
	public void findByCssSelector() {
		WebElement element = driver.findElement(By.cssSelector("input.gsfi"));
		assertNotNull(element);
	}*/
	



}
