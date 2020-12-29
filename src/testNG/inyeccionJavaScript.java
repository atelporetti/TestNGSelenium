package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class inyeccionJavaScript {
	WebDriver driver = Util.setUpManual();
	private JavascriptExecutor js;
	String pageLoadStatus = "";

	// Resaltar un texto
	private boolean resaltar(WebElement elemento) {
		js = (JavascriptExecutor) driver;
		//for (int i = 0; i < 3; i++) {
			try {
				js.executeScript("arguments[0].setAttribute('style', 'background:yellow')", elemento);
				//Thread.sleep(1000);
				//js.executeScript("arguments[0].setAttribute('style', 'background:')", elemento);
			} catch (Exception e) {
				// Buena practica: se indica la Clase | Metodo | Excepcion
				System.err.println("inyeccionJavaScript | Metodo: resaltar | Excepcion: " + e.getMessage());
				return false;
			}
		//}
		return true;
	}

	// Desplazarse por pagina
	private boolean scrollDown() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 250)");
		} catch (Exception e) {
			System.err.println("inyeccionJavaScript | Metodo: scrollDown | Excepcion: " + e.getMessage());
			return false;
		}
		return true;
	}

	// Cargar pagina
	private boolean paginaCargada() {
		try {
			do {
				js = (JavascriptExecutor) driver;
				pageLoadStatus = (String) js.executeScript("return document.readyState");
			} while (!pageLoadStatus.equals("complete"));
		} catch (Exception e) {
			System.err.println("inyeccionJavaScript | Metodo: paginaCargada | Excepcion: " + e.getMessage());
			return false;
		}
		return true;
	}

	@Test(priority = 0, groups = "A")
	public void irBotonRegister() {
		WebElement botonRegistro = driver.findElement(By.cssSelector("a[href='register.php']"));
		Assert.assertTrue(resaltar(botonRegistro));
		js.executeScript("arguments[0].click();", botonRegistro);
		String titutloEsperado = "Register: Mercury Tours";
		Assert.assertEquals(driver.getTitle(), titutloEsperado);
		Assert.assertTrue(scrollDown());
	}

	@Test(priority = 1, groups = "A")
	public void llenarFormulario() {
		try {
			driver.findElement(By.name("firstName")).sendKeys("Atel");
			driver.findElement(By.name("lastName")).sendKeys("Poretti");

			
			WebElement listaPaises = driver.findElement(By.name("country"));
			new Select(listaPaises).selectByVisibleText("ARGENTINA");
			resaltar(listaPaises);
			WebElement usuario = driver.findElement(By.id("email"));
			resaltar(usuario);
			String email = "juanito@gmail.com";
			usuario.sendKeys(email);
			WebElement pass = driver.findElement(By.name("password"));
			resaltar(pass);
			pass.sendKeys("1234");
			WebElement pass2 = driver.findElement(By.name("confirmPassword"));
			resaltar(pass2);
			pass2.sendKeys("1234");
			WebElement submit = driver.findElement(By.cssSelector("input[type=submit]"));
			resaltar(submit);
			submit.click();

			Assert.assertTrue(paginaCargada());
			resaltar(driver.findElement(By.xpath("//b[contains(text(),'" + email + "')]")));
		} catch (Exception e) {
			System.err.println("inyeccionJavaScript | Metodo: llenarFormulario | Excepcion: " + e.getMessage());
		}
	}

	@BeforeTest(groups = "A")
	public void beforeTest() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/");
	}

	@AfterTest(groups = "A")
	public void afterTest() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

}
