package pageObjectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectSongs {
	public WebDriver driver;
	private final Wait<WebDriver> wait;

	public PageObjectSongs(WebDriver driver){
		this.driver = driver;
		driver.get("https://songsrails.herokuapp.com/users/sign_in");
		wait = new WebDriverWait(driver,10);
	}
	
	public void login(String login, String password) throws Exception{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user[email]")));
		driver.findElement(By.name("user[email]")).sendKeys(login);
		driver.findElement(By.name("user[password]")).sendKeys(password);
		driver.findElement(By.name("commit")).submit();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert")));
	}
		
	public boolean assertLogin() throws Exception{
		Boolean result = driver.getPageSource().contains("Logout");
		System.out.println(result);
		return(result);
	}
}
