package pageObjectDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageFactoryGoogle {
  
  //Nie uzywamy FindByElement !!!
	
  private WebElement q;
  public WebDriver driver;
  
  public PageFactoryGoogle(WebDriver driver){
	  this.driver = driver;
	  driver.get("http://www.google.com/");
  }
  
  public void search(String text) throws Exception{
	  q.sendKeys(text);
	  q.submit();
	  Thread.sleep(1000);
  }
  
  public boolean assertTitle() throws Exception{
		Boolean result = driver.getTitle().contains("Mateusz Miotk");
		System.out.println(driver.getTitle());
		return(result);
	}
  
  
}
