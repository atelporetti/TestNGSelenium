package testNG;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.*;

public class Parametrizacion {
	WebDriver driver = Util.setUpManual();;	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Metodo que se ejecuta antes de una suite de pruebas");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Metodo que se ejecuta antes del conjunto de pruebas @Test");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com.ar/");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Metodo que se ejecuta antes de la clase");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Metodo que se ejecuta antes de cada @Test");
	}
	
	@Test(groups = "B", dataProvider = "Buscador", enabled = true)
	public void busqueda(String usuario, String busqueda) throws InterruptedException {
		WebElement cajaDeBusqueda = driver.findElement(By.cssSelector("input[name='q']"));
		cajaDeBusqueda.sendKeys(busqueda);
		System.out.println("Usuario: " + usuario);
		Thread.sleep(1000);
		
		String input = cajaDeBusqueda.getAttribute("value"); //siempre son value para sacar el texto de cuadros de busqueda
		System.out.println("El texto buscado es: " + input + ", y la busqueda por parametro era: " + busqueda);
		Assert.assertTrue(input.equals(busqueda), "No coinciden");
		cajaDeBusqueda.clear();
	}
	
	
	@Test(groups = "X", enabled = false, dataProvider = "BuscadorDesdeClase", dataProviderClass = BuscadorDesdeClase.class)
	public void busquedaDesdeClase(String usuario, String busqueda) throws InterruptedException {
		WebElement cajaDeBusqueda = driver.findElement(By.cssSelector("input[name='q']"));
		cajaDeBusqueda.sendKeys(busqueda);
		System.out.println("Usuario: " + usuario);
		Thread.sleep(1000);
		
		String input = cajaDeBusqueda.getAttribute("value"); //siempre son value para sacar el texto de cuadros de busqueda
		System.out.println("El texto buscado es: " + input + ", y la busqueda por parametro era: " + busqueda);
		Assert.assertTrue(input.equals(busqueda), "No coinciden");
		cajaDeBusqueda.clear();
	}
	

	@Test(groups = "X", enabled = false, dataProvider = "BuscadorDesdeClase", dataProviderClass = BuscadorDesdeClase.class)
	public void busquedaDesdeClaseConMetodo(String busqueda) throws InterruptedException {
		WebElement cajaDeBusqueda = driver.findElement(By.cssSelector("input[name='q']"));
		cajaDeBusqueda.sendKeys(busqueda);
		Thread.sleep(1000);
		
		String input = cajaDeBusqueda.getAttribute("value"); //siempre son value para sacar el texto de cuadros de busqueda
		System.out.println("El texto buscado es: " + input + ", y la busqueda por parametro era: " + busqueda);
		Assert.assertTrue(input.equals(busqueda), "No coinciden");
		cajaDeBusqueda.clear();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Metodo que se ejecuta despues de cada @Test");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Metodo que se ejecuta despues de la clase");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Metodo que se ejecuta despues del conjunto de pruebas @Test");
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Metodo que se ejecuta despues de una suite de pruebas");
	}
	
	@DataProvider(name = "Buscador")
	public Object[][] getDataProvider(){
		return new Object[][] {
			//{"Atel"} //M = 1 y N = 1 1x1
			{"Atel", "Google"},
			{"Vale", "Facebook"},
			{"Andres", "Instagram"},
			{"Emma", "WhatsApp"}
			//4 iteraciones con 4 usuarios y una busqueda cada uno
		};
	}
	
}
