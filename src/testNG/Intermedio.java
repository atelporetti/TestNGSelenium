package testNG;
import java.util.concurrent.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;


public class Intermedio {
	WebDriver driver = Util.setUpManual();;
  @BeforeTest
  public void beforeTest() {
	  driver.get("http://demo.guru99.com/test/newtours/");
  }
  
  @BeforeMethod
  public void verificarPagina() {
	  String tituloPaginaEsperado = "Welcome: Mercury Tours";
	  Assert.assertEquals(tituloPaginaEsperado, driver.getTitle(), "Titulo de la pagina no esperado");
  }

  @AfterMethod
  public void volverPaginaPrincipal() {
	  driver.findElement(By.cssSelector("a[href='index.php']")).click();
  }

  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

  @Test
  public void verificarRegister() {
	  driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
	  String tituloPaginaEsperado = "Register: Mercury Tours";
	  Assert.assertEquals(tituloPaginaEsperado, driver.getTitle(), "Titulo de la pagina no esperado");
  }
  
  @Test
  public void verificarSupport() {
	  driver.findElement(By.xpath("//a[text()='SUPPORT']")).click();
	  String tituloPaginaEsperado = "Under Construction - Mercury Tours";
	  Assert.assertEquals(tituloPaginaEsperado, driver.getTitle(), "Titulo de la pagina no esperado");
  }
}
