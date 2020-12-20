package testNG;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.*;

public class PrimerPruebaTestNG {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "C:\\msedgedriver.exe";
    public WebDriver driver ; 
  @Test
  public void verifyHomepageTitle() {
      
      System.out.println("launching Edge browser"); 
      System.setProperty("webdriver.edge.driver", driverPath);
      driver = new EdgeDriver();
      driver.get(baseUrl);
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.close();
	  
  }
}
