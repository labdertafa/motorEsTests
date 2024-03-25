package com.laboratorio.pom;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.laboratorio.stepdefinitions.Hooks;
import com.laboratorio.utils.LogHelper;

public class BasePage {
	private static final Logger logger = LogHelper.getLogger(BasePage.class);
	private WebDriver driver;
	private String filename;

	public BasePage(WebDriver driver, String filename) {
		this.driver = driver;
		this.filename = filename;
	}

	private Object readJson() throws Exception {
		FileReader reader = null;
		String pagesFilePath = Hooks.rutaDefinicionPaginas() + this.filename;

		try {
			reader = new FileReader(pagesFilePath);

			if (reader != null) {
				logger.log(Level.INFO, "Definición de la página recuperada: " + this.filename);
				JSONParser jsonParser = new JSONParser();
				return jsonParser.parse(reader);
			}

			return null;
		} catch (FileNotFoundException | NullPointerException e) {
			logger.log(Level.SEVERE, "No he podido recuperar la definición de la página: " + pagesFilePath);
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	private JSONObject readEntity(String element) throws Exception {
		JSONObject entity = null;

		JSONObject jsonObject = (JSONObject) this.readJson();
		logger.log(Level.INFO, "Definición recuperada: " + jsonObject.toJSONString());
		entity = (JSONObject) jsonObject.get(element);
		return entity;
	}

	private By getCompleteElement(String element) throws Exception {
		By result = null;
		JSONObject entity = this.readEntity(element);

		String getFieldBy = (String) entity.get("GetFieldBy");
		logger.log(Level.INFO, "Valor recuperado de getFieldBy: " + getFieldBy);
		String valueToFind = (String) entity.get("ValueToFind");
		logger.log(Level.INFO, "Valor recuperado de valueToFind: " + valueToFind);

		switch (getFieldBy) {
		case "className":
			result = By.className(valueToFind);
			break;
		case "cssSelector":
			result = By.cssSelector(valueToFind);
			break;
		case "id":
			result = By.id(valueToFind);
			break;
		case "linkText":
			result = By.linkText(valueToFind);
			break;
		case "name":
			result = By.name(valueToFind);
			break;
		case "partialLinkText":
			result = By.partialLinkText(valueToFind);
			break;
		case "tagName":
			result = By.tagName(valueToFind);
			break;
		case "xpath":
			result = By.xpath(valueToFind);
			break;
		}
		
		logger.log(Level.INFO, "Valor del Locator encontrado: " + result.toString());

		return result;
	}

	// Encontrar un elemento por nombre
	protected WebElement findElement(String elemento) throws Exception {
		By locator;

		try {
			locator = this.getCompleteElement(elemento);
			if (locator == null) {
				throw new Exception("No se pudo encontrar el elemento: " + elemento);
			}
			
			WebElement element = driver.findElement(locator);
			logger.log(Level.INFO, "Valor del elemento encontrado: " + element.toString());
			
			return element;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo encontrar el elemento: " + elemento);
		}
	}

	// Hacer click en un elemento por su nombre
	protected void click(String elemento) throws Exception {
		try {
			WebElement element = this.findElement(elemento);
			element.click();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo hacer click sobre el elemento: " + elemento);
		}
	}

	// Verificar si un elemento está desplegado
	protected boolean isDisplayed(String elemento) throws Exception {
		try {
			WebElement element = this.findElement(elemento);
			return element.isDisplayed();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo encontrar el elemento: " + elemento);
		}
	}

	// Recuperar el texto de un elemento
	protected String getText(String elemento) throws Exception {
		try {
			WebElement element = this.findElement(elemento);
			return element.getText();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo obtener el texto del elemento: " + elemento);
		}
	}

	// Agregar texto a un elemento
	protected void typeText(String elemento, String text) throws Exception {
		try {
			WebElement element = this.findElement(elemento);
			element.sendKeys(text);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo escribir el texto en el elemento: " + elemento);
		}
	}

	// Esperar a que aparezca un elemento del DOM
	protected void waitForElement(String elemento) throws Exception {
		try {
			logger.log(Level.INFO, "Iniciando la espera por el elemento: " + elemento);
			By locator = this.getCompleteElement(elemento);
			if (locator != null) {
				logger.log(Level.INFO, "He encontrado el localizador del elemento: " + elemento);
			} else {
				logger.log(Level.WARNING, "No ha localizador, lanzado excepción");
				throw new Exception("No se encontró el localizador del elemento: " + elemento);
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo ejecutar la espera por el elemento: " + elemento);
		}
	}

	// Obtener el título de la ventana del navegador
	protected String getTitle() throws Exception {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo obtener el título de la página del navegador");
		}
	}
}