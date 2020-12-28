package testNG;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class ParametrizacionByITestContext {
	WebDriver driver = Util.setUpManual();	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Metodo que se ejecuta antes de una suite de pruebas");
	}
	
	@BeforeTest(groups = {"A", "B"})
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
	
	@Test(dataProvider = "Buscador", groups = "A", enabled = false)
	public void busquedaA(String usuario, String busqueda) throws InterruptedException {
		WebElement cajaDeBusqueda = driver.findElement(By.cssSelector("input[name='q']"));
		cajaDeBusqueda.sendKeys(busqueda);
		System.out.println("Usuario: " + usuario);
		Thread.sleep(1000);
		
		String input = cajaDeBusqueda.getAttribute("value"); //siempre son value para sacar el texto de cuadros de busqueda
		System.out.println("El texto buscado es: " + input + ", y la busqueda por parametro era: " + busqueda);
		Assert.assertTrue(input.equals(busqueda), "No coinciden");
		cajaDeBusqueda.clear();
	}
	
	@Test(dataProvider = "Buscador", groups = "B", enabled = false)
	public void busquedaB(String busqueda) throws InterruptedException {
		WebElement cajaDeBusqueda = driver.findElement(By.cssSelector("input[name='q']"));
		cajaDeBusqueda.sendKeys(busqueda);
		Thread.sleep(1000);
		
		String input = cajaDeBusqueda.getAttribute("value"); //siempre son value para sacar el texto de cuadros de busqueda
		System.out.println("El texto buscado es: " + input + ", y la busqueda por parametro era: " + busqueda);
		Assert.assertTrue(input.equals(busqueda), "No coinciden");
		cajaDeBusqueda.clear();
	}
	
	
	@Test(dataProvider = "Buscador", groups = "A", enabled = true)
	public void busquedasuarioContraseniaA(String usuario, String busqueda) throws InterruptedException {
		WebElement cajaDeBusqueda = driver.findElement(By.cssSelector("input[name='q']"));
		cajaDeBusqueda.sendKeys(busqueda);
		System.out.println("Usuario: " + usuario);
		Thread.sleep(1000);
		
		String input = cajaDeBusqueda.getAttribute("value"); //siempre son value para sacar el texto de cuadros de busqueda
		System.out.println("El texto buscado es: " + input + ", y la busqueda por parametro era: " + busqueda);
		Assert.assertTrue(input.equals(busqueda), "No coinciden");
		cajaDeBusqueda.clear();
	}
	

	@Test(dataProvider = "Buscador", groups = "B", enabled = true)
	public void busquedasuarioContraseniaB(String busqueda) throws InterruptedException {
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
	
	@AfterTest(groups = {"A"})
	public void afterTest() {
		System.out.println("Metodo que se ejecuta despues del conjunto de pruebas @Test");
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Metodo que se ejecuta despues de una suite de pruebas");
	}
	
	@DataProvider(name = "Buscador")
	public Object[][] getDataProvider(ITestContext contexto){
		Object [][] datos = null;
		for (String grupo : contexto.getIncludedGroups()) {
			if (grupo.equals("A")) {
				datos = new Object [][] {
					{"Atel", "Google"},
					{"Vale", "Facebook"},
					{"Andres", "Instagram"},
					{"Emma", "WhatsApp"}
				};
				break;
			}
			else if (grupo.equals("B")) {
				datos = new Object [][] {
					{"Argentina"},
					{"Francia"},
					{"Brasil"},
					{"EEUU"}
				};
				break;
			}
		}
		return datos;
	}
	
}
