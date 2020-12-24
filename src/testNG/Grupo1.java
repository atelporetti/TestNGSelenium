package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Grupo1 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Metodo que se ejecuta antes de una suite de pruebas");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Metodo que se ejecuta antes del conjunto de pruebas @Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Metodo que se ejecuta antes de la clase");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Metodo que se ejecuta antes de cada @Test");
	}
	
	@Test(groups = {"A", "D"})
	public void metodo_a() {
		System.out.println("Grupo 1, Metodo A");
	}
	
	
	@Test(groups = {"B"})
	public void metodo_b() {
		System.out.println("Grupo 1, Metodo B");
	}
	
	
	@Test(groups = {"C"})
	public void metodo_c() {
		System.out.println("Grupo 1, Metodo C");
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
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Metodo que se ejecuta despues de una suite de pruebas");
	}

}
