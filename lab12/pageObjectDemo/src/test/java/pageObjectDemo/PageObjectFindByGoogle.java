package pageObjectDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjectFindByGoogle {
   
	public WebDriver driver;
   
	@FindBy(id = "lst-ib")
	private WebElement submitMe;
	
	@FindBy(name = "q")
	private WebElement searchMe;
	
	public PageObjectFindByGoogle(WebDriver driver){
		this.driver = driver;
		driver.get("http://www.google.com/");
	}
	
	public void search(String text) throws Exception{
		searchMe.sendKeys(text);
		submitMe.submit();
		Thread.sleep(1000);
	}
	
	public boolean assertTitle() throws Exception{
		Boolean result = driver.getTitle().contains("Mateusz Miotk");
		System.out.println(driver.getTitle());
		return(result);
	}
	
}
