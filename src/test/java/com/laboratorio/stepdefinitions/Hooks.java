package com.laboratorio.stepdefinitions;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.laboratorio.browsers.ChromeDriverManager;
import com.laboratorio.browsers.DriverManager;
import com.laboratorio.browsers.DriverManagerFactory;
import com.laboratorio.browsers.DriverType;
import com.laboratorio.browsers.EdgeDriverManager;
import com.laboratorio.browsers.FirefoxDriverManager;
import com.laboratorio.browsers.MovilDriverManager;
import com.laboratorio.utils.LogHelper;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	private static final Logger logger = LogHelper.getLogger(Hooks.class);
	private static int numEscenario = 0;
	private static Properties properties;
	private DriverManager driverManager;
	private static WebDriver driver;
	private static boolean apliMovil;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static boolean isApliMovil() {
		return apliMovil;
	}
	
	public static String rutaDefinicionPaginas() {
		if (properties == null) {
			return null;
		}
		
		return properties.getProperty("dir_definicion_paginas");
	}
	
	private static void iniciarNavegador() throws Exception {
		String navegador = properties.getProperty("navegador");
		DriverType driverType = DriverType.valueOf(navegador);
		
		switch (driverType) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			logger.log(Level.INFO, "Se ha seleccionado inicializado la versión actual del ChromeDriver");
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			logger.log(Level.INFO, "Se ha seleccionado inicializado la versión actual del GeckoDriver");
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			logger.log(Level.INFO, "Se ha seleccionado inicializado la versión actual del EdgeDriver");
			break;
		case MOVIL:
			WebDriverManager.chromedriver().setup();
			logger.log(Level.INFO, "Se ha seleccionado inicializado la versión actual del ChromeDriver");
			break;
		default:
			logger.log(Level.SEVERE, "Se ha seleccionado un browser inválido!");
			throw new Exception("Se ha seleccionado un browser inválido!");
		}
	}
	
	@BeforeAll
	public static void setUpTests() {
		logger.log(Level.INFO, "Ejecutando setUpTests()");
		
		numEscenario = 0;
		driver = null;
		
		logger.log(Level.INFO, "Cargando el fichero con la configuración de las pruebas");
		
		try {
			properties = new Properties();
			properties.load(new FileReader("src/test/resources/motortesting.properties"));
			logger.log(Level.INFO, "Se ha Cargado el fichero con la configuración de las pruebas correctamente");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error al recuperar la configuración de las pruebas!");
			properties = null;
		}
		
		try {
			iniciarNavegador();
		} catch (Exception e) {
			System.exit(-1);
		}
	}

	@AfterAll
	public static void tearDownTests() {
		logger.log(Level.INFO, "Ejecutando tearDownTests()");
	}

	@Before
	public void setUpScenario(Scenario scenario) throws Exception {
		numEscenario++;
		logger.log(Level.INFO, "Antes de ejecutar el escenario: " + numEscenario);
		logger.log(Level.INFO, "Iniciando el escenario: " + scenario.getName());
		
		if (properties == null) {
			throw new Exception("No se pudo recuperar la configuración de las pruebas");
		}
		
		logger.log(Level.INFO, "Cargando la configuración asociada al escenario");

		// Leer la configuración: URL, usuarios, navegador, propiedad, ruta
		String pagina = properties.getProperty("pagina");
		String navegador = properties.getProperty("navegador");
		apliMovil = false;
		if (navegador.equals("MOVIL")) {
			apliMovil = true;
		}
		String propiedad =  properties.getProperty("propiedad");
		String rutaDriver = properties.getProperty("ruta_driver");
		
		this.driverManager = DriverManagerFactory.getDriverManager(DriverType.valueOf(navegador));
		// driver = this.driverManager.getDriver(propiedad, rutaDriver);
		driver = this.driverManager.getDriver();
		driver.get(pagina);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDownScenario(Scenario scenario) throws Exception {
		logger.log(Level.INFO, "Despues de ejecutar el escenario: " + numEscenario);
		logger.log(Level.INFO, "Finalizando el escenario: " + scenario.getName());
		
		// Toma de la captura de pantalla
		TakesScreenshot ts = (TakesScreenshot)driver;
		final byte[] screenchot = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenchot, "image/png", scenario.getName());
		
		driverManager.quitDriver();
	}
}