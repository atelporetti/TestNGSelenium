package testNG;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.*;					// Edge
import org.openqa.selenium.edge.EdgeDriverService.Builder;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
//*************************************************************
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;	
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {
	// DATOS
	private String urlBase = "";
	private String userName = "";
	private String password = "";
	
	// ENTORNO
	private String nombreNavegador = "EDGE";
	private String locationEdge = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
	private String versionEdge = "87.0.664.60";
	private String driverNavegador = "webdriver.edge.driver";
	private String ubicacionDriver = "C:\\msedgedriver.exe";
	private DesiredCapabilities entorno;
	
	
	public String getNombreNavegador() {
		return nombreNavegador;
	}
	public void setNombreNavegador(String navegador) {
		this.nombreNavegador = navegador;
	}
	
	public String getDriverNavegador() {
		return driverNavegador;
	}
	public void setDriverNavegador(String driverNavegador) {
		this.driverNavegador = driverNavegador;
	}
	
	public String getUbicacionDriver() {
		return ubicacionDriver;
	}
	public void setUbicacionDriver(String ubicacionDriver) {
		this.ubicacionDriver = ubicacionDriver;
	}
	
	public DesiredCapabilities getEntorno() {
		return entorno;
	}
	public void setEntorno(DesiredCapabilities entorno) {
		this.entorno = entorno;
	}
	
	public String getVersionEdge() {
		return versionEdge;
	}
	public void setVersionEdge(String versionEdge) {
		this.versionEdge = versionEdge;
	}

	private int tiempoEspera = 30;
	
	
	public int getTiempoEspera() {
		return tiempoEspera;
	}
	public void setTiempoEspera(int tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLocationEdge() {
		return locationEdge;
	}
	public void setLocationEdge(String locationEdge) {
		this.locationEdge = locationEdge;
	}
	
	public String getUrlBase() {
		return urlBase;
	}
	public void setUrlBase(String url) {
		this.urlBase = url;
	}
	
		
	public Util(String urlBase, String userName, String password, String locationEdge, String versionEdge, int tiempoEspera) {
		super();
		this.urlBase = urlBase;
		this.userName = userName;
		this.password = password;
		this.locationEdge = locationEdge;
		this.versionEdge = versionEdge;
		this.tiempoEspera = tiempoEspera;
	}
	public Util() {}
	
	public static WebDriver setUpAuto(){
		Util datos = new Util();
		EdgeOptions edgeOptions = new EdgeOptions();
		WebDriverManager.edgedriver().browserVersion(datos.getVersionEdge()).setup();;
		WebDriver driver = new EdgeDriver(edgeOptions);	
		
		File pathToBinary = new File(datos.getLocationEdge());
		//FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		return driver;
	}
	
	public static WebDriver setUpManual(){
		Util datos = new Util();
		DesiredCapabilities entorno = DesiredCapabilities.edge();
		entorno.setCapability(CapabilityType.BROWSER_NAME, datos.getNombreNavegador());
		System.setProperty(datos.getDriverNavegador(),datos.getUbicacionDriver());
		EdgeDriverService service = new EdgeDriverService.Builder().usingDriverExecutable(new File(datos.getUbicacionDriver())).usingAnyFreePort().build();
		EdgeOptions opciones = new EdgeOptions();
		//opciones.merge(entorno); MEJORAR LA UNION DE DESIRED CAPABILITIES CON EDGEOPTIONS
		EdgeDriver driver = new EdgeDriver(service, opciones);
		driver.manage().window().maximize();
		return driver;
	}
	
	/*
	public static String[][] getInfoExcel(){
		String nombreArchivo = "testData.xlsx";
		String rutaArchivo = "D:\\Documentos\\MEGA\\PROGRAMACIÓN\\Cursos\\Selenium + Java\\Day03" + nombreArchivo;
		String hoja = "Data";
		String matrizDatos [][] = new String [4][2];
		
		int colInicio = 2, colFin = 3, filaInicio = 2, filaFin = 5;
		
		for (int i=colInicio; i<colFin; i++) {
			for (int j=filaInicio; j<filaFin; j++) {
				
			}
		}
		OPCPackage pkg = OPCPackage.open(new File(nombreArchivo));
		XSSFWorkbook excel = new XSSFWorkbook(pkg);
		XSSFSheet hojaExcel = excel.getSheet(hoja);
		XSSFRow row = hojaExcel.getRow(1);

		
		pkg.close();
		
		return matrizDatos[][];
		
	}
	*/
}