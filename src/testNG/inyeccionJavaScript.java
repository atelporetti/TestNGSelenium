package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class inyeccionJavaScript {
	WebDriver driver = Util.setUpManual();
	
  @Test
  public void f() {
  }
  
  @BeforeTest(groups = {"A", "B"})
	public void beforeTest() {
		System.out.println("Metodo que se ejecuta antes del conjunto de pruebas @Test");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com.ar/");
	}
  
  @AfterTest(groups = {"A"})
	public void afterTest() {
		System.out.println("Metodo que se ejecuta despues del conjunto de pruebas @Test");
		driver.quit();
	}
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
