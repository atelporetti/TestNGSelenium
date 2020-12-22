package testNG;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class BuscadorDesdeClase {
	@DataProvider(name = "BuscadorDesdeClase")
	public Object[][] getDataProvider(Method metodo){
		if (metodo.getName().equalsIgnoreCase("busquedaDesdeClase")) {
			return new Object[][] {
				//{"Atel"} //M = 1 y N = 1 1x1
				{"Mari", "Google"},
				{"Pepe", "Facebook"},
				{"Coni", "Instagram"},
				{"Mauro", "WhatsApp"}
				//4 iteraciones con 4 usuarios y una busqueda cada uno
			};
		}
		else {
			return new Object[][] {
				{"Argentina"},
				{"Francia"},
				{"Brasil"},
				{"EEUU"}
			};
		}
			
	}
}
