package testNG;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
import org.testng.Assert;
import org.testng.annotations.*;


@Test
public class OtraPrueba {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "C:\\msedgedriver.exe";
    public WebDriver driver ;
    
    @Test(priority = 0)
    public void verificarTituloLandingPage() {
        
        String tituloEsperado = "Welcome: Mercury Tours";
        String titulo = driver.getTitle();
        Assert.assertEquals(titulo, tituloEsperado);
    }
    
    @Test(priority = 1)
    public void register(){
  	  String expected, actual = null;
        driver.findElement(By.linkText("REGISTER")).click() ;
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }
        @Test(priority = 2)
    public void support() {
      	 String expected, actual = null;
          driver.findElement(By.linkText("SUPPORT")).click() ;
          expected = "Under Construction: Mercury Tours";
          actual = driver.getTitle();
          Assert.assertEquals(actual, expected);
    }
        
  @BeforeMethod
  public void f ( ) {
}

  @AfterMethod
  public void volverLandingPage ( ) {
      driver.findElement(By.linkText("Home")).click();
}

  @BeforeTest
  public void inicio() {
	  System.setProperty("webdriver.edge.driver", driverPath);
      driver= new EdgeDriver();
      driver.get(baseUrl);
  }


  @AfterTest
  public void finalizar() {
	  driver.quit();
  
  }

}
