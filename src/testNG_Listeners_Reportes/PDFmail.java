package testNG_Listeners_Reportes;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import testNG_Listeners_Reportes.Util;

@Listeners(JyperionListener.class)
public class PDFmail extends Util {
	WebDriver driver = Util.setUpManual();
	
	@Test
	public void pruebaA() {
		driver.get("www.google.com.ar");
		Assert.assertTrue(false);
	}
	
	@Test
	public void pruebaB() {
		driver.get("www.facbeook.com");
		Assert.assertTrue(true);
	}
	
	@Test
	public void pruebaC() {
		driver.get("www.gmail.com");
		Assert.assertTrue(false);
	}
	
	@AfterTest
	public void cerrar() {
		driver.quit();
	}
	
	@AfterSuite
	public void enviarCorreo() {
		enviaEmail("***@gmail.com", "***", "***@gmail.com", "Prueba", "Cuerpo de correo");
	}
	
}
