package testNG_Listeners_Reportes;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ModificarReporte.class)
public class PruebaConListeners {
	
	@Test
	public void prueba1() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void prueba2() {
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "prueba2")
	public void prueba3() {
		Assert.assertTrue(true);
	}
}
